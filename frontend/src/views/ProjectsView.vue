<template>
<div id="projects-view">

  <ProjectList :selected="selected" :countOfCard="countOfCard" :openFlag="getOpenFlag"/>
  <li>
    {{$route.params.flag}}
    {{this.$store.state.sidebar.message}}
  </li>
</div>
</template>
<script>
import ProjectList from '../components/ProjectList.vue'

export default {
  name: "ProjectsView",
  components:{
    ProjectList
  },
  watch: {
    '$route' (to, from) {
      if(to.path ==='/projects/my')
        this.openFlag=false;
      else
        this.openFlag=true;
    }
  },
  computed: {
    getOpenFlag() {
      if(this.$store.state.sidebar.message === "projects")
        this.openFlag = false

      return this.openFlag
    }
  },
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
