<template>
  <div :class="[multipage === true ? 'multi-page':'single-page', 'not-menu-page', 'home-page']">
    <a-row :gutter="8" class="head-info">
      <a-card class="head-info-card">
        <a-col :span="12">
          <div class="head-info-avatar">
            <img alt="头像" :src="avatar">
          </div>
          <div class="head-info-count">
            <div class="head-info-welcome">
              {{welcomeMessage}}
            </div>
            <div class="head-info-desc">
              <p>{{user.deptName ? user.deptName : '暂无部门'}} | {{user.roleName ? user.roleName : '暂无角色'}}</p>
            </div>
            <div class="head-info-time">上次登录时间：{{user.lastLoginTime ? user.lastLoginTime : '第一次访问系统'}}</div>
          </div>
        </a-col>
        <a-col :span="12">
          <div>
            <a-row class="more-info">
              <a-col :span="4"></a-col>
              <a-col :span="4"></a-col>
              <a-col :span="4"></a-col>
              <a-col :span="4">
                <head-info title="本月完成数" :content="month" :center="false" :bordered="false"/>
              </a-col>
              <a-col :span="4">
                <head-info title="总完成数" :content="total" :center="false" :bordered="false"/>
              </a-col>
            </a-row>
          </div>
        </a-col>
      </a-card>
    </a-row>
    <a-row :gutter="8" class="count-info">
     <!-- <a-col :span="12" class="visit-count-wrapper">
        <a-card class="visit-count">
          <apexchart ref="count" type=bar height=300 :options="chartOptions" :series="series" />
        </a-card>
      </a-col>-->
      <a-col class="project-wrapper">
        <!--<a-card title="进行中的项目" class="project-card">-->
          <div class="operator">
            <a-button v-hasPermission="'role:add'" ghost type="primary" @click="add">新增</a-button>
            <!--<a-dropdown v-hasPermission="'role:export'">
              <a-menu slot="overlay">
                <a-menu-item key="export-data" @click="exprotExccel">导出Excel</a-menu-item>
              </a-menu>
              <a-button>
                更多操作 <a-icon type="down" />
              </a-button>
            </a-dropdown>-->
            <!-- 表格区域 -->
            <a-table ref="TableInfo"
                     :columns="columns"
                     :dataSource="dataSource"
                     :pagination="pagination"
                     :loading="loading"
                     :scroll="{ x: 900 }"
                     @change="handleTableChange">
              <template slot="remark" slot-scope="text, record">
                <a-popover placement="topLeft">
                  <template slot="content">
                    <div style="max-width: 200px">{{text}}</div>
                  </template>
                  <p style="width: 200px;margin-bottom: 0">{{text}}</p>
                </a-popover>
              </template>
              <template slot="operation" slot-scope="text, record">
                <a-icon type="eye" theme="twoTone" v-show="record.status" twoToneColor="#4a9ff5" @click="finish(record)" title="完成"></a-icon>
                &nbsp;
                <a-icon type="eye" theme="twoTone" v-show="record.status" twoToneColor="#42b983" @click="edit(record)" title="查看"></a-icon>
                <a-icon type="eye" theme="twoTone" v-show="record.status" twoToneColor="#42b983" @click="distribute(record)" title="分配"></a-icon>
              </template>
            </a-table>
            <!-- 新增数据 -->
            <data-add
              @close="handleDataAddClose"
              @success="handleDataAddSuccess">
            </data-add>
            <!-- 修改用户 -->
            <data-edit
              ref="userEdit"
              @close="handleDataEditClose"
              @success="handleDataEditSuccess"
              :dataEditVisiable="dataEdit.visiable">
            </data-edit>
            <!--分配用户 -->
            <data-edit
              ref="userDistribute"
              @close="handleDataEditClose"
              @success="handleDataEditSuccess"
              :dataDistributeVisiable="dataDistribute.visiable">
            </data-edit>
          </div>
        <!--</a-card>-->
      </a-col>
    </a-row>
  </div>
</template>
<script>
import HeadInfo from '@/views/common/HeadInfo'
import DataAdd from '@/views/data/DataAdd'
import DataEdit from '@/views/data/DataEdit'
import DataDistribute from '@/views/data/DataDistribute'
import {mapState} from 'vuex'
import moment from 'moment'
moment.locale('zh-cn');

