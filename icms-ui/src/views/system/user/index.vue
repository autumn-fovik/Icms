<template>
  <n-card class="app-container" :segmented="{ content : true }">
    <template #header>
      <n-button type="primary" @click="dialogs.display = true; dialogs.title = '添加用户'">
        添加用户
      </n-button>
      <n-button type="primary" @click="search.display = true" style="margin-left: 10px">
        高级搜索
      </n-button>
      <n-button type="primary" @click="queryParameters.userName = null; queryParameters.email = null;initGet()"
                style="margin-left: 10px">
        清空搜索条件
      </n-button>
    </template>
    <n-data-table :data="dataResources.records" :columns="column" max-height="100%"/>
    <template #footer>
      <n-pagination :page-count="dataResources.pages" :page-sizes="[dataResources.pageSize]" @update:page="turnPages"/>
    </template>
    <div>
      <n-modal v-model:show="dialogs.display" :title="dialogs.title" preset="card" style="width: 37%"
               v-model:on-after-leave="restFrom">
        <n-form label-placement="left" label-width="80px" :model="userData" ref="formRef" :rules="rules">
          <n-grid :cols="2">
            <n-form-item-gi label="用户名" path="userName">
              <n-input v-model:value="userData.userName"/>
            </n-form-item-gi>
            <n-form-item-gi label="昵称" path="nickName">
              <n-input v-model:value="userData.nickName"/>
            </n-form-item-gi>
            <n-form-item-gi label="邮箱" path="email">
              <n-auto-complete v-model:value="userData.email" :options="emailOptions" placeholder="邮箱"/>
            </n-form-item-gi>
            <n-form-item-gi label="性别" path="sex">
              <n-select v-model:value="userData.sex" :options="sexOptions"/>
            </n-form-item-gi>
            <n-form-item-gi span="24" label="角色" path="roleIds">
              <n-select v-model:value="userData.roleIds" value-field="roleId" multiple label-field="roleName"
                        :options="roleOptions"/>
            </n-form-item-gi>
            <n-form-item-gi span="24" label="状态" path="status">
              <n-radio-group v-model:value="userData.status">
                <n-radio value="0">正常</n-radio>
                <n-radio value="1">停用</n-radio>
              </n-radio-group>
            </n-form-item-gi>
            <n-form-item-gi span="24" label="备注" path="remark">
              <n-input type="textarea" v-model:value="userData.remark"/>
            </n-form-item-gi>
          </n-grid>
          <n-button style="width: 100%;" type="info" @click="submitData">提交</n-button>
        </n-form>
      </n-modal>
      <n-modal :title="search.title" v-model:show="search.display" preset="card" style="width: 40%">
        <n-form label-placement="left">
          <n-grid cols="2" x-gap="20">
            <n-form-item-gi label="用户名">
              <n-input v-model:value="queryParameters.userName"/>
            </n-form-item-gi>
            <n-form-item-gi label="邮箱">
              <n-input v-model:value="queryParameters.email"/>
            </n-form-item-gi>
            <n-form-item-gi span="2">
              <n-button type="primary" style="width: 100%;" @click="initGet(); search.display = false">搜索</n-button>
            </n-form-item-gi>
          </n-grid>
        </n-form>

      </n-modal>

    </div>
  </n-card>
</template>

<script setup lang="ts">
import {
  listUser,
  userStatusEdit as userStatusEditApi,
  getUserByUserId,
  editUser as editUserApi,
  addUser,
    delUser as delUserApi
} from "@/apis/userApi"
import {DataTableColumn, FormInst, NButton, NEllipsis, NSwitch, NTag,NInput} from "naive-ui";
import {listRole} from "@/apis/roleApi";


// 弹框控制属性
const dialogs = reactive({
  display: false,
  title: "添加用户"
})
const search = reactive({
  display: false,
  title: "搜索"
})

