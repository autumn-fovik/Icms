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
            const { code , msg } = config.data
            switch (code){
                case 401 :
                    window.$message?.error("无效会话，或登陆过期，请重新登陆！")
                    useAppStoreWidthOut().removeToken()

                     router.push({path : "/login"})
                    return config
                    break;
                case 204 :
                    window.$message?.error(msg)
                default:
                    return config
                    break;

            }

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