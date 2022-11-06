<template>
  <n-card class="app-container">
    <n-tabs type="line" animated default-value="基本设置">
      <n-tab-pane name="基本设置" tab="基本设置">
        <n-form label-placement="left">
          <n-form-item label="默认注册用户组">
            <n-select/>
          </n-form-item>
          <n-form-item label="默认注册用户组">
            <n-select/>
          </n-form-item>
          <n-form-item label="默认注册用户组">
            <n-select/>
          </n-form-item>
          <n-form-item label="默认注册用户组">
            <n-select/>
          </n-form-item>
          <n-form-item label="默认注册用户组">
            <n-select/>
          </n-form-item>
          <n-form-item label="默认注册用户组">
            <n-select/>
          </n-form-item>
        </n-form>

      </n-tab-pane>
      <n-tab-pane name="SEO 设置" tab="SEO 设置">
        <n-form label-placement="left">
          <n-form-item label="网站名">
            <n-input/>
          </n-form-item>
          <n-form-item label="关键字">
            <n-input/>
          </n-form-item>
          <n-form-item label="网站描述">
            <n-input/>
          </n-form-item>
        </n-form>
      </n-tab-pane>
      <n-tab-pane name="用户注册" tab="用户注册">
        <n-form label-placement="left">
          <n-form-item label="是否开启注册">
            <n-switch/>
          </n-form-item>
          <n-form-item label="密码强度">
            <n-input/>
          </n-form-item>
          <n-form-item label="默认头像">
            <n-input/>
          </n-form-item>
        </n-form>
      </n-tab-pane>
    </n-tabs>
  </n-card>

</template>

<script lang="ts" setup>

</script>

<style scoped>

</style>