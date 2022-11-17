import {http} from "@/plugins/axios";

export function listRole(pageNum ?: number, pageSize ?: number) {
    return http.request({
        url: "role/list",
        method: "GET",
        params: {
            pageNum: pageNum,
            pageSize: pageSize
        }
    })

}


export  function addRole(data : any) {
    return http.request({
        url : "role",
        method : "put",
        data
    })

}
export  function editRole(data : any) {
    return http.request({
        url : "role",
        method : "post",
        data
    })

}
export  function getRole(id : number) {
    return http.request({
        url : "role/" + id,
        method : "get"
    })

}