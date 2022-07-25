<template>
  <v-card class="overflow-hidden">
    <v-app-bar color="white">
      <v-app-bar-nav-icon></v-app-bar-nav-icon>
      <router-link to="/">
        <v-toolbar-title>SManager</v-toolbar-title>
      </router-link>
      <v-spacer></v-spacer>

      <v-btn icon>
        <v-icon>mdi-bell-badge-outline</v-icon>
      </v-btn>
      <v-tabs>
        <v-tab to="/projects/all">All Projects</v-tab>
        <v-tab to="/projects/my">My Projects</v-tab>
        <v-tab to="/profile/overview">Profile</v-tab>
      </v-tabs>
    </v-app-bar>
  </v-card>
</template>

<script>
import SignModal from "../modal/Sign.vue"

export default {
  name: "Header",
  components: {
    SignModal
  },
  data() {
    return {
      signModalView: false
    }
  }
}
</script>

<style>
.v-tabs-bar {
  float: right;
}
</style>
