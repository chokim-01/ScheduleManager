<template>
<div id="app">

  <Header />
  <Sidebar />
  <router-view></router-view>
</div>
</template>

<script>
import Header from './components/layout/Header.vue'
import Sidebar from './components/layout/Sidebar.vue'

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
