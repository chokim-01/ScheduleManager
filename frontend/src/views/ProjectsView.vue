<template>
<div id="projects-view">
<<<<<<< Updated upstream
  <ProjectList :selected="selected" :countOfCard="countOfCard" :openFlag="openFlag"/>
=======
  <ProjectList :selected="selected" :countOfCard="countOfCard" :openFlag="getOpenFlag"/>
  <li>
    {{$route.params.flag}}
    {{this.$store.state.sidebar.message}}
  </li>
>>>>>>> Stashed changes
</div>
</template>
<script>
import ProjectList from '../components/ProjectList.vue'

export default {
  name: "ProjectsView",
  components:{
    ProjectList
  },
<<<<<<< Updated upstream
=======
  computed: {
    getOpenFlag() {
      if(this.$store.state.sidebar.message === "projects")
        this.openFlag = false

      return this.openFlag
    }
  },
>>>>>>> Stashed changes
  data() {
    return {
      selected: 'a',
      countOfCard: 1,
      openFlag:true
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
