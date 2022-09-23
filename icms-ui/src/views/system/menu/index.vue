<template>
  <n-card class="app-container" :segmented="{ content : true }">
    <template #header>
      <n-button type="primary">添加菜单</n-button>
    </template>
    <n-data-table>

    </n-data-table>
    <template #footer>
      <n-pagination></n-pagination>
    </template>
    <div class="dialog">
      <n-modal preset="card" style="width: 40%;" >

      </n-modal>
    </div>
  </n-card>

</template>

<script>
</script>

<style scoped lang="scss">
.app-container {
  height: calc(100vh - 108px);
}
</style>