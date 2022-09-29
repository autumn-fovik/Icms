<template>
  <div class="breadcrumb-warp">



    <n-breadcrumb >
      <template v-for="routeItem in breadcrumbList" :key="routeItem.name">
        <n-breadcrumb-item v-if="routeItem.meta.title">
          <n-dropdown
              v-if="routeItem.children.length"
              :options="routeItem.children"
              @select="dropdownSelect"
          >
              <span class="link-text">
                <component
                    v-if="routeItem.meta.icon"
                    :is="routeItem.meta.icon"
                />
                {{ routeItem.meta.title }}
              </span>
          </n-dropdown>
          <span class="link-text" v-else>
              <component
                  v-if="routeItem.meta.icon"
                  :is="routeItem.meta.icon"
              />
              {{ routeItem.meta.title }}
            </span>
        </n-breadcrumb-item>
      </template>
    </n-breadcrumb>

  </div>
</template>

<script setup lang="ts">
import {useRoute, useRouter} from "vue-router";
import {computed} from "vue"

const route = useRoute()
const router = useRouter()

const generator: any = (routerMap : any) => {
  return routerMap.map((item : any) => {
    const currentMenu = {
      ...item,
      label: item.meta.title,
      key: item.name,
      disabled: item.path === '/',
    };
    // 是否有子菜单，并递归处理
    if (item.children && item.children.length > 0) {
      // Recursion
      currentMenu.children = generator(item.children, currentMenu);
    }
    return currentMenu;
  });
};
const breadcrumbList = computed(() => {
  return generator(route.matched);
});

const dropdownSelect = (key : any) => {
  router.push({ name: key });
};
</script>

<style scoped lang="scss">
.breadcrumb-warp{
  display: flex;
  align-items: center;
}
</style>