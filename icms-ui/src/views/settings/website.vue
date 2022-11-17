<template>
  <n-card class="app-container">
    <n-tabs type="line" animated default-value="基本设置">
      <n-tab-pane name="基本设置" tab="基本设置">
        <n-form label-placement="left">
          <n-form-item label="默认注册用户组">
            <n-select :options="roleOptions" value-field="roleId" label-field="roleName"/>
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
        <n-form label-placement="left" label-width="100px">
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
        <n-form label-placement="left" label-width="120px" style="margin: 0 auto;width: 600px">
          <n-form-item label="是否开启注册">
            <n-switch/>
          </n-form-item>
          <n-form-item label="默认注册用户组">
            <n-select :options="roleoOptions" value-field="roleId" label-field="roleName"/>
          </n-form-item>
          <n-form-item label="密码强度">
            <n-input/>
          </n-form-item>
          <n-form-item label="默认头像">
            <n-input/>
          </n-form-item>
          <n-button type="primary" style="width: 100%">提交</n-button>
        </n-form>
      </n-tab-pane>
    </n-tabs>
  </n-card>

</template>

<script setup lang="ts">
import { listRole } from "@/apis/roleApi"


const roleOptions  = ref({})


const initGet = () => {
  listRole().then(resp=> { roleOptions.value = resp.data })

  
}

initGet();

</script>

<style scoped>

</style>