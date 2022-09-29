<template>
  <n-card class="app-container">
    <div>
      <n-image-group show-toolbar-tooltip>
      <n-grid cols="xs:2 s:3 m:4 l:6 xl:8" class="icon-parent" responsive="screen">

          <n-grid-item v-for="item of icon" :key="item">
            <n-card>
              <n-image
                  width="120"
                  height="120"
                  src="https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg"
                  object-fit="cover"
              />
            </n-card>
          </n-grid-item>

      </n-grid>
      </n-image-group>
    </div>
  </n-card>

</template>

<script setup lang="ts">
import IconFont from "@icon-park/vue-next/icons.json"

const icon = IconFont.slice(0,41)
</script>

<style scoped>

</style>