<template>
  <n-card class="app-container" :segmented="{content : true}">
    <template #header>
      <n-button type="primary">添加分类</n-button>
    </template>
    <n-data-table></n-data-table>
   <template #footer>
     <n-pagination></n-pagination>
   </template>

  </n-card>
</template>

<script>
export default {
  name: "sort"
}
</script>

<style scoped>

</style>