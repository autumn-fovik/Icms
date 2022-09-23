import Axios from "./Axios";

const http = new Axios({
    baseURL : "/dev-api",
    timeout : 10000
})

export { http }