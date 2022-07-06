<template>
  <div>
    <ProfileSidebar/>
    <div id="overview">
      <button>Overview Page</button>
    </div>
  </div>


</template>

<script>

import ProfileSidebar from "../components/layout/ProfileSidebar.vue";

export default {
  name: "ProfileOverview",
  components: {ProfileSidebar},
}
</script>

<style scoped>
#overview {
  display: table;
  margin-left: auto;
  margin-right: auto;
}
</style>