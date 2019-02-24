<template>
  <a-drawer
    title="分配客户数据"
    :maskClosable="false"
    width=650
    placement="right"
    :closable="false"
    @close="onClose"
    :visible="dataDistributeVisiable"
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
      <a-form-item label='分配对象选择'
                   style="margin-bottom: 2rem"
                   v-bind="formItemLayout">
        <a-tree
          :key="userTreeKey"
          :checkable="true"
          :checkStrictly="checkStrictly"
          @check="handleCheck"
          @expand="handleExpand"
          :expandedKeys="expandedKeys"
          :treeData="userTreeData"
          :multiple="multiple">
        </a-tree>
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
  name: 'DataDistribute',
  props: {
    dataDistributeVisiable: {
      default: false
    }
  },
  data () {
    return {
      formItemLayout,
      form: this.$form.createForm(this),
      id: '',
      multiple:false,
      loading: false,
      oper: {},
      checkedKeys: [],
      expandedKeys: [],
      userTreeData: [],
      userTreeKeys: +new Date()
    }
  },
  methods: {
    reset () {
      this.loading = false
      this.userTreeKeys = +new Date()
      this.expandedKeys = this.checkedKeys = []
      this.oper = {}
      this.form.resetFields()
    },
    onClose () {
      this.loading = false
      this.reset()
      this.$emit('close')
    },
    handleCheck (checkedKeys) {
      this.checkedKeys = checkedKeys
    },
    handleExpand (expandedKeys) {
      this.expandedKeys = expandedKeys
    },
    setFormValues ({...user}) {
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
      let checkedArr = Object.is(this.checkedKeys.checked, undefined) ? this.checkedKeys : this.checkedKeys.checked
      if (checkedArr.length > 1) {
        this.$message.error('最多只能选择一个用户，请修改')
        return
      }
      this.form.validateFields((err, values) => {
        if (!err) {
          this.loading = true
          let user = this.form.getFieldsValue()
          this.$put('ddata/update', {
            id:checkedArr[0]
          }).then((r) => {
            this.loading = false
            this.$emit('success')
          }).catch(() => {
            this.loading = false
          })
        }
      })
    }
  },
  watch: {
    dataDistributeVisiable () {
      if (this.dataDistributeVisiable) {
        this.$get('user').then((r) => {
          this.userTreeData = r.data.rows.children
          this.userTreeKey = +new Date()
        })
      }
    }
  }
}
</script>
