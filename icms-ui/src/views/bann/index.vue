<template>
<n-card class="app-container">
<!--  <template #header>-->
<!--    <n-button>打开</n-button>-->
<!--  </template>-->
  <template #default>
<!--    数据展示-->
    <n-data-table :data="dataResources.records" :columns="column" />
    <n-modal v-model:show="dialogs.display" v-model:title="dialogs.title" preset="card" :style="{width : dialogs.width}" >

    </n-modal>
  </template>
  <template #footer>
<!--    分页-->
    <n-pagination v-model:page-count="dataResources.pages" :page-sizes="[dataResources.pageSize]" @update:page="turnPages" />
  </template>
</n-card>
</template>

<script setup lang="ts">

import {DataTableColumn} from "naive-ui";


// 弹框控制
const dialogs = reactive({
  display : true,
  title : "添加",
  width : "30%"
})
// 表格数据
let dataResources  = ({
  total: 10,
  pages: 1,
  records: [],
  pageSize: 10,
  pageNum: 1
})

// 查询参数
const queryParameters = reactive({
  pageNum: 1,
  pageSize: 10
})
// 表格列
const column : Array<DataTableColumn> = []
// 封禁数据
const bannData  = {
  bannId : ""
}

// 翻页
const turnPages = (pageNum : number) => {

}
// 初始化数据
const initGet = () => {
  tableDataInitialization()

}
// 表格数据初始化
const tableDataInitialization = (pageNum ? : number, pageSize ? : number) => {
  if (pageNum != undefined){
    queryParameters.pageNum = pageNum
  }
  if (pageSize != undefined){
    queryParameters.pageSize = pageSize
  }

}
initGet()
</script>

<style scoped>

</style>