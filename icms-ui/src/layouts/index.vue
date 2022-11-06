<template>
  <n-layout has-sider class="app-warp" :class="classObj">
    <n-layout-sider width="" class="app-side">
      <Sidebar/>
    </n-layout-sider>
    <n-layout>
      <n-layout-header class="app-header">
        <Navbar/>
      </n-layout-header>
      <n-layout-content content-style="padding: 24px;" class="app-content">
       
        <router-view v-slot="{ Component, route }">
          <transition name="fade-transform" mode="out-in">
            <keep-alive :include="ProductList">
              <component :is="Component" :key="route.path" />
            </keep-alive>
          </transition>
        </router-view>

      </n-layout-content>
    </n-layout>
  </n-layout>
</template>

<script setup lang="ts">
import {Navbar, Sidebar} from "./components"
import {useAppStore} from "@/store/modules/app";
import {ref} from 'vue';

const classObj = computed(()=>({
  hideSidebar: ! useAppStore().getCollapsed
}))

const ProductList = ref([])
</script>

<style  lang="scss">
/* fade-transform */
.fade-transform-leave-active,
.fade-transform-enter-active {
  transition: all .5s;
}

.fade-transform-enter-from {
  opacity: 0;
  transform: translateX(-30px);
}
.fade-transform-leave-to {
  opacity: 0;
  transform: translateX(30px);
}

.app-warp {
  height: 100vh;
  width: 100%;
  background-color: #f2f3f5;

  .app-side {
    height: 100%;
    width: 200px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    -webkit-box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    transition: width .28s;
    background-color: #fff;
  }

  .app-header {
    height: 60px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    -webkit-box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    background-color: #fff;
  }

  .app-content {
    background-color: #f2f3f5;
    height: calc(100vh - 60px);
  }


}
.hideSidebar {
  .app-side {
    width: 64px;
  }
}
.app-container {
  min-height: calc(100vh - 108px);

}
</style>