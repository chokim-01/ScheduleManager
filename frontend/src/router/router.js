import Vue from "vue"
import VueRouter from "vue-router"
import HomePage from "../views/Home.vue"
import ForgotPasswd from "../views/ForgotPasswd.vue"
import ProfileOverview from "../views/ProfileOverview.vue"
import ProfileEdit from "../views/ProfileEdit.vue"
import ProjectsView from "../views/ProjectsView.vue"
import ProjectDetail from "../views/ProjectDetail.vue"

Vue.use(VueRouter)

const router = new VueRouter({
    mode: "history",
    routes: [
        {path: "/", component: HomePage},
        {path: "/forgotPasswd", component: ForgotPasswd},
        {path: '/profile/overview', component: ProfileOverview},
        {path: '/profile/edit', component: ProfileEdit},
<<<<<<< HEAD
        {path: '/projects/:flag', name: 'Projects', component: ProjectsView},
=======
<<<<<<< Updated upstream
        {path: '/projects', component: ProjectsView},
>>>>>>> skeleton/sidebar
        {path: '/projects/detail', name: 'ProjectDetail', component: ProjectDetail, props:true}
=======
        {path: '/projects/:flag', name: 'Projects', component: ProjectsView},
        {path: '/project/:id', name: 'ProjectDetail', component: ProjectDetail}
>>>>>>> Stashed changes
    ]
})

export default router;
