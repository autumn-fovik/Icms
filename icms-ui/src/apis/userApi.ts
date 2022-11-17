import {http} from "@/plugins/axios";

export function listUser(queryParameters: any) {
    return http.request({
        url: "user",
        method: "GET",
        params: queryParameters
    })

}

export function userStatusEdit(id :string , status : string) {
    return http.request({
        url : "user/status/" + id +"/"+ status,
        method : "POST"
    })

}

export function getUserByUserId(id : string) {
    return http.request<UserEntity>({
        url: "user/" + id,
        method: "GET"
    })

}

export function addUser(data: any) {
    return http.request({
        url: "user",
        method: "PUT",
        data
    })

}

export function editUser(data: any) {
    return http.request({
        url: "user",
        method: "POST",
        data
    })

}

export function delUser(id: string, remark: string) {
    return http.request({
        url: "user/" + id,
        method: "DELETE",
        params: {
            remark: remark
        }
    })

}