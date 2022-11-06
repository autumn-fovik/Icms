<template>
  <n-card class="app-container" :segmented="{content : true}">
    <template #header>
      <n-button type="primary" @click="dialogs.display = true; dialogs.title = '添加菜单'">添加菜单</n-button>
    </template>
    <n-data-table :data="dataResources" :columns="column" :row-key="rowKey" :bordered="false"/>
    <div>
      <n-modal v-model:show="dialogs.display" :title="dialogs.title" preset="card" style="width: 37%" v-model:on-after-leave="restFrom">
        <n-form label-placement="left" label-width="80px" :model="menuData" ref="formRef" :rules="rules">
          <n-grid :cols="2">
            <n-form-item-gi label="父级菜单" path="parentId" span="24">
              <n-tree-select v-model:value="menuData.parentId" key-field="menuId" label-field="menuName" :options="treeOptions" />
            </n-form-item-gi>
            <n-form-item-gi label="菜单名称" path="menuName" span="24">
              <n-input v-model:value="menuData.menuName"/>
            </n-form-item-gi>
            <n-form-item-gi label="显示顺序" path="orderNum" span="24">
              <n-input-number v-model:value="menuData.orderNum" style="width: 100%" :min="0" :max="100"/>
            </n-form-item-gi>
            <n-form-item-gi label="菜单类型" path="menuType" span="24">
              <n-radio-group v-model:value="menuData.menuType">
                <n-space>
                  <n-radio value="M">目录</n-radio>
                  <n-radio value="C">菜单</n-radio>
                  <n-radio value="F">按钮</n-radio>
                </n-space>
              </n-radio-group>
            </n-form-item-gi>
            <n-form-item-gi label="图标" path="icon" v-if="menuData.menuType !== 'F'" span="24">
              <n-input v-model:value="menuData.icon"/>
            </n-form-item-gi>
            <n-form-item-gi label="路由地址" path="path" v-if="menuData.menuType !== 'F'" span="24">
              <n-input v-model:value="menuData.path"/>
            </n-form-item-gi>
            <n-form-item-gi label="权限标识" path="perms" span="24">
              <n-input v-model:value="menuData.perms"/>
            </n-form-item-gi>
            <n-form-item-gi label="组件路径" path="component" v-if="menuData.menuType === 'C'" span="24">
              <n-input v-model:value="menuData.component"/>
            </n-form-item-gi>



          </n-grid>
          <n-button type="primary" @click="submitData" style="width: 100%;">提交</n-button>
        </n-form>
      </n-modal>

    </div>
  </n-card>

</template>

<script setup lang="ts">

import {DataTableColumn, FormInst, NButton, NTag} from "naive-ui";
import {addMenu, editMenu as editMenuApi, getMenu, listMenu} from "@/apis/menuApi";
import SvgIcon from "@/components/SvgIcon/index.vue";
import {handleTree} from "@/utils/conversion";


// 弹框控制属性
const dialogs = reactive({
  display: false,
  title: "添加菜单"
})

// 表格数据
let dataResources  = ref([] as Array<any>) as any
// 表格列
const column: Array<DataTableColumn> = [{
  key: "menuId",
  title: "序号"
}, {
  key: "icon",
  title: "图标",
  render(row: any) {
    if (row.icon != "")
      return h(SvgIcon, {icon: row.icon})

  }
}, {
  key: "menuName",
  title: "名称"
}, {
  key: "perms",
  title: "权限标识",
  render : (row : any) => {
   if (row.perms == null || row.perms == ""   )
     return h(NTag, {type : "info"}, {default: () => "无权限标识"})
   else
     return h(NTag, {type : "info"}, {default: () => `${row.perms}`})
  }
}, {
  title: '菜单类型',
  key: 'menuType',
  render: (row: any) => {
    return h(NTag, {type: row.menuType === "M" ? "info" : row.menuType === "C" ? "error" : "warning"}, {
      default: () => {
        return row.menuType === "M" ? "目录" : row.menuType === "C" ? "菜单" : "按钮"
      }
    })

  }
}, {
  key: "",
  title: "操作",
  render(row: any) {

    return h("div", {}, [
      h(NButton, {onClick: () => editMenu(row.menuId), type: "primary"}, {default: () => "编辑"}),
      // h(NButton, {onClick: () => delUser(row), type: "error", style: 'margin-left: 5px;'}, {default: () => "删除"})
    ])
  }
}]

// 数据初始化
const initGet = () => {
  listMenu().then((resp: any) => {
    dataResources.value = handleTree(resp.data, "menuId")
    const menu = { menuId: 0, menuName: '主类目', children: [] } as any  ;
    menu.children = handleTree(resp.data, "menuId") as never[];
    treeOptions.value.push( menu as never);
  })


}
initGet()
const treeOptions = ref([]) as any
const rowKey = (row: any) => row.menuId;

const editMenu = (id: number) => {
  getMenu(id).then(resp => {
    menuData.value = resp.data
    dialogs.display = true
    dialogs.title = "编辑菜单"

  })


}

let menuData = ref({
  menuId: undefined,
  menuName: "",
  parentId: 0,
  menuType: "M",
  icon: "",
  component: "",
  path: "",
  perms: "",
  orderNum: 1
})

function submitData() {
  formRef.value?.validate((errors) => {
    if (!errors) {
      if (menuData.value.menuId == undefined || menuData.value.menuId == "") {
        addMenu(menuData.value).then(() => {
          window.$message?.success("添加成功")
          listMenu().then(resp => {
            dataResources.value = handleTree(resp.data, "menuId")
          })
          dialogs.display = false
        })
      } else {
        editMenuApi(menuData.value).then(() => {
          window.$message?.success("修改成功")
          listMenu().then(resp => {
            dataResources.value = handleTree(resp.data, "menuId")
          })
          dialogs.display = false
          dialogs.title = "添加菜单"
        })

      }
    }
  })


}
const restFrom = ()=> {
  menuData.value = {
    menuId: undefined,
    menuName: "",
    parentId: 0,
    menuType: "M",
    icon: "",
    component: "",
    path: "",
    perms: "",
    orderNum: 1
  }

}

const formRef = ref<FormInst | null>(null)

const rules = ref({
  menuName:{
    required: true,
    message: '菜单名为必填项',
    trigger: 'blur'
  },
  icon:{
    required: true,
    message: '图标为必填项',
    trigger: 'blur'
  },
  component:{
    required: true,
    message: '组件地址为必填项',
    trigger: 'blur'
  },
  path:{
    required: true,
    message: '路由地址为必填项',
    trigger: 'blur'
  }
})
</script>

<style scoped>

</style>