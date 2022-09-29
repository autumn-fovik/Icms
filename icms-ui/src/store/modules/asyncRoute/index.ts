import {RouteRecordRaw} from "vue-router";
import {defineStore} from "pinia";
import {constantRouter} from "@/router/index"
import {generatorDynamicRouter} from "@/router/generator-routers";
import {store} from "@/store"


export interface IAsyncRouteState {
    menus : RouteRecordRaw[],
    routers : any[],
    addRouters : any[],
    isDynamicAddedRoute: boolean
}

export const useAsyncRouteStore = defineStore("asyncRoute",{
    state: () : IAsyncRouteState => ({
        menus :[],
        routers :  constantRouter,
        addRouters : [] ,
        isDynamicAddedRoute : false
    }),
    actions :{
        getRouters() {
            return toRaw(this.addRouters);
        },
        setDynamicAddedRoute(added: boolean) {
            this.isDynamicAddedRoute = added;
        },
        // 设置动态路由
        setRouters(routers :any) {
            this.addRouters = routers;
            this.routers = constantRouter.concat(routers);
        },
        setMenus(menus : any) {
            // 设置动态路由
            this.menus = menus;
        },
        async generateRoutes(){
            const  accessedRouters = await generatorDynamicRouter();
            this.setRouters(accessedRouters);
            // this.setMenus(accessedRouters);
            return toRaw(accessedRouters);
        }
    }

})
export function useAsyncRouteStoreWidthOut() {
    return useAsyncRouteStore(store);
}