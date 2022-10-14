<template>
  <n-card class="app-container" :segmented="{content : true}">
    <template #header>
      <n-button type="primary" v-has-permi="['system:user:add']" @click="dialogs.add.display = true">
        <template #icon>
          <SvgIcon icon="AddUser"/>
        </template>
        添加用户
      </n-button>
    </template>
    <n-data-table :columns="columns" :data="TableData.records"></n-data-table>

    <template #footer>
      <n-pagination></n-pagination>
    </template>
    <div class="dialog">
      <n-modal preset="card" :show="dialogs.add.display" title="添加用户" style="width: 30%">
        <n-form label-placement="left">
          <n-grid x-gap="20">
            <n-form-item-gi label="用户名" span="12">
              <n-input/>
            </n-form-item-gi>
            <n-form-item-gi label="邮箱" span="12">
              <n-input/>
            </n-form-item-gi>
          </n-grid>

        </n-form>

      </n-modal>
      <n-modal preset="card" :show="dialogs.edit.display" title="编辑用户" style="width: 30%">
        <n-form label-placement="left" label-width="80px">
          <n-grid x-gap="20">
            <n-form-item-gi label="昵称" span="12">
              <n-input/>
            </n-form-item-gi>
            <n-form-item-gi label="账号名" span="12">
              <n-input/>
            </n-form-item-gi>
          </n-grid>
          <n-grid x-gap="20">
            <n-form-item-gi label="手机号" span="12">
              <n-input/>
            </n-form-item-gi>
            <n-form-item-gi label="邮箱" span="12">
              <n-input/>
            </n-form-item-gi>
          </n-grid>
          <n-grid x-gap="20">
            <n-form-item-gi label="用户状态" span="12">
              <n-radio-group>
                <n-radio>正常</n-radio>
                <n-radio>停用</n-radio>
              </n-radio-group>
            </n-form-item-gi>
            <n-form-item-gi label="邮箱" span="12">
              <n-input/>
            </n-form-item-gi>
          </n-grid>

        </n-form>

      </n-modal>

    </div>
  </n-card>
</template>

<script setup lang="ts">

import type {DataTableColumns} from "naive-ui";
import {list , userStatusEdit as userStatusEditApi} from "@/apis/userApi";
import {NButton, NSwitch, NTag} from "naive-ui";

const dialogs = reactive({
  add: {
    display: false
  },
  userStatus : {
    display : false
  },
  edit : {
    display : false
  }
})

let TableData = ref({
  pageNum: 1,
  pageSize: 11,
  pages: 1,
  records: [],
  total: 13,
})




const createColumns = (): DataTableColumns<any> => {
  return [{
    key: "userId",
    title: "序号"
  }, {
    key: "userName",
    title: "用户名"
  },{
    key: "email",
    title: "邮箱"
  },{
    key: "sex",
    title: "性别",
    render (row : any) {
      return h(NTag, { type : row.sex === "0"? "info" : row.sex  === "1" ? "error" : "warning" }, { default : () => {
        return row.sex === "0"? "男" : row.sex  === "1" ? "女" : "未知"
        } })

    }
  },{
    key: "status",
    title: "状态",
    render (row : any) {
      return h(NSwitch,{ value : row.status === "0" ? true :false , "onUpdate:value" :() => userStatusEdit(row) })
    }
  },{
    key : "",
    title : "操作",
    render (row : any) {

      return h("div", {}, [
        h(NButton, {onClick: () => editUser(row),  type : "primary"}, {default: () => "编辑"}),
        h(NButton, {onClick: () => delUser(row), type: "error", style: 'margin-left: 5px;'}, {default: () => "删除"})
      ])
    }
  }]
}


const columns = createColumns()

const initGet = () => {
  list(TableData.value.pageNum,TableData.value.pageSize).then((resp: any) => {
    TableData.value = resp.data
  })

}


initGet()




const delUser = (row : any) => {
  window.$message?.loading("sss")


}
const userStatusEdit = (row : any)=>{
  window.$dialog?.info({
    title : "状态更新",
    content : "是否更新用户 < "+row.userName+" > 为 < " + (row.status === '0' ? "禁用": "启用")+" >",
    positiveText : "确认",
    negativeText : "取消",
    onPositiveClick : () => {
      userStatusEditApi(row.userId,row.status === "0"? "1" : "0").then(resp=>{
        if (resp.code === 200){
          window.$message?.success("状态更新成功")
          if (row.status === "0"){
            row.status = "1"
          }else {
            row.status = "0"
          }
        }else {
          window.$message?.error(resp.msg)
          // window.$message?.error("状态更新失败！")
        }

      })


    }
  })

}
const editUser =(row : any) => {
  dialogs.edit.display = true
}
</script>

<style scoped>

</style>