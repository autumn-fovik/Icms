import type {App} from "vue"
import {createRouter, createWebHistory, RouteRecordRaw} from "vue-router";
import {Layout} from "./constant"
import {createRouterGuards} from "@/router/router-guards";

export const RootRoute: RouteRecordRaw = {
    path: '/',
    name: 'Root',
    component : Layout,
    redirect : "/dashboard",
    children : [{
        path : "/dashboard",
        name : "仪表盘",
        component : () => import('@/views/dashboard/index.vue'),
        meta: {
            title: '仪表盘',
            id: 0
        },
    }],
    meta: {
        title: 'Root',
    },
};

export const InterdictionRoute: RouteRecordRaw = {
    path: '/Interdiction',
    name: 'Root',
    component: () => import('@/views/Interdiction/index.vue'),
};

export const LoginRoute: RouteRecordRaw = {
    path: '/login',
    name: 'Login',
    component: () => import('@/views/login/index.vue'),
    meta: {
        title: '登录',
    },
};

export const constantRouter: any[] = [RootRoute,LoginRoute];


const router = createRouter({
    history : createWebHistory(),
    routes : constantRouter
})

export async function setupRouter(app : App) {
    createRouterGuards(router)
    app.use(router)
    await router.isReady()


}

export default router



