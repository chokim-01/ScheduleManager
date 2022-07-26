<template>
<v-app>
  <Header />
  <Sidebar />
  <v-content>
    <router-view></router-view>
  </v-content>
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
