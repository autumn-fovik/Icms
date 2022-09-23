import type {App} from "vue"
import {createRouter, createWebHistory, RouteRecordRaw} from "vue-router";
import {Layout} from "./constant"
import {createRouterGuards} from "@/router/router-guards";

export const RootRoute: RouteRecordRaw = {
    path: '/',
    name: 'Root',
    component : Layout,
    meta: {
        title: 'Root',
    },
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



