<template>
  <n-config-provider :theme-overrides="teme" :locale="zhCN" :date-locale="dateZhCN">
  <n-loading-bar-provider>
    <n-dialog-provider>
      <n-notification-provider>
        <n-message-provider>
          <slot></slot>
          <naive-provider-content />
        </n-message-provider>
      </n-notification-provider>
    </n-dialog-provider>
  </n-loading-bar-provider>
  </n-config-provider>
</template>

<script setup lang="ts">
import { zhCN, dateZhCN } from "naive-ui"
import { defineComponent, h } from 'vue';
import { useDialog, useLoadingBar, useMessage, useNotification } from 'naive-ui';

// 挂载naive组件的方法至window, 以便在路由钩子函数和请求函数里面调用
function registerNaiveTools() {
  window.$loadingBar = useLoadingBar();
  window.$dialog = useDialog();
  window.$message = useMessage();
  window.$notification = useNotification();
}

const NaiveProviderContent = defineComponent({
  name: 'NaiveProviderContent',
  setup() {
    registerNaiveTools();
  },
  render() {
    return h('div');
  }
});

const teme =  {
  "Code": {
    "textColor": "rgba(8, 124, 239, 1)"
  },
  "common": {
    "primaryColor": "#37B0E8FF",
    "primaryColorHover": "#66A2DDFF",
    "primaryColorSuppl": "#3F9BB7FF",
    "primaryColorPressed": "#1B71A6FF",
    "successColor": "#18a058"
  }
}


</script>
<style scoped></style>