<template>
<div id="header">
  <b-navbar toggleable="lg" type="dark" variant="info">
    <b-navbar-brand href="/">SManager</b-navbar-brand>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav>
        <b-nav-item href="#" disabled>Admin</b-nav-item>
      </b-navbar-nav>
      <!-- Right aligned nav items -->
      <b-navbar-nav class="ml-auto">
        <b-navbar-nav>
          <!-- if cannot access -> disabled -->

          <b-nav-item-dropdown right>
            <template #button-content>
              <b-icon icon="bell"></b-icon>
            </template>
            <b-dropdown-item> item 1</b-dropdown-item>
            <b-dropdown-item> item 2</b-dropdown-item>
          </b-nav-item-dropdown>

          <!-- when receive dest, get data -->
          <b-nav-item to="/projects">All Projects</b-nav-item>
          <b-nav-item to="/projects">My Projects</b-nav-item>
          <b-nav-item @click="signModalView=true" v-b-modal.modal-Sign>Sign</b-nav-item>
          <SignModal v-if="signModalView" @close-modal="signModalView = false">
          </SignModal>
          <b-nav-item to="/profile/overview"> Profile </b-nav-item>
        </b-navbar-nav>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
</div>
</template>

<script>
import SignModal from "../Sign.vue"

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
#header {
  z-index: 9999;
  top:0px;
  width:100%;
  position: fixed;
}
</style>
