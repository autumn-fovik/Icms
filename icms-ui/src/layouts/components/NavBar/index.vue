<template>
  <div style="display: flex;width: 100%;justify-content: space-between">
    <div class="app-header-left">
      <Hamburger/>
      <Breadcrumb/>

    </div>
    <div class="app-header-right">
      <Remind theme="outline" size="24" fill="#333" />
      <div class="vaw-avatar-container">
        <n-dropdown trigger="hover"  :options="options" size="large">
          <div class="action-wrapper">
            <div class="avatar">
              <n-avatar circle size="small" src="http://aw.vueadminwork.com/assets/img_avatar.1d4c4a34.gif" />
            </div>
            <span class="nick-name">
              超级管理员
          <n-icon class="tip">

          </n-icon>
        </span>
          </div>
        </n-dropdown>
      </div>

    </div>
  </div>
</template>

<script setup lang="ts">
import Hamburger from "@/components/Hamburger/index.vue"
import Breadcrumb from "@/components/Breadcrumb/index.vue"
import type {DropdownOption} from "naive-ui";
import {Remind} from "@icon-park/vue-next"

import {useUserStore} from "@/store/modules/user/index"


const options : Array<DropdownOption> = [
  {
    label: '个人中心',
    key: 'personal-center',
  },
  {
    label: '退出登录',
    key: 'logout',
    props: {
      onClick () {
        useUserStore().UserLogout()
      }
    }

  },
]
</script>

<style scoped lang="scss">
.app-header-left{
  display: flex;
  align-items: center;
}
.app-header-right{
  display: flex;
  align-items: center;
}
.vaw-avatar-container{
  cursor: pointer;
}
.action-wrapper {
  display: flex;
  align-items: center;
  .avatar {
    width: calc(48px - 15px);
    height: calc(48px - 15px);
    display: flex;
    align-items: center;
    & > img {
      border: 1px solid #f6f6f6;
      width: 100%;
      height: 100%;
      object-fit: cover;
      border-radius: 50%;
    }
  }
  .nick-name {
    margin: 0 5px;
    .tip {
      transform: rotate(0);
      transition: transform .3s ease;
      margin-left: 2px;
    }
  }
}
</style>