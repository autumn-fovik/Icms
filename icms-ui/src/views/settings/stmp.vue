<template>
  <n-card class="app-container">
   <n-tabs type="line" animated default-value="基本设置">
     <n-tab-pane name="基本设置" tab="基本设置">
       <n-form>
         <n-form-item label="账号"><n-input/></n-form-item>
         <n-form-item label="授权码"><n-input/></n-form-item>
         <n-form-item label="服务地址"><n-input/></n-form-item>
         <n-form-item label="端口"><n-input/></n-form-item>
       </n-form>
     </n-tab-pane>
     <n-tab-pane name="验证码模板" tab="验证码模板">
       <n-form>
         <n-form-item label="注册"><n-input type="textarea" rows="8"/></n-form-item>
         <n-form-item label="邮箱验证码"><n-input type="textarea" rows="8"/></n-form-item>
         <n-form-item label="登录提示"><n-input type="textarea" rows="8"/></n-form-item>
         <n-form-item label="邮箱通知"><n-input type="textarea" rows="8"/></n-form-item>
       </n-form>
     </n-tab-pane>
   </n-tabs>

  </n-card>

</template>

<script lang="ts" setup>

</script>

<style scoped>

</style>