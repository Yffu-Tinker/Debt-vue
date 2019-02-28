<template>
  <a-drawer
    title="修改用户"
    :maskClosable="false"
    width=650
    placement="right"
    :closable="false"
    @close="onClose"
    :visible="dataEditVisiable"
    style="height: calc(100% - 55px);overflow: auto;padding-bottom: 53px;">
    <a-form :form="form">
      <a-form-item label='客户名' v-bind="formItemLayout">
        <a-input readOnly v-decorator="['clientName']"/>
      </a-form-item>
      <a-form-item label='客户身份证号' v-bind="formItemLayout">
        <a-input readOnly v-decorator="['clientIdNum']"/>
      </a-form-item>
      <a-form-item label="客户电话" v-bind="formItemLayout">
        <a-input readOnly v-decorator="['clientPhone']"/>
      </a-form-item>
      <a-form-item label='备注信息' v-bind="formItemLayout">
        <a-textarea
          :rows="4"
          v-decorator="[
          'describe']">
        </a-textarea>
      </a-form-item>
    </a-form>
    <div class="drawer-bootom-button">
      <a-popconfirm title="确定放弃编辑？" @confirm="onClose" okText="确定" cancelText="取消">
        <a-button style="margin-right: .8rem">取消</a-button>
      </a-popconfirm>
      <a-button @click="handleSubmit" type="primary" :loading="loading">提交</a-button>
    </div>
  </a-drawer>
</template>
<script>
import {mapState, mapMutations} from 'vuex'

const formItemLayout = {
  labelCol: { span: 3 },
  wrapperCol: { span: 18 }
}
export default {
  name: 'DataEdit',
  props: {
    dataEditVisiable: {
      default: false
    }
  },
  data () {
    return {
      formItemLayout,
      form: this.$form.createForm(this),
      id: '',
      loading: false
    }
  },
  computed: {
    ...mapState({
      currentUser: state => state.account.user
    })
  },
  methods: {
    ...mapMutations({
      setUser: 'account/setUser'
    }),
    onClose () {
      this.loading = false
      this.form.resetFields()
      this.$emit('close')
    },
    setFormValues ({...user}) {
      this.id = user.id
      let fields = ['clientName', 'clientIdNum', 'clientPhone', 'describe']
      Object.keys(user).forEach((key) => {
        if (fields.indexOf(key) !== -1) {
          this.form.getFieldDecorator(key)
          let obj = {}
          obj[key] = user[key]
          this.form.setFieldsValue(obj)
        }
      })
    },
    handleSubmit () {
      this.form.validateFields((err, values) => {
        if (!err) {
          this.loading = true
          let user = this.form.getFieldsValue()
          user.id = this.id
          user.operatorName = this.currentUser.username
          user.operatorId = this.currentUser.id
          this.$put('ddata/update', {
            ...user
          }).then((r) => {
            this.loading = false
            this.$emit('success')
          }).catch(() => {
            this.loading = false
          })
        }
      })
    }
  }
}
</script>
