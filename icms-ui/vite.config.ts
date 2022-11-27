// vite.config.ts
import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'
import viteCompression from "vite-plugin-compression"
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import {NaiveUiResolver} from 'unplugin-vue-components/resolvers'
import * as path from "path";

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [
        vue({
            template: {
                compilerOptions: {}
            }
        }),
        // 编译压缩
        viteCompression({
            verbose: true,
            disable: false,
            threshold: 10240,
            algorithm: "gzip",
            ext: ".gz"
        }),
        // 自动导入 方法
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
        // 自动导入组件
        Components({
            resolvers: [NaiveUiResolver()]
        })
    ],
    resolve: {
        alias: {
            "@": path.resolve(__dirname, "src"),
            'vue$': 'vue/dist/vue.esm.js'
        }
    },
    server: {
        open: true,
        proxy: {
            "/dev-api": {
                target: "http://localhost:8070/",
                changeOrigin: true
            }
        }
    },
    build: {
        rollupOptions: {
            output: {
                // 超大资源文件拆分
                manualChunks(id: string) {
                    if (id.includes('node_modules')) {
                        return id.split('/node_modules/').pop()?.split('/')[0]
                    }
                },
                // 设置输出文件名
                chunkFileNames: 'js/[name]-[hash].js',
                entryFileNames: 'js/[name]-[hash].js',
                assetFileNames: '[ext]/[name]-[hash].[ext]',
            }
        },
        terserOptions: {
            compress: {
                // 清除 console debugger 标识
                drop_console: true,
                drop_debugger: true
            }
        }
    }
})