import {http} from "@/plugins/axios";

export function service() {
    return http.request({
        url: "monitor/service",
        method: "GET"
    })

}

export function redis() {
    return http.request({
        url: "monitor/redis",
        method: "GET"
    })

}