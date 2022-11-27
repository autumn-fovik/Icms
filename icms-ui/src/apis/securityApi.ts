import {http} from "@/plugins/axios";


export function check() {
    return http.request({
        url: "Interdiction",
        method: "GET"
    })

}