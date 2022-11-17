<template>
  <n-card class="app-container" title="操作日志" :segmented="{content : true}">
    <n-data-table :data="dataResources.records" min-height="100%" :columns="column"/>
    <template #footer>
      <n-pagination :page-count="dataResources.pages" :page-sizes="[dataResources.pageSize]" @update:page="turnPages"/>
    </template>
    <div>
      <n-modal preset="card" v-model:show="dialogs.display" style="width: 40%;" title="详情查看">
        <n-descriptions :column="2" label-placement="left" bordered>
          <n-descriptions-item label="操作模块">
            {{ SysOperLog.title + "/" + SysOperLog.businessType }}
          </n-descriptions-item>
          <n-descriptions-item label="请求地址">
            {{ SysOperLog.operUrl }}
          </n-descriptions-item>
          <n-descriptions-item label="登录信息">
            {{ SysOperLog.operName + "/" + SysOperLog.operIp + "/" + SysOperLog.operLocation }}

          </n-descriptions-item>
          <n-descriptions-item label="请求方式">
            {{ SysOperLog.requestMethod }}
          </n-descriptions-item>
          <n-descriptions-item label="操作方法" span="2">
            {{ SysOperLog.method }}
          </n-descriptions-item>
          <n-descriptions-item label="请求参数" span="2">
            <n-input type="textarea" disabled v-model:value="SysOperLog.operParam"></n-input>
          </n-descriptions-item>
          <n-descriptions-item label="返回参数" span="2">
            <n-input type="textarea" disabled v-model:value="SysOperLog.jsonResult"></n-input>

            <!--            {{SysOperLog.jsonResult}}-->

          </n-descriptions-item>
          <n-descriptions-item label="操作状态">

            <n-tag :type="SysOperLog.status === 0 ? 'primary':'warning'">
              {{ SysOperLog.status === 0 ? '正常' : '异常' }}
            </n-tag>
          </n-descriptions-item>
          <n-descriptions-item label="操作时间">
            {{ SysOperLog.operTime }}
          </n-descriptions-item>


        </n-descriptions>

      </n-modal>
    </div>
  </n-card>
</template>

<script setup lang="ts">
import {DataTableColumn, NButton, NEllipsis, NSwitch, NTag} from "naive-ui";
import {getLog, listLog} from "@/apis/logApi";

const SysOperLog = ref({
  // 日志主键
  operId: "number",
  // 模块标题
  title: "string",
  // 业务类型（0其它 1新增 2修改 3删除）
  businessType: "",
  // 方法名称
  method: "string",
  // 请求方式
  requestMethod: "string",
  // 操作类别（0其它 1后台用户 2手机端用户）
  operatorType: "number",
  // 操作人员
  operName: "string",
  // 请求URL
  operUrl: "string",
  // 主机地址
  operIp: "string",
  // 操作地点
  operLocation: "string",
  // 请求参数
  operParam: "string",
  // 返回参数
  jsonResult: "string",
  // 操作状态（0正常 1异常）
  status: 0,
  // 错误消息
  errorMsg: "string",
  // 操作时间
  operTime: "Date",
})


// 弹框控制属性
const dialogs = reactive({
  display: false,
  title: "添加用户"
})

// 表格数据
let dataResources = ref({
  total: 10,
  pages: 1,
  records: [],
  pageSize: 10,
  pageNum: 1
})

const column: Array<DataTableColumn> = [{
  key: "operId",
  title: "序号",
  minWidth: "200px",
}, {
  key: "title",
  title: "系统模块"
}, {
  key: "businessType",
  title: "操作类型",
  render : (row : any) =>{
    let businessType = "其他"
    switch (row.businessType) {
      case 0 : businessType = "其他"; break
      case 1 : businessType = "新增"; break
      case 2 : businessType = "修改"; break
      case 3 : businessType = "删除"; break
      case 4 : businessType = "授权"; break
      case 5 : businessType = "导出"; break
      case 6 : businessType = "导入"; break
      case 7 : businessType = "强退"; break
      case 8 : businessType = "生成代码"; break
      case 9 : businessType = "清空数据"; break
    }
    return h(NTag,{ type : 'primary' },{default : ()=> businessType})

}
}, {
  key: "requestMethod",
  title: "请求方式"
}, {
  key: "operName",
  title: "操作人员"
}, {
  key: "operIp",
  title: "操作地址"
}, {
  key: "operLocation",
  title: "操作地点"
}, {
  key: "status",
  title: "操作状态",
  render : ( row: any)=> {
    if(row.status === 0) {
      return h(NTag,{ type : 'primary' },{default : ()=> "正常"})

    }else {
      return h(NTag,{ type : 'warning' },{default : ()=> "异常"})

    }
  }
}, {
  key: "operTime",
  title: "操作日期"
}, {
  key: "",
  title: "详情",
  render: (row: any) => {
    return h(NButton, {onClick: () => viewDetails(row.operId)}, {default: () => "详情"})
  }
}
]

const initGet = () => {
  listLog(dataResources.value.pageNum, dataResources.value.pageSize).then(resp => {
    dataResources.value = resp.data
  })

}

initGet();


