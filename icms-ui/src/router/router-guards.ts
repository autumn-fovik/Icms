import {Router, RouteRecordRaw} from "vue-router";
import {useAppStoreWidthOut} from "@/store/modules/app";
import {useUserStoreWidthOut} from "@/store/modules/user";
import {useAsyncRouteStoreWidthOut} from "@/store/modules/asyncRoute";
import {ErrorPageRoute} from "@/router/baseRouter";

const whitePathList = ['/login', '/Interdiction']

export function createRouterGuards(router : Router){
    router.beforeEach(async (to, from, next)=>{
        window.$loadingBar?.start()

        const userStore = useUserStoreWidthOut()
        const appStore = useAppStoreWidthOut()
        const asyncRouterStore = useAsyncRouteStoreWidthOut()

        const token =  appStore.getToken
        if (token == "" || token == undefined){
            if (whitePathList.includes(to.path)){
                next()
            }else {
                next(`/login?redirect=${to.fullPath}`)
                window.$message?.warning("未登陆，请先登陆")
            }
        }else {
            if (userStore.userInfo == null){
               await userStore.GetInfo()
               const routes = await asyncRouterStore.generateRoutes();
               routes.forEach((item : any)=>{
                   router.addRoute("Root",item as unknown as RouteRecordRaw)
               })
                // 添加404
                const isErrorPage = router.getRoutes().findIndex((item: any) => item.name === ErrorPageRoute.name  );
                if (isErrorPage === -1){
                    router.addRoute(ErrorPageRoute as unknown as RouteRecordRaw)
                }
                next({...to , replace : true})
            }else {
                if(to.path == "/login"){
                    window.$message?.info("已登录，无需重新登录！")
                    next({path : "/"})
                }else {
                    next()
                }
            }
        }



    })
    router.afterEach((to, from, failure)=>{
        window.$loadingBar?.finish()
    })
    router.onError((error)=>{
        window.$loadingBar?.error()
    })

}