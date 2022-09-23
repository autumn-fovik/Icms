<template>
  <div class="breadcrumb-warp">
    <n-breadcrumb separator=">" >
      <n-breadcrumb-item>
        北京总行</n-breadcrumb-item>
      <n-breadcrumb-item>
        天津分行</n-breadcrumb-item>
      <n-breadcrumb-item>
        平山道支行</n-breadcrumb-item>
    </n-breadcrumb>
  </div>
</template>

<script>
export default {
  name: "index"
}
</script>

<style scoped lang="scss">
.breadcrumb-warp{
  display: flex;
  align-items: center;
}
</style>