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
import {dateZhCN, useDialog, useLoadingBar, useMessage, useNotification, zhCN} from "naive-ui"
import {defineComponent, h} from 'vue';

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
  },
  "common": {
  }
}


</script>
<style scoped></style>