import Cookie  from "js-cookie"


const TokenKey : string = "Admin-Token"


export function setToken(token : string)  {
    Cookie.set(TokenKey,token)
}

export function getToken() :string |undefined {
    return Cookie.get(TokenKey)
}

export function removeToken(){
    Cookie.remove(TokenKey)
}
