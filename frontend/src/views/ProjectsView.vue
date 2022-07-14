<template>
<div id="projects-view">
  <ProjectList :selected="selected" :countOfCard="countOfCard" />
</div>
</template>
<script>
import ProjectList from '../components/ProjectList.vue'

export default {
  name: "ProjectsView",
  components:{
    ProjectList
  },
  data() {
    return {
      selected: 'a',
      countOfCard: 1
    }
  }
}
</script>
<style lang="scss" scoped>
#projects-view {
  display: table;
  margin-top: 8%;
  transform: translateX(50%);
  width:50%;
}

</style>
