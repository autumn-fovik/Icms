import {http} from "@/plugins/axios";
import qs from "qs"

export function login(data : any) {
    return http.request({
        url : "auth/login",
        method : "POST",
        data : qs.stringify(data)
    })

}
export  function getUserInfo() {
    return http.request({
        url : "auth/getUserInfo",
        method : "GET"
    })

}

export  function getRouter() {
    return http.request({
        url : "auth/getRoute",
        method : "GET"
    })

}

