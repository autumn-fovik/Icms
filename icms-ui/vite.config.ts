// vite.config.ts
import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import {NaiveUiResolver} from 'unplugin-vue-components/resolvers'
import ss from "@vue/compiler-dom"
import * as path from "path";

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue({
      template : {
        compilerOptions : {
        }
      }
    }),
    AutoImport({
      imports: [
        'vue',
        {
          'naive-ui': [
            'useDialog',
            'useMessage',
            'useNotification',
            'useLoadingBar'
          ]
        }
      ]
    }),
    Components({
      resolvers: [NaiveUiResolver()]
    })
  ],
  resolve : {
    alias : {
      "@" : path.resolve(__dirname,"src"),
    }
  },
  server : {
    open : true,
    proxy : {
      "/dev-api" : {
        target : "http://localhost:8070/",
        changeOrigin : true
      }
    }
  }
})