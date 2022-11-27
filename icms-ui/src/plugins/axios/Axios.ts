import axios, {AxiosRequestConfig} from "axios";
import router from "@/router";
import {useAppStoreWidthOut} from "@/store/modules/app";

export default class Axios {
    private instance

    constructor(config : AxiosRequestConfig) {
        this.instance = axios.create(config)
        this.interceptors()
    }
    // 配置拦截器
    private interceptors() {
        this.interceptorsRequest()
        this.interceptorsResponse()
    }
    // 请求拦截器
    private interceptorsRequest(){
        this.instance.interceptors.request.use((config : AxiosRequestConfig)=>{
            const token = useAppStoreWidthOut().getToken
            // 如果有Token 则添加
            if (token !== null || token !==  ""){
                if (!config.headers) {
                    config.headers = {};
                }
                config.headers["Authorization"] = "Bearer " + token
            }
            return config
        })

    }
    // 响应拦截器
    private interceptorsResponse(){
        this.instance.interceptors.response.use(config => {
            const {code, msg} = config.data
            switch (code) {
                case 200 :
                    return config;
                case 400 :
                    window.$message?.error("无效会话，或登陆过期，请重新登陆！")
                    useAppStoreWidthOut().removeToken()

                    router.push({path: "/login"}).then(r => {
                    })
                    return Promise.reject('无效的会话，或者会话已过期，请重新登录。')
                case 401 :
                    window.$message?.error("权限不足，无法操作");
                    return Promise.reject('"权限不足，无法操作。')
                case 204 :
                    window.$message?.error(msg)
                    return config
                case 500 :
                    window.$message?.error(msg)
                    return Promise.reject(new Error(msg))
                default:
                    return Promise.resolve(config.data)

            }

        }, error => {
            let {message} = error;
            if (message == "Network Error") {
                message = "后端接口连接异常";
            } else if (message.includes("timeout")) {
                message = "系统接口请求超时";
            } else if (message.includes("Request failed with status code")) {
                message = "系统接口" + message.substr(message.length - 3) + "异常";
            }
            window.$message?.error(message)
            return Promise.reject(error)
        })
    }

    public async request<T, D = ApiData<T>>(config: AxiosRequestConfig) {
        return new Promise(async (resolve, reject) => {
            try {
                const response = await this.instance.request<D>(config)
                resolve(response.data)
            } catch (error) {
                reject(error)
            }
        }) as Promise<D> | Promise<any>
    }

}