<template>
<div id="project-detail">

<h1 style="text-align:center;">
Project Id : {{id}}
</h1>

</div>
</template>
<script>
export default {
    name:"ProjectDetail.vue",
    data() {
      return {
        id: this.$route.params.id
      }
    }
}
</script>
<style>
#project-detail {
  display: table;
  margin-top: 8%;
  transform: translateX(50%);
  width: 50%;
  .search-section {
    float: right;
  }
}

</style>