export default {
  name: 'HomePage',
  components: {HeadInfo,DataAdd,DataEdit,DataDistribute},
  data () {
    return {
      month: '',
      total: '',
      userRole: '',
      userDept: '',
      lastLoginTime: '',
      welcomeMessage: '',
      dataAdd: {
        visiable: false
      },
      dataEdit: {
        visiable: false
      },
      dataDistribute: {
        visiable: false
      },
      dataSource: [],
      sortedInfo: null,
      paginationInfo: null,
      pagination: {
        pageSizeOptions: ['10', '20', '30', '40', '100'],
        defaultCurrent: 1,
        defaultPageSize: 10,
        showQuickJumper: true,
        showSizeChanger: true,
        showTotal: (total, range) => `显示 ${range[0]} ~ ${range[1]} 条记录，共 ${total} 条记录`
      },
      loading: false,
      showFinishBtn:false,
      showViewBtn:false
    }
  },
  computed: {
    ...mapState({
      multipage: state => state.setting.multipage,
      user: state => state.account.user
    }),
    avatar () {
      return `static/avatar/${this.user.avatar}`
    },
    columns () {
      let { sortedInfo, filteredInfo } = this;
      sortedInfo = sortedInfo || {};
      filteredInfo = filteredInfo || {};
      return [{
        title: '客户名称',
        dataIndex: 'clientName'
      }, {
        title: '客户身份证',
        dataIndex: 'clientIdNum'
      }, {
        title: '客户电话号码',
        dataIndex: 'clientPhone'
      }, {
        title: '备注',
        dataIndex: 'describe',
        scopedSlots: { customRender: 'remark' },
        width: 350
      }, {
        title: '状态',
        dataIndex: 'dataStatus',
        customRender: (text, row, index) => {
          switch (text) {
            case 'dist':
              return '<a-tag color="orange">未完成</a-tag>'
            case 'finish':
              return '<a-tag color="green">完成</a-tag>'
            default:
              return text
          }
        },
        filters: [
        { text: '未完成', value: 'dist' },
        { text: '完成', value: 'finish' }
      ],
        filterMultiple: false,
        filteredValue: filteredInfo.dataStatus || null,
        onFilter: (value, record) => record.dataStatus.includes(value)
      }, {
        title: '操作',
        dataIndex: 'operation',
        scopedSlots: { customRender: 'operation' }
      }]
    }
  },
  methods: {
    welcome() {
      const date = new Date()
      const hour = date.getHours()
      let time = hour < 6 ? '早上好' : (hour <= 11 ? '上午好' : (hour <= 13 ? '中午好' : (hour <= 18 ? '下午好' : '晚上好')))
      let welcomeArr = [
        '喝杯咖啡休息下吧☕',
        '几天没见又更好看了呢',
        '今天您微笑了吗😊',
        '今天帮助别人解决问题了吗'
      ]
      let index = Math.floor((Math.random() * welcomeArr.length))
      return `${time}，${this.user.username}，${welcomeArr[index]}`
    },
    mounted () {
      this.welcomeMessage = this.welcome()
      this.$get(`index/${this.user.id}`).then((r) => {
        let data = r.data.data
        this.month = data.month
        this.total = data.total
      }).catch((r) => {
        console.error(r)
        this.$message.error('获取首页信息失败')
      })
      this.fetch()
    },
    handleTableChange (pagination, filters, sorter) {
      // 将这三个参数赋值给Vue data，用于后续使用
      this.paginationInfo = pagination
      this.filteredInfo = filters
      this.sortedInfo = sorter

      this.fetch({
        sortField: sorter.field,
        sortOrder: sorter.order,
        ...filters
      })
    },
    distribute(){
      this.dataDistribute.visiable = true
    },
    handleDataAddClose () {
      this.dataDistribute.visiable = false
    },
    handleDataAddSuccess () {
      this.dataDistribute.visiable = false
      this.$message.success('分配成功')
      this.search()
    },
    add () {
      this.dataAdd.visiable = true
    },
    handleDataAddClose () {
      this.dataAdd.visiable = false
    },
    handleDataAddSuccess () {
      this.dataAdd.visiable = false
      this.$message.success('新增数据成功')
      this.search()
    },
    edit ( record ) {
      this.$refs.dataEdit.setFormValues(record)
      this.dataEdit.visiable = true
    },
    handleDataEditClose () {
      this.dataEdit.visiable = false
    },
    handleDataEditSuccess () {
      this.dataEdit.visiable = false
      this.$message.success('操作成功')
    },
    finish ( record ) {
      this.$put('user', {
        recordId: record.id,
        userId: this.user.id
      }).then((r) => {
        this.$message.success('操作成功')
        this.fetch()
      }).catch(() => {
        this.$message.success('操作失败')
        this.fetch()
      })
    },
    search () {
      let {sortedInfo, filteredInfo} = this
      let sortField, sortOrder
      // 获取当前列的排序和列的过滤规则
      if (sortedInfo) {
        sortField = sortedInfo.field
        sortOrder = sortedInfo.order
      }
      this.fetch({
        sortField: sortField,
        sortOrder: sortOrder,
        ...filteredInfo
      })
    },
    fetch ( params = {}) {
      // 显示loading
      this.loading = true
      params.id = this.user.id
      if (this.paginationInfo) {
        // 如果分页信息不为空，则设置表格当前第几页，每页条数，并设置查询分页参数
        this.$refs.TableInfo.pagination.current = this.paginationInfo.current
        this.$refs.TableInfo.pagination.pageSize = this.paginationInfo.pageSize
        params.pageSize = this.paginationInfo.pageSize
        params.pageNum = this.paginationInfo.current
      } else {
        // 如果分页信息为空，则设置为默认值
        params.pageSize = this.pagination.defaultPageSize
        params.pageNum = this.pagination.defaultCurrent
      }
      this.$get('ddata', {
        ...params
      }).then((r) => {
        let data = r.data
        const pagination = {...this.pagination}
        pagination.total = data.total
        this.dataSource = data.rows
        this.pagination = pagination
        // 数据加载完毕，关闭loading
        this.loading = false
      })
    }
  }
}
</script>
<style lang="less">
  .home-page {
    .head-info {
      margin-bottom: .5rem;
      .head-info-card {
        padding: .5rem;
        border-color: #f1f1f1;
        .head-info-avatar {
          display: inline-block;
          float: left;
          margin-right: 1rem;
          img {
            width: 5rem;
            border-radius: 2px;
          }
        }
        .head-info-count {
          display: inline-block;
          float: left;
          .head-info-welcome {
            font-size: 1.05rem;
            margin-bottom: .1rem;
          }
          .head-info-desc {
            color: rgba(0, 0, 0, 0.45);
            font-size: .8rem;
            padding: .2rem 0;
            p {
              margin-bottom: 0;
            }
          }
          .head-info-time {
            color: rgba(0, 0, 0, 0.45);
            font-size: .8rem;
            padding: .2rem 0;
          }
        }
      }
    }
    .count-info {
      .visit-count-wrapper {
        padding-left: 0 !important;
        .visit-count {
          padding: .5rem;
          border-color: #f1f1f1;
          .ant-card-body {
            padding: .5rem 1rem !important;
          }
        }
      }
      .project-wrapper {
        padding-right: 0 !important;
        .project-card {
          border: none !important;
          .ant-card-head {
            border-left: 1px solid #f1f1f1 !important;
            border-top: 1px solid #f1f1f1 !important;
            border-right: 1px solid #f1f1f1 !important;
          }
          .ant-card-body {
            padding: 0 !important;
            table {
              width: 100%;
              td {
                width: 50%;
                border: 1px solid #f1f1f1;
                padding: .6rem;
                .project-avatar-wrapper {
                  display:inline-block;
                  float:left;
                  margin-right:.7rem;
                  .project-avatar {
                    color: #42b983;
                    background-color: #d6f8b8;
                  }
                }
              }
            }
          }
          .project-detail {
            display:inline-block;
            float:left;
            text-align:left;
            width: 78%;
            .project-name {
              font-size:.9rem;
              margin-top:-2px;
              font-weight:600;
            }
            .project-desc {
              color:rgba(0, 0, 0, 0.45);
              p {
                margin-bottom:0;
                font-size:.6rem;
                white-space:normal;
              }
            }
          }
        }
      }
    }
  }
  @import "../../static/less/Common";
</style>
