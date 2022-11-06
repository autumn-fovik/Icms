<template>
  <n-card class="app-container" :segmented="{ content : true }">
    <template #header>
      <n-button v-hasPermi="['system:role:add']" type="primary"  @click="dialogs.display = true; dialogs.title = '添加角色'">添加角色</n-button>
    </template>
    <n-data-table :data="dataResources.records" :columns="columns"/>
    <template #footer>
      <n-pagination :page-count="dataResources.pages" :page-sizes="[dataResources.pageSize]" @update:page="turnPages" />
    </template>
    <div>
      <n-modal v-model:show="dialogs.display"  style="width: 37%" :title="dialogs.title" preset="card" v-model:on-after-leave="restFrom">
        <n-form label-width="80px" label-placement="left"  :model="roleData" ref="formRef" :rules="rules">
          <n-grid :cols="2">
              <n-form-item-gi label="角色名" path="roleName" span="24">
                <n-input v-model:value="roleData.roleName"/>
              </n-form-item-gi>
   
              <n-form-item-gi label="权限标识" path="roleKey" span="24">
                <n-input v-model:value="roleData.roleKey"/>
              </n-form-item-gi>

              <n-form-item-gi label="权限" path="menuIds" span="24">
                <n-tree-select
                    v-model:value="roleData.menuIds"

                    :options="menuOptions"
                    key-field="menuId"
                    label-field="menuName"
                    multiple
                    checkable
                    cascade
                    check-strategy="all"
                    max-tag-count="responsive"
                >
                </n-tree-select>
              </n-form-item-gi>
              <n-form-item-gi label="状态" path="status" span="24">
                <n-radio-group v-model:value="roleData.status">
                  <n-radio value="0">正常</n-radio>
                  <n-radio value="1">停用</n-radio>
                </n-radio-group>
              </n-form-item-gi>
              <n-form-item-gi label="备注" span="24">
                <n-input type="textarea"></n-input>
              </n-form-item-gi>
          </n-grid>
          <n-button @click="submitData" type="primary" style="width: 100%;" >提交</n-button>
        </n-form>
      </n-modal>
    </div>
  </n-card>

</template>

<script setup lang="ts">
import {addRole, editRole as editRoleApi, getRole,listRole, pageRole} from "@/apis/roleApi"
import {DataTableColumn, FormInst, NButton} from "naive-ui";
import {listMenu} from "@/apis/menuApi";
import {handleTree} from "@/utils/conversion";
import {list} from "@/apis/userApi";


const dialogs = ref({
  display : false,
  title : "添加"
})

const initGet = () => {
  pageRole(dataResources.value.pageNum, dataResources.value.pageSize).then(resp => {
    dataResources.value = resp.data
  })
  listMenu().then(resp=> {
    menuOptions.value = handleTree(resp.data,"menuId")
  })

}

let dataResources = ref({
  total: 10,
  pages: 1,
  records: [],
  pageSize: 10,
  pageNum: 1
})
initGet()
const columns: Array<DataTableColumn> = [{
  key: "roleId",
  title: "序号"
}, {
  key: "roleName",
  title: "名称"
}, {
  key: "roleKey",
  title: "标识"
}, {
  key: "createTime",
  title: "创建时间"
}, {
  key: "remark",
  title: "备注"
}, {
  key: "",
  title: "操作",
  render: (row: any) => {
    return h("div", {}, [
      h(NButton, {onClick: () => editRole(row.roleId), type: "primary"}, {default: () => "编辑"}),
      h(NButton, {onClick: () => delUser(row), type: "error", style: 'margin-left: 5px;'}, {default: () => "删除"})
    ])
  }
}]

const editRole = (userId: number) => {
  getRole(userId).then(resp => {
    roleData.value = resp.data
    dialogs.value.title = "编辑角色"
    dialogs.value.display = true
  })


}
let roleData = ref({
  menuIds: [],
  remark: undefined,
  roleId: undefined,
  roleKey: undefined,
  roleName: undefined,
  status: undefined,
})
const menuOptions =ref([])
const submitData = () => {
  formRef.value?.validate((errors) => {
    if (!errors) {
      if (roleData.value.roleId == undefined || roleData.value.roleId == "") {
        addRole(roleData.value).then(resp => {
          window.$message?.success("添加成功")
          pageRole(dataResources.value.pageNum, dataResources.value.pageSize).then(resp => {
            dataResources.value = resp.data
          })
          dialogs.value.display = false
        })
      } else {
        editRoleApi(roleData.value).then(resp => {
          window.$message?.success("修改成功")
          pageRole(dataResources.value.pageNum, dataResources.value.pageSize).then(resp => {
            dataResources.value = resp.data
          })
          dialogs.value.display = false
          dialogs.value.title = "添加角色"
        })
      }
    }
  })

}
function restFrom() {
  roleData.value = {
    menuIds: [],
    remark: undefined,
    roleId: undefined,
    roleKey: undefined,
    roleName: undefined,
    status: undefined,
  }

}
const formRef = ref<FormInst | null>(null)
const rules = ref({
  roleKey:{
    required: true,
    message: '权限标识为必填项',
    trigger: 'blur'
  },
  roleName:{
    required: true,
    message: '角色名为必填项',
    trigger: 'blur'
  },
  menuIds:{
    required: true,
    message: '权限为必填项',
    trigger: 'blur',
    type : 'array'
  }
})
// 翻页
const turnPages = (pageNum : number) => {
  list(pageNum, dataResources.value.pageSize).then(resp => {
    dataResources.value = resp.data
  })
}
</script>