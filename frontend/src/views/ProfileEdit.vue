<template>
  <div>
    <ProfileSidebar/>
    <div id="edit">
      <button>Edit Page</button>
    </div>
  </div>
</template>

<script>

import ProfileSidebar from "../components/layout/ProfileSidebar";

export default {
  name: "ProfileEdit",
  components: {ProfileSidebar},
}
</script>

<style scoped>
#edit {
  display: table;
  margin-left: auto;
  margin-right: auto;
}
</style>