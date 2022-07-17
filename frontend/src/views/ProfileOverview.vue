<template>
<div id="overview">
  <h1 style="text-align: center;">Overview</h1>
  <div class="search-section">
    <b-form-select v-model="selected" :options="options" :openFlag="openFlag"></b-form-select>
  </div>
  <h3>Projects</h3>
  <ProjectList :countOfCard="countOfCard" :selected="selected"/>
  <h3 style="margin-top:5%;">Done calendar</h3>
  <hr />
  <div class = "calendar-section">
    <VuejsHeatMap :entries="entries" max="5"/>
  </div>
</div>
</template>

<script>
import VuejsHeatMap from 'vuejs-heatmap'
import ProjectList from '../components/ProjectList.vue'
export default {
  name: "ProfileOverview",
  components: {
    VuejsHeatMap,
    ProjectList
  },
  methods: {
  },
  data() {
    return {
      selected: 'b',
      countOfCard: 2,
      openFlag: false,
      options: [
        {value: 'b', text : 'Proceeding projects'},
        {value: 'c', text : 'Done projects'},
      ],
      message:"message",
      entries:[
        {
          "counting": 2,
          "created_at":"2022-07-01",
        },
        {
          "counting": 10,
          "created_at": "2022-06-05"
        }
      ],
    }
  }
}
</script>
<style lang="scss" scoped>
#overview {
  display: table;
  margin-top: 8%;
  margin-left: calc(10% - 150px);
  transform: translateX(50%);
  width: 50%;
  .search-section {
    float: right;
  }

  .calendar-section {
    border: 2px solid var(--grey);
    border-radius: 10px;
  }
}
</style>
<style>
.calendar-heatmap {
  overflow:inherit  !important;
}
</style>
