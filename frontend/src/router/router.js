import Vue from "vue"
import VueRouter from "vue-router"
import HomePage from "../views/Home.vue"
import ForgotPasswd from "../views/ForgotPasswd.vue"
import ProfileOverview from "../views/ProfileOverview.vue"
import ProfileEdit from "../views/ProfileEdit.vue"
import ProjectsView from "../views/ProjectsView.vue"

Vue.use(VueRouter)

const router = new VueRouter({
    mode: "history",
    routes: [
        {path: "/", component: HomePage},
        {path: "/forgotPasswd", component: ForgotPasswd},
        {path: '/profile/overview', component: ProfileOverview},
        {path: '/profile/edit', component: ProfileEdit},
        {path: '/projects', component: ProjectsView}
    ]
})

export default router;
