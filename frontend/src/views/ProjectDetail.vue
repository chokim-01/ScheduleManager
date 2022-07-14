<template>
<div id="project-detail">

<h1 style="text-align:center;">
Project Id : {{this.project_id}}
</h1>

</div>
</template>
<script>
export default {
    name:"ProjectDetail.vue",
    props: {
      project_id: {
        type: Number,
        default : 0
      }
    },
    mounted() {
      console.log(this.project_id)
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
