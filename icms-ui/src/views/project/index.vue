<template>
  <div>
      <n-card title="生产环境依赖" :segmented="{ content: true }">
        <n-descriptions
            label-placement="left"
            bordered
            :column="3"
            :label-style="{ 'font-weight': 'bold', 'font-size': '16px' }"
        >
          <n-descriptions-item :label="item.label" v-for="item of dependenciesList" :key="item.label">
            {{ item.value }}
          </n-descriptions-item>
        </n-descriptions>
      </n-card>
      <n-card title="开发环境依赖" :segmented="{content : true}" style="margin-top: 20px">
        <n-descriptions
            label-placement="left"
            bordered
            :column="3"
            :label-style="{ 'font-weight': 'bold', 'font-size': '16px' }"
        >
          <n-descriptions-item
              :label="item.label"
              v-for="item of devDependenciesList"
              :key="item.label"
          >
            {{ item.value }}
          </n-descriptions-item>
        </n-descriptions>
      </n-card>
  </div>

</template>

<script setup lang="ts">
import useAppInfo from '../../../package.json'
import {onMounted, reactive, ref} from 'vue'

const {dependencies, devDependencies} = useAppInfo
const dependenciesList = reactive<Record<string, string>[]>([])
const devDependenciesList = reactive<Record<string, string>[]>([])
const depValues = Object.values(dependencies)
Object.keys(dependencies).map((it, index) => {
  dependenciesList.push({
    label: it,
    value: depValues[index],
  })
})
const devDepValues = Object.values(devDependencies)
Object.keys(devDependencies).map((it, index) => {
  devDependenciesList.push({
    label: it,
    value: devDepValues[index],
  })
})
</script>

<style scoped>

</style>