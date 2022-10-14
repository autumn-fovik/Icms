import {createApp} from 'vue'
import './style.css'
import '@icon-park/vue-next/styles/index.css'
// 通用字体
import 'vfonts/Lato.css'
// 等宽字体
import 'vfonts/FiraCode.css'
import App from './App.vue'
import {setupRouter} from "@/router";
import {setupStore} from "@/store";
import {NaiveProvider} from "@/components/NaiveProvider"
// import * as icons from "@icon-park/vue-next"
import setupDirective from "@/directives";
import SvgIcon from "@/components/SvgIcon/index.vue"

async function bootstrap() {
    const naiveProvider = createApp(NaiveProvider)
    // 创建App实例
    const app = createApp(App)
    // 优先挂载实例
    naiveProvider.mount("#appProvider",true)
    // 挂载路由
    await setupRouter(app)
    // 挂载状态管理器
   // await setupStore(app)

  //  await setupDirective(app)
  //
  //   Object.keys(icons).forEach((key) => {
  //       app.component(key, (icons as any)[key]);
  //   });

    app.component("SvgIcon",SvgIcon)
    // 挂载Vue 实例
    app.mount('#app')
    //naiveProvider.unmount()
}

void bootstrap()