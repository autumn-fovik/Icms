<template>
  <n-card class="app-container" :segmented="{ content : true }">
    <template #header>
      <n-button v-has-permi="['system:menu:add']" type="primary">写文章</n-button>
    </template>
 <VditorEditor style="height: 100%;display: flex;width: 100%;" />

  </n-card>
</template>

<script></script>

<style scoped lang="scss">
</style>