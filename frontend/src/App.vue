<template>
<v-app>
  <Header />
  <Sidebar />
  <v-main>
    <router-view></router-view>
  </v-main>
</v-app>
</template>

<script>
import Header from './components/layout/Header.vue'
import Sidebar from './components/layout/Sidebar.vue'
import vuetify from './plugins/vuetify.js'

export default {
  name: 'App',

  components: {
    Header,
    Sidebar
  },

  data: () => ({
    //
  }),
};
</script>
