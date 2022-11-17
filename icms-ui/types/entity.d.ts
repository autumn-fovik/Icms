// 用户实体类
interface UserEntity {
    userId: string,
    userName: string
    nickName: string,
    userType?: string,
    email: string,
    phonenumber?: number,
    sex: string,
    avatar?: string,
    password: string,
    status: string,
    delFlag?: string,
    loginIp?: string,
    loginDate?: Date,
    createBy?: string,
    createTime?: Date,
    updateBy?: string,
    updateTime?: Date,
    remark: string,
    roleIds?: any[]


}

interface RoleEntity {


}