<template>
  <n-card class="app-container" :segmented="{content : true}">
    <template #header>
      <n-button type="primary">文件上传</n-button>
    </template>
    <n-data-table :columns="columns">

    </n-data-table>
  </n-card>
</template>

<script setup lang="ts">
import {DataTableColumns} from "naive-ui";

const TableData = reactive([{}])


const createColumns = ({}: {}): DataTableColumns<any> => {
  return [
    {
      title: '文件名',
      key: 'no',
      width: "60%"
    },
    {
      title: '修改时间',
      key: 'title',
      width : "15%"
    },
    {
      title: '大小',
      key: 'length',
      width : "15%"
    },
    {
      title: '操作',
      key: 'actions',
      width: "10%"
    }
  ]
}

const columns = createColumns({})
</script>

<style scoped>

</style>