const viewDetails = (id: number) => {
  getLog(id).then(resp => {
    SysOperLog.value = resp.data
    SysOperLog.value.jsonResult = formatJson(resp.data.jsonResult) as string
    SysOperLog.value.operParam = formatJson(resp.data.operParam) as string
    let businessType = "其他"
    switch (resp.data.businessType) {
      case 0 : businessType = "其他"; break
      case 1 : businessType = "新增"; break
      case 2 : businessType = "修改"; break
      case 3 : businessType = "删除"; break
      case 4 : businessType = "授权"; break
      case 5 : businessType = "导出"; break
      case 6 : businessType = "导入"; break
      case 7 : businessType = "强退"; break
      case 8 : businessType = "生成代码"; break
      case 9 : businessType = "清空数据"; break

    }
    SysOperLog.value.businessType = businessType
    dialogs.display = true
  })


}

const turnPages = (pageNum: number) => {
  listLog(pageNum, dataResources.value.pageSize).then(resp => {
    dataResources.value = resp.data
  })

}


function formatJson(jsonObj: any, callback ?: any) {
  // 正则表达式匹配规则变量
  var reg = null;
  // 转换后的字符串变量
  var formatted = '';
  // 换行缩进位数
  var pad = 0;
  // 一个tab对应空格位数
  var PADDING = ' ';
  // json对象转换为字符串变量
  var jsonString = jsonObj //transitionJsonToString(jsonObj, callback);
  if (!jsonString) {
    return jsonString;
  }
  // 存储需要特殊处理的字符串段
  let _index = [] as any[];
  // 存储需要特殊处理的“再数组中的开始位置变量索引
  var _indexStart = null as any;
  // 存储需要特殊处理的“再数组中的结束位置变量索引
  var _indexEnd = null as any;
  // 将jsonString字符串内容通过\r\n符分割成数组
  var jsonArray: any[] = [];
  // 正则匹配到{,}符号则在两边添加回车换行
  jsonString = jsonString.replace(/([\{\}])/g, '\r\n$1\r\n');
  // 正则匹配到[,]符号则在两边添加回车换行
  //jsonString = jsonString.replace(/([\[\]])/g, '\r\n$1\r\n');
  // 正则匹配到,符号则在两边添加回车换行
  jsonString = jsonString.replace(/(\,)/g, '$1\r\n');
  // 正则匹配到要超过一行的换行需要改为一行
  jsonString = jsonString.replace(/(\r\n\r\n)/g, '\r\n');
  // 正则匹配到单独处于一行的,符号时需要去掉换行，将,置于同行
  jsonString = jsonString.replace(/\r\n\,/g, ',');
  // 特殊处理双引号中的内容
  jsonArray = jsonString.split('\r\n');
  jsonArray.forEach(function (node, index) {
    // 获取当前字符串段中"的数量
    var num = node.match(/\"/g) ? node.match(/\"/g).length : 0;
    // 判断num是否为奇数来确定是否需要特殊处理
    if (num % 2 && !_indexStart) {
      _indexStart = index;
    }
    if (num % 2 && _indexStart && _indexStart != index) {
      _indexEnd = index;
    }
    // 将需要特殊处理的字符串段的其实位置和结束位置信息存入，并对应重置开始时和结束变量
    if (_indexStart && _indexEnd) {
      _index.push({
        start: _indexStart,
        end: _indexEnd,
      });
      _indexStart = null;
      _indexEnd = null;
    }
  });
  // 开始处理双引号中的内容，将多余的"去除
  _index.reverse().forEach(function (item, index) {
    var newArray = jsonArray.slice(item.start, item.end + 1);
    jsonArray.splice(
        item.start,
        item.end + 1 - item.start,
        newArray.join('')
    );
  });
  // 奖处理后的数组通过\r\n连接符重组为字符串
  jsonString = jsonArray.join('\r\n');
  // 将匹配到:后为回车换行加大括号替换为冒号加大括号
  jsonString = jsonString.replace(/\:\r\n\{/g, ':{');
  // 将匹配到:后为回车换行加中括号替换为冒号加中括号
  jsonString = jsonString.replace(/\:\r\n\[/g, ':[');
  // 将上述转换后的字符串再次以\r\n分割成数组
  jsonArray = jsonString.split('\r\n');
  // 将转换完成的字符串根据PADDING值来组合成最终的形态
  jsonArray.forEach(function (item, index) {
    // console.log(item);
    var i = 0;
    // 表示缩进的位数，以tab作为计数单位
    var indent = 0;
    // 表示缩进的位数，以空格作为计数单位
    var padding = '';
    if (item.match(/\{$/) || item.match(/\[$/)) {
      // 匹配到以{和[结尾的时候indent加1
      indent += 1;
    } else if (
        item.match(/\}$/) ||
        item.match(/\]$/) ||
        item.match(/\},$/) ||
        item.match(/\],$/)
    ) {
      // 匹配到以}和]结尾的时候indent减1
      if (pad !== 0) {
        pad -= 1;
      }
    } else {
      indent = 0;
    }
    for (i = 0; i < pad; i++) {
      padding += PADDING;
    }
    formatted += padding + item + `\n`;
    pad += indent;
  });
  // 返回的数据需要去除两边的空格
  return formatted.trim();
}

</script>

<style scoped>

</style>