// 表格数据
let dataResources = ref({
  total: 10,
  pages: 1,
  records: [],
  pageSize: 10,
  pageNum: 1
})
const queryParameters = reactive({
  pageNum: 1,
  pageSize: 10,
  userName: null,
  email: null
})
// 表格列
const column: Array<DataTableColumn> = [{
  key: "userId",
  title: "序号",
  minWidth: "200px",
  render: (row: any) => {
    return h(NEllipsis, {style: "max-width: 200px"}, {default: () => `${row.userId}`})
  }
}, {
  key: "userName",
  title: "用户名"
}, {
  key: "email",
  title: "邮箱"
}, {
  key: "sex",
  title: "性别",
  render(row: any) {
    return h(NTag, {type: row.sex === "0" ? "info" : row.sex === "1" ? "error" : "warning"}, {
      default: () => {
        return row.sex === "0" ? "男" : row.sex === "1" ? "女" : "未知"
      }
    })

  }
}, {
  key: "status",
  title: "状态",
  render(row: any) {
    return h(NSwitch, {value: row.status === "0" ? true : false, "onUpdate:value": () => userStatusEdit(row)})
  }
},{
  key: "delFlag",
  title: "删除标识",
  render(row: any) {
    return h(NTag, { type : row.delFlag === "0" ? "success" : "warning"},{default : () => { return row.delFlag === "0" ? "正常" : "异常" }})
  }
}, {
  key: "",
  title: "操作",
  render(row: any) {

    return h("div", {}, [
      h(NButton, {onClick: () => editUser(row.userId), type: "primary"}, {default: () => "编辑"}),
      h(NButton, {
        onClick: () => delUser(row.userId),
        type: "error",
        style: 'margin-left: 5px;'
      }, {default: () => "删除"})
    ])
  }
}]
// 用户数据
let userData = ref<UserEntity>({
  userId: "",
  userName: "",
  nickName: "",
  email: "",
  sex: "2",
  password: "",
  status: "0",
  remark: "",
  roleIds: []
})
// 数据初始化
const initGet = () => {
  listUser(queryParameters).then((resp: any) => {
    dataResources.value = resp.data
  })
  listRole().then(resp => {
    roleOptions.value = resp.data
  })

}
initGet()

// 更改用户状态
const userStatusEdit = (row: any) => {
  window.$dialog?.info({
    title: "状态更新",
    content: "是否更新用户 < " + row.userName + " > 为 < " + (row.status === '0' ? "禁用" : "启用") + " >",
    positiveText: "确认",
    negativeText: "取消",
    onPositiveClick: () => {
      userStatusEditApi(row.userId, row.status === "0" ? "1" : "0").then(resp => {
        if (resp.code === 200) {
          window.$message?.success("状态更新成功")
          if (row.status === "0") {
            row.status = "1"
          } else {
            row.status = "0"
          }
        } else {
          window.$message?.error(resp.msg)
          // window.$message?.error("状态更新失败！")
        }

      })
    }
  })
}

// 角色数据
const roleOptions = ref([])
// 性别数据
const sexOptions = ref([{
  label: '男',
  value: '0'
}, {
  label: '女',
  value: '1'
}, {
  label: '未知',
  value: '2'
}])

// 编辑用户
const editUser = (id: string) => {
  getUserByUserId(id).then((resp: any) => {
    userData.value = resp.data
    dialogs.display = true;
    dialogs.title = "编辑用户"

  })

}

const delUser = (id: string) => {
  const remarks = ref<string>("")
  window.$dialog?.info({
    title: '请输入删除原因',
    content: () => {
      return h(NInput,{ value : remarks.value , "onUpdate:value" : (val) => { remarks.value = val } ,style : "  margin-top: 20px;" },{default : () => ""})
    },
    positiveText: '确认',
    onPositiveClick: () => {
      delUserApi(id,remarks.value).then((resp)=>{
        if (resp.code == 200)
          window.$message?.success("删除成功")
        initGet()
      })

    }

  })
}

const emailOptions = computed(() => {
  return ['@gmail.com', '@163.com', '@qq.com'].map((suffix) => {
    const prefix = userData.value.email.split('@')[0]
    return {
      label: prefix + suffix,
      value: prefix + suffix
    }
  })
})


const submitData = () => {
  formRef.value?.validate((errors) => {
    if (!errors) {
      if (userData.value.userId == undefined || userData.value.userId == "") {
        addUser(userData.value).then(resp => {
          if (resp.code == 200) {
            window.$message?.success("添加成功")
            listUser(queryParameters).then(resp => {
              dataResources.value = resp.data
            })
            dialogs.display = false
          } else {
            window.$message?.warning(resp.msg)
          }
        })
      } else {
        editUserApi(userData.value).then(resp => {
          if (resp.code == 200) {
            window.$message?.success("修改成功")
            listUser(queryParameters).then(resp => {
              dataResources.value = resp.data
            })
            dialogs.display = false
            dialogs.title = "添加用户"
          } else {
            window.$message?.warning(resp.msg)
          }

        })
      }
    }
  })

}
// 翻页
const turnPages = (pageNum: number) => {
  queryParameters.pageNum = pageNum
  listUser(queryParameters).then(resp => {
    dataResources.value = resp.data
  })

}
// 表单重置
const restFrom = () => {
  userData.value = {
    userId: "",
    userName: "",
    nickName: "",
    email: "",
    sex: "2",
    password: "",
    status: "0",
    remark: "",
    roleIds: []
  }

}
const formRef = ref<FormInst | null>(null)
const rules = ref({
  userName: {
    required: true,
    message: '用户名为必填项',
    trigger: 'blur'
  },
  email: {
    required: true,
    message: '邮箱为必填项',
    trigger: 'blur',
    type: 'email'
  },
  roleIds: {
    required: true,
    message: '角色为必填项',
    trigger: 'blur',
    type: 'array'
  }
})

</script>

<style scoped>
</style>