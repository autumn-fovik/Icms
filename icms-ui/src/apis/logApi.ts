import {http} from "@/plugins/axios";

export function listLog(pageNum ?: number, pageSize ?: number) {
    return http.request({
        url: "log",
        method: "GET",
        params: {
            pageNum: pageNum,
            pageSize: pageSize
        }
    })

}


export function getLog(id: number) {
    return http.request({
        url: "log/" + id,
        method: "get"
    })

}