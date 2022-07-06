import Vue from "vue"
import VueRouter from "vue-router"
import Home from "../views/Home.vue"
import forgotPasswd from "../views/ForgotPasswd.vue"
import profileOverview from "../views/ProfileOverview.vue"
import profileEdit from "../views/ProfileEdit.vue"
import profileSidebar from "@/components/layout/ProfileSidebar";


Vue.use(VueRouter)

const router = new VueRouter({
    mode: "history",
    routes: [
        {path: "/", component: Home},
        {path: "/forgotPasswd", component: forgotPasswd},
        {path: '/profile/overview', component: profileOverview},
        {path: '/profile/edit', component: profileEdit}
    ]
})

export default router;