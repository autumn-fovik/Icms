import { http } from "@/plugins/axios";

export  function pageMenu(pageNum: number , pageSize : number) {
    return http.request({
        url : "menu/list",
        method : "GET",
        params : {
            pageNum : pageNum,
            pageSize : pageSize
        }
    })

}


export  function listMenu() {
    return http.request({
        url : "menu/list",
        method : "GET"
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