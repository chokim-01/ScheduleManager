<template>
  <div id = "header">
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
            <b-nav-item href="#">All Projects</b-nav-item>
            <b-nav-item href="#">My Schedule</b-nav-item>
            <b-nav-item @click="signModalView=true" v-b-modal.modal-Sign>Sign</b-nav-item>
            <SignModal v-if="signModalView" @close-modal="signModalView = false">
            </SignModal>
          </b-navbar-nav>

          <b-nav-item-dropdown right>
            <!-- Using 'button-content' slot -->
            <template #button-content>
              <em>~님</em>
            </template>
            <b-dropdown-item to="/profile">
              profile
            </b-dropdown-item>
            <b-dropdown-item href="#">Sign Out</b-dropdown-item>
          </b-nav-item-dropdown>
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
  margin-top: 50px;
}
</style>
