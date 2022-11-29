<template>

  <n-card class="app-container" :segmented="{content : true}">
    <template #header>
      {{ welcomeMessage }}
    </template>
    <h2>ss</h2>
  </n-card>
</template>

<script setup lang="ts">
import {useUserStore} from "@/store/modules/user"

const useStore = useUserStore()

const welcomeMessage = ref("")

onMounted(() => {
  let hours = new Date().getHours();
  if (hours >= 5 && hours < 8) {
    welcomeMessage.value = "😊 早上好 " + useStore.userInfo.nickName + " 今天又是愉快的一天，你说对吧"
  } else if (hours >= 8 && hours < 12) {
    welcomeMessage.value = "😊 上午好 " + useStore.userInfo.nickName + " 今天又是愉快的一天，你说对吧"
  } else if (hours >= 12 && hours < 15) {
    welcomeMessage.value = "🥱 中午好 " + useStore.userInfo.nickName + " 该睡个舒服的午觉了"
  } else if (hours >= 15 && hours < 19) {
    welcomeMessage.value = "😊 下午好 " + useStore.userInfo.nickName + " 这不得来一份下午茶"
  } else if (hours >= 19 && hours <= 23) {
    welcomeMessage.value = "😪 晚上好 " + useStore.userInfo.nickName + " 今天又是愉快的一天，你说对吧"
  } else if (hours >= 0 && hours < 5) {
    welcomeMessage.value = "😖 凌晨了 " + useStore.userInfo.nickName + " 不要熬夜了，好嘛"
  }else {
    welcomeMessage.value = "😊 你好 " + useStore.userInfo.nickName + ""
  }


})

</script>

<style scoped>

</style>