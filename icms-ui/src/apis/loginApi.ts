import {http} from "@/plugins/axios";

export function login(data : any) {
    return http.request({
        url : "auth/login",
        method : "POST",
        data
    })

}
export  function getUserInfo() {
    return http.request({
        url : "auth/getUserInfo",
        method : "GET"
    })

}

export function getRouter() {
    return http.request({
        url: "auth/getRoute",
        method: "GET"
    })

}

export function verificationCode() {
    return http.request({
        url: "captchaImage",
        method: "GET"
    })

}

