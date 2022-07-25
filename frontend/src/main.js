import Vue from 'vue'
import App from './App.vue'
import router from './router/router.js'
import store from './store/index.js'

import vuetify from './plugins/vuetify'

Vue.config.productionTip = false

new Vue({
  store,
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')
