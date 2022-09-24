<template>
  <n-card class="app-container" :segmented="{ content : true }">
    <template #header>
      <n-button type="primary">写文章</n-button>
    </template>
   <VditorEditor style="height: 100%;display: flex;width: 100%;" />


  </n-card>
</template>

<script>
import VditorEditor from "@/components/VditorEditor/index.vue"
</script>

<style scoped lang="scss">
.app-container{
  height: calc(100vh - 108px);
}
</style>