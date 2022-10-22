import { http } from "@/plugins/axios";

export  function pageRole(pageNum: number , pageSize : number) {
    return http.request({
        url : "role/page",
        method : "GET",
        params : {
            pageNum : pageNum,
            pageSize : pageSize
        }
    })

}


export  function listRole() {
    return http.request({
        url : "role/list",
        method : "GET"
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