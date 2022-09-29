<template>
  <n-card class="app-container" :segmented="{content : true}">
    <template #header>
      <n-button type="primary">
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
        <n-form label-align="left">
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

    </div>
  </n-card>
</template>

<script setup lang="ts">

import type {DataTableColumns} from "naive-ui";
import {list} from "@/apis/userApi";

const dialogs = reactive({
  add: {
    display: false
  }
})

let TableData = ref({
  pageNum: 1,
  pageSize: 13,
  pages: 1,
  records: [],
  total: 13,
})




const createColumns = ({}: {}): DataTableColumns<any> => {
  return [{
    key: "userId",
    title: "序号"
  }, {
    key: "userName",
    title: "用户名"
  }]
}


const columns = createColumns({})

const initGet = () => {
  list().then((resp: any) => {
    TableData.value = resp.data
  })

}


initGet()
</script>

<style scoped>

</style>