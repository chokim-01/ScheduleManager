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
  }
}
</script>
<style lang="scss">
:root {
    --primary: #4ade80;
    --primary-alt: #22c55e;
    --grey: #64748b;
    --dark: #1e293b;
    --dark-alt: #334155;
    --light: #f1f5f9;
    --sidebar-width: 300px;
}
body {
    background: var(--light);
    position: relative;
}
</style>
