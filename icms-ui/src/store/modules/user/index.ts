import {defineStore} from "pinia";
import {store} from "@/store";
import {useAppStore} from "@/store/modules/app";
import {getUserInfo, login} from "@/apis/loginApi"
import router from "@/router";

export interface IUserStore {
    userInfo : any | undefined,
    permissions : Array<string>,
    userGroup : Array<string>
}

export const useUserStore = defineStore("user",{
    state : () : IUserStore => ({
        userInfo : undefined,
        permissions : [],
        userGroup : []

    }),
    getters : {
        getUserInfo() : any | undefined{
            return this.getUserInfo
        },
        getPermissions() : Array<string>{
            return this.permissions
        },
        getUserGroup() : Array<string>{
            return this.userGroup
        }
    },
    actions : {
        UserLogin (loginUser : any) {
            return new  Promise((resolve, reject)=>{
                login(loginUser).then((resp: ApiData<string> ) => {
                    if (resp.code == 200){
                        useAppStore().setToken(resp.data)
                        resolve(resp)
                    }else {
                        reject()
                    }
                }).catch(error => {
                    reject(error)
                })
            })

        },
        UserLogout() {
            window.$dialog?.warning({
                title: "提示",
                content: "是否登出系统 !",
                positiveText: "确认",
                negativeText: "取消",
                onPositiveClick: () => {
                    useAppStore().removeToken();
                    window.$message?.success("登出成功")
                    router.push("/login")
                }
            })

        },
        GetInfo () {
            return new Promise((resolve, reject)=>{
                getUserInfo().then((resp : any)=>{
                    if (resp.code == 200){
                        this.userInfo = resp.data
                        this.permissions = resp.data.permissions as Array<string>
                        return resolve(resp)
                    }
                }).catch((error)=>{
                    reject(error)
                })
            })
        }

    }
})

export function useUserStoreWidthOut(){
    return useUserStore(store)
}