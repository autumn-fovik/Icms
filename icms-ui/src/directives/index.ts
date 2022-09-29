import hasPermi from './permission/hasPermi'
import type {App} from "vue";


const install = function(Vue : any) {
    Vue.directive('hasPermi', hasPermi)

}

export async function setupStore(app : App) {
    app.use(install)

}
export default install
