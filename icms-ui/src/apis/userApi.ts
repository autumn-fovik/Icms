import { http } from "@/plugins/axios";

export  function list(pageNum: number , pageSize : number) {
    return http.request({
        url : "user/list",
        method : "GET",
        params : {
            pageNum : pageNum,
            pageSize : pageSize
        }
    })

}

export function userStatusEdit(id :string , status : string) {
    return http.request({
        url : "user/status/" + id +"/"+ status,
        method : "POST"
    })

}