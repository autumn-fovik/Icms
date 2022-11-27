<template>
  <n-card class="app-container">
    <template #header>
      <n-button @click="dialogs.display = true">添加</n-button>

    </template>
    <template #default>
      <n-data-table/>
      <n-modal preset="card" v-model:show="dialogs.display" v-model:title="dialogs.title" style="width: 40%">
        <n-form label-placement="left" label-width="80px">
          <n-form-item label="链接名"><n-input/></n-form-item>
          <n-form-item label="链接">
            <n-input-group>
              <n-input-group-label>Http(s)://</n-input-group-label>
              <n-input/>
            </n-input-group>
          </n-form-item>
          <n-form-item label="描述"><n-input/></n-form-item>
          <n-form-item label="图标"><n-input/></n-form-item>
        </n-form>
      </n-modal>
    </template>

  </n-card>

</template>

<script setup lang="ts">


const dialogs = reactive({
  display : false,
  title : "添加"
})

</script>

<style scoped>

</style>