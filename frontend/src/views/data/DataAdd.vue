<template>
  <a-drawer
    title="新增定时任务"
    :maskClosable="false"
    width=650
    placement="right"
    :closable="false"
    @close="onClose"
    :visible="dataAddVisiable"
    style="height: calc(100% - 55px);overflow: auto;padding-bottom: 53px;">
    <a-form :form="form">
      <a-form-item label='客户名称' v-bind="formItemLayout">
        <a-input style="width: 100%"
                 v-model="user.clientName"
                 v-decorator="['clientName',
                   {rules: [
                    { required: true, message: '客户名称不能为空'},
                    { max: 20, message: '长度不能超过10个字'}
                  ]}]"/>
      </a-form-item>
      <a-form-item label='客户身份证号' v-bind="formItemLayout">
        <a-input v-model="user.clientIdNum"
                 v-decorator="['clientIdNum',
                   {rules: [
                    { max: 18, message: '长度不能超过18个字'}
                  ]}]"/>
      </a-form-item>
      <a-form-item label='客户电话' v-bind="formItemLayout">
        <a-input v-model="user.clientPhone"
                 v-decorator="['clientPhone',
                   {rules: [
                    { required: true, message: '电话不能为空'},
                    { pattern: '^0?(13[0-9]|15[012356789]|17[013678]|18[0-9]|14[57])[0-9]{8}$', message: '请输入正确的手机号'}
                  ]}]"/>
      </a-form-item>
      <a-form-item label='备注信息' v-bind="formItemLayout">
        <a-textarea
          :rows="4"
          v-model="user.describe">
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
  const formItemLayout = {
    labelCol: { span: 4 },
    wrapperCol: { span: 18 }
  }
  export default {
    name: 'DataAdd',
    props: {
      dataAddVisiable: {
        default: false
      }
    },
    data () {
      return {
        loading: false,
        formItemLayout,
        form: this.$form.createForm(this),
        user: {
          clientName: '',
          clientIdNum:'',
          clientPhone:'',
          describe:''
        },
        validateStatus: '',
        help: ''
      }
    },
    methods: {
      reset () {
        this.loading = false;
        this.validateStatus = this.help = '';
        this.user =  {
          clientName: '',
          clientIdNum:'',
          clientPhone:'',
          describe:''
        };
        this.form.resetFields()
      },
      onClose () {
        this.reset()
        this.$emit('close')
      },
      handleSubmit () {
        this.form.validateFields((err, values) => {
          if (!err) {
            this.$post('ddata/create', {
              ...this.user
            }).then(() => {
              this.reset()
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
