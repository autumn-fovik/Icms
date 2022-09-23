import {defineStore} from "pinia";
import { store } from "@/store";
import {getToken, removeToken, setToken} from "@/utils/jsCookie";

export interface IAppState {
    collapsed : Boolean,
    token : string | undefined
}
export const useAppStore = defineStore("app",{
    state: () : IAppState => ({
        collapsed : true,
        token : getToken() || undefined
    }),
    getters : {
        getCollapsed () : Boolean{
            return this.collapsed
        },
        getToken () : string | undefined {
            return this.token
        }
    }
    ,
    actions : {
        changeCollapsed () {
            this.collapsed = !this.collapsed
        },
        setToken (token : string){
            this.token = token
            setToken(token)
        },
        removeToken (){
            removeToken()
            this.token = undefined
        }
    }
})

export function useAppStoreWidthOut(){
    return useAppStore(store)
}