<template>
  <div>
    <n-spin :show="skin" :style="{'margin-top': skin ? '200px': '0px'}" description="数据加载中...">
    <n-grid :x-gap="20" y-gap="20" v-if="!skin">
      <n-gi :span="12">
        <n-card :segmented="{content : true}">
          <template #header>
            CPU
          </template>
          <n-table :bordered="false" :single-line="false">
            <thead>
            <tr>
              <th>属性</th>
              <th>值</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>核心数</td>
              <td>{{ service.cpu.cpuNum }}</td>
            </tr>
            <tr>
              <td>用户使用率</td>
              <td>{{service.cpu.used}} %</td>
            </tr>
            <tr>
              <td>系统使用率</td>
              <td>{{service.cpu.sys}} %</td>
            </tr>
            <tr>
              <td>当前空闲率</td>
              <td>{{ service.cpu.free }} %</td>
            </tr>
            </tbody>
          </n-table>
        </n-card>
      </n-gi>
      <n-gi :span="12">
        <n-card :segmented="{content : true}">
          <template #header>
            内存
          </template>
          <n-table :bordered="false" :single-line="false">
            <thead>
            <tr>
              <th>属性</th>
              <th>内存</th>
              <th>JVM</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>总内存</td>
              <td>{{service.mem.total }}</td>
              <td>{{service.jvm.total }}</td>
            </tr>
            <tr>
              <td>已用内存</td>
              <td>{{service.mem.used }}</td>
              <td>{{service.jvm.used }}</td>

            </tr>
            <tr>
              <td>剩余内存</td>
              <td>{{service.mem.free }}</td>
              <td>{{service.jvm.free }}</td>

            </tr>
            <tr>
              <td>使用率</td>
              <td>{{service.mem.usage }}</td>
              <td>{{service.jvm.usage }}</td>

            </tr>
            </tbody>
          </n-table>
        </n-card>
      </n-gi>
      <n-gi :span="24">
        <n-card :segmented="{content : true}">
          <template #header>
            服务器信息
          </template>
          <n-descriptions label-placement="left"
                          bordered
                          :column="2"
          >
            <n-descriptions-item label="服务器名称">{{service.sys.computerName }}</n-descriptions-item>
            <n-descriptions-item label="操作系统">{{service.sys.osName }}</n-descriptions-item>
            <n-descriptions-item label="服务器IP">{{service.sys.computerIp }}</n-descriptions-item>
            <n-descriptions-item label="系统架构">{{service.sys.osArch }}</n-descriptions-item>
          </n-descriptions>
        </n-card>
      </n-gi>
      <n-gi :span="24">
        <n-card :segmented="{content : true}">
          <template #header>
            Java 虚拟机信息
          </template>
          <n-descriptions label-placement="left" bordered label-style="width : 100px" :column="2">
            <n-descriptions-item label="Java名称">{{service.jvm.name}}</n-descriptions-item>
            <n-descriptions-item label="Java版本">{{service.jvm.version}}</n-descriptions-item>
            <n-descriptions-item label="启动时间">{{service.jvm.startTime}}</n-descriptions-item>
            <n-descriptions-item label="运行时长">{{service.jvm.runTime}}</n-descriptions-item>
            <n-descriptions-item label="安装路径" span="2">{{service.jvm.home}}</n-descriptions-item>
            <n-descriptions-item label="项目路径" span="2">{{service.sys.userDir}}</n-descriptions-item>
            <n-descriptions-item label="运行参数" span="2">{{service.jvm.inputArgs}}
            </n-descriptions-item>
          </n-descriptions>

        </n-card>
      </n-gi>
      <n-gi :span="24">
        <n-card :segmented="{content : true}">
          <template #header>
            磁盘状态
          </template>
          <n-data-table :columns="columns" :data="service.sysFiles" />

        </n-card>
      </n-gi>
    </n-grid>
    </n-spin>
  </div>
</template>

<script setup lang="ts">
import {service as servicesApi} from "@/apis/monitorApi";
import {NEllipsis} from "naive-ui";

const initGet = () => {
  servicesApi().then(resp => {
    service.value = resp.data
    skin.value = false
  })

}
const skin = ref(true)
const service = ref({
  cpu: {
    cpuNum: "8",
    total: "825100",
    sys: "1.14",
    used: "2.47",
    wait: "0",
    free: "96.39",
  },
  mem: {
    total: "15.88",
    used: "13.12",
    free: "2.76",
    usage: "82.64",
  },
  jvm: {
    total: "256",
    max: "4066",
    free: "140.71",
    version: "11.0.16.1",
    home: "D:\\Program Files\\Java\\jdk-11.0.16.1",
    usage: "45.03",
    used: "115.29",
    startTime: "2022-11-04 13:04:46",
    runTime: "0天0小时1分钟",
    inputArgs: '[-XX:TieredStopAtLevel=1", -Xverify:none", -Dspring.output.ansi.enabled=always", -Dcom.sun.management.jmxremote", -Dspring.jmx.enabled=true", -Dspring.liveBeansView.mbeanDomain", -Dspring.application.admin.enabled=true", -javaagent:D:\\Program Files\\JetBrains\\apps\\IDEA-U\\ch-0\\222.4345.14\\lib\\idea_rt.jar=57439:D:\\Program Files\\JetBrains\\apps\\IDEA-U\\ch-0\\222.4345.14\\bin", -Dfile.encoding=UTF-8]',
    name: "Java HotSpot(TM) 64-Bit Server VM ",
  },
  sys: {
    computerName: "DESKTOP-JNIQ3N4",
    computerIp: "192.168.2.41",
    userDir: "C:\\Users\\autumn\\IdeaProjects\\Icms",
    osName: "Windows 11",
    osArch: "amd64",
  },
  sysFiles: [
    {
      dirName: "C:\\",
      sysTypeName: "NTFS",
      typeName: "本地固定磁盘 (C:)",
      total: "100.0 GB",
      free: "39.1 GB",
      used: "60.9 GB",
      usage: "60.9",
    }
  ]
})
initGet()

const columns = [{
  key : "dirName",
  title : "盘符路径",
},{
  key : "sysTypeName",
  title : "文件系统",
},{
  key : "typeName",
  title : "盘符类型",
},{
  key : "total",
  title : "总大小",
},{
  key : "free",
  title : "可用大小",
},{
  key : "used",
  title : "已用大小",
},{
  key : "usage",
  title : "已用百分比",
  render: (row : any) => {
    return h("div",{},{ default : () => `${row.usage} %`})
  }
}]
onMounted(() =>{
  //setInterval(initGet,5000)
})
</script>

<style scoped>


</style>