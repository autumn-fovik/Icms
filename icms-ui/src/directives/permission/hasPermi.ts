/**
 * v-hasPermi 操作权限处理
 * Copyright (c) 2019 ruoyi
 */

import {useUserStore} from '@/store/modules/user'

export default {
    mounted(el : any, binding : any, vnode : any, prevVnode : any) {
        const store = useUserStore()
        const { value } = binding
        const permissions = store.getPermissions
        if (value && value instanceof Array && value.length > 0){
            const permissionFlag = value
            const hasPermissions = permissions.some(permission => {
                return permissionFlag.includes(permission)
            })
            if (!hasPermissions){
                el.parentNode && el.parentNode.removeChild(el)
            }
        }else {
            throw  new Error("未指定权限标签值")
        }

    },
    // inserted(el : any, binding :any, vnode :any) {
    //     const store = useUserStore()
    //     const { value } = binding
    //     const all_permission = "*:*:*";
    //     const permissions = store.getPermissions
    //
    //     console.log(permissions);
    //     // if (value && value instanceof Array && value.length > 0) {
    //     //     const permissionFlag = value
    //     //
    //     //     const hasPermissions = permissions.some(permission => {
    //     //         return all_permission === permission || permissionFlag.includes(permission)
    //     //     })
    //     //
    //     //     if (!hasPermissions) {
    //     //         el.parentNode && el.parentNode.removeChild(el)
    //     //     }
    //     // } else {
    //     //     throw new Error(`请设置操作权限标签值`)
    //     // }
    // }
}
