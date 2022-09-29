import { http } from "@/plugins/axios";

export  function list() {
    return http.request({
        url : "user/list",
        method : "GET"
    })

}