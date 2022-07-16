<template>
<div id="projects-view">
  <ProjectList :selected="selected" :countOfCard="countOfCard" :openFlag="openFlag"/>
  <li>
    {{$route.params.flag}}
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
