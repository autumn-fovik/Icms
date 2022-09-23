<template>
  <n-card class="app-container" :segmented="{ content : true }">
    <template #header>
      <n-button type="primary">daw</n-button>
    </template>
    <n-data-table>

    </n-data-table>
    <template #footer>
      <n-pagination></n-pagination>
    </template>
  </n-card>
</template>

<script>
</script>

<style scoped lang="scss">
.app-container{
  height: calc(100vh - 108px);
}
</style>