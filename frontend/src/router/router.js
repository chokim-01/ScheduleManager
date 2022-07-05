import Vue from "vue"
import VueRouter from "vue-router"
import Home from "../views/Home.vue"
import forgotPasswd from "../views/ForgotPasswd.vue"

Vue.use(VueRouter)

const router = new VueRouter({
    mode: "history",
    routes: [
        {path: "/", component: Home},
        {path:"/forgotPasswd",component:forgotPasswd}
    ]
})

export default router;