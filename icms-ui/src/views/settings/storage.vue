<template>
    <n-card class="app-container">
      <n-form style="width: 60%;margin: 0 auto" label-placement="left" label-width="150px">
        <n-form-item label="存储介质">
          <n-select></n-select>
        </n-form-item>
        <n-form-item label="AccessKeyId">
          <n-input></n-input>
        </n-form-item>
        <n-form-item label="AccessKeySecret">
          <n-input></n-input>
        </n-form-item>
        <n-form-item label="Bucket名称">
          <n-input></n-input>
        </n-form-item>
        <n-form-item label="Endpoint">
          <n-select :options="EndpointList" label-field="name" value-field="endpoint"></n-select>
        </n-form-item>
        <n-form-item label="根目录">
          <n-input></n-input>
        </n-form-item>
      </n-form>
    </n-card>
</template>

<script setup lang="ts">


import {ref} from "vue";
import {SelectGroupOption, SelectOption} from "naive-ui";

const EndpointList: Array<SelectOption | SelectGroupOption> = [{
  name: "华东1（杭州）",
  endpoint: "oss-cn-hangzhou",
},{
  name: "华东2（上海）",
  endpoint: "oss-cn-shanghai",
},{
  name: "华东5（南京本地地域）",
  endpoint: "oss-cn-nanjing",
},{
  name: "华北1（青岛）",
  endpoint: "oss-cn-qingdao",
},{
  name: "华北2（北京）",
  endpoint: "oss-cn-beijing",
},{
  name: "华北 3（张家口）",
  endpoint: "oss-cn-zhangjiakou",
},{
  name: "华北5（呼和浩特）",
  endpoint: "oss-cn-huhehaote",
},{
  name: "华北6（乌兰察布）",
  endpoint: "oss-cn-wulanchabu",
},{
  name: "华南1（深圳）",
  endpoint: "oss-cn-shenzhen",
},{
  name: "华南2（河源）",
  endpoint: "oss-cn-heyuan",
},{
  name: "华南3（广州）",
  endpoint: "oss-cn-guangzhou",
},{
  name: "西南1（成都）",
  endpoint: "oss-cn-chengdu",
},{
  name: "中国（香港）",
  endpoint: "oss-cn-hongkong",
},{
  name: "美国（硅谷）*",
  endpoint: "oss-us-west-1",
},{
  name: "美国（弗吉尼亚）*",
  endpoint: "oss-us-east-1",
},{
  name: "日本（东京）*",
  endpoint: "oss-ap-northeast-1",
},{
  name: "韩国（首尔）",
  endpoint: "oss-ap-northeast-2",
},{
  name: "新加坡*",
  endpoint: "oss-ap-southeast-1",
},{
  name: "澳大利亚（悉尼）*",
  endpoint: "oss-ap-southeast-2",
},{
  name: "马来西亚（吉隆坡）*",
  endpoint: "oss-ap-southeast-3",
},{
  name: "印度尼西亚（雅加达）*",
  endpoint: "oss-ap-southeast-5",
},{
  name: "菲律宾（马尼拉）",
  endpoint: "oss-ap-southeast-6",
},{
  name: "泰国（曼谷）",
  endpoint: "oss-ap-southeast-7",
},{
  name: "印度（孟买）*",
  endpoint: "oss-ap-south-1",
},{
  name: "德国（法兰克福）*",
  endpoint: "oss-eu-central-1",
},{
  name: "英国（伦敦）",
  endpoint: "oss-eu-west-1",
},{
  name: "阿联酋（迪拜）*",
  endpoint: "oss-me-east-1",
}

]

</script>

<style scoped>

</style>