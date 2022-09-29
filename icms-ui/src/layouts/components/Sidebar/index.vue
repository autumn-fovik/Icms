<template>
  <n-menu
      :options="menuOptions"
      :collapsed-width="64"
      :collapsed="!useAppStore().getCollapsed"
      :accordion="true"

      v-model:value="activeKey"
  />
</template>

<script lang="ts" setup>
import {useAppStore} from "@/store/modules/app";
import {useAsyncRouteStore} from "@/store/modules/asyncRoute";
import {RouterLink, useRoute} from "vue-router";
import SvgIcon from "@/components/SvgIcon/index.vue"

const router = useRoute();

let activeKey = ref<number | null>(router.meta?.id as number)
watch(() => router.meta?.id,(val : any,oldVal : any)=>{
  activeKey.value = val


})

const compileMenu = (menuMap : any ,parent? : any) : any[] => {
  return menuMap.map((item : any)=> {
    const currentMenu : any = {
      key : item.meta.id,
      icon : () => {
        return h(SvgIcon,{ icon: item.meta.icon })
      },
      label : () => {
        if (item.children && item.children.length > 0){
          return h("span",{},{
            default: () => item.meta.label
          })
        }else {
          return h(RouterLink,{
            to : {
              path : item.path
            }
          },{
            default: () => item.meta.label
          })
        }
      }
    };
    if (item.children && item.children.length > 0){
      currentMenu.children = compileMenu(item.children,currentMenu);
    }
    return currentMenu;
  })

}
const dashboard : any[] = [{
  key : 0,
  icon : () => {
    return h(SvgIcon,{ icon: "DashboardOne" })
  },
  label : () => {
    return h(RouterLink,{
      to : {
        path : "/dashboard"
      }
    },{
      default: () => "仪表盘"
    })
    // if (item.children && item.children.length > 0){
    //   return h("span",{},{
    //     default: () => item.meta.label
    //   })
    // }else {
    //   return h(RouterLink,{
    //     to : {
    //       path : item.path
    //     }
    //   },{
    //     default: () => item.meta.label
    //   })
    // }
  }

}]
const menuOptions :any [] = dashboard.concat(...compileMenu(useAsyncRouteStore().getRouters()))

</script>