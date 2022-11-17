import {http} from "@/plugins/axios";

export function listMenu(pageNum ?: number, pageSize ?: number) {
    return http.request({
        url: "menu/list",
        method: "GET",
        params: {
            pageNum: pageNum,
            pageSize: pageSize
        }
    })

}
export  function addMenu(data : any) {
    return http.request({
        url : "menu",
        method : "put",
        data
    })

}
export  function editMenu(data : any) {
    return http.request({
        url : "menu",
        method : "post",
        data
    })

}
export  function getMenu(id : number) {
    return http.request({
        url : "menu/" + id,
        method : "get"
    })

}