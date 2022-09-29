import type {App} from "vue"
import {createPinia} from "pinia";

const store = createPinia()

export async function setupStore(app : App) {
    app.use(store)

}

export { store }