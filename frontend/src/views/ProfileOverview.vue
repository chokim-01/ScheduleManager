<template>
<div id="overview">
  <h1 style="text-align: center;">Overview</h1>
  <div class="search-section">
    <b-form-select v-model="selected" :options="options" v-on:change="selectChanged"></b-form-select>
  </div>
  <h3>Projects</h3>
  <div class="project-section">
    <b-card-group class="b-card-group" :key="projects.id" deck v-for="projects in formatProjects">
      <b-card class="b-card" :title="project.title" header-tag="header" footer-tag="footer" :key="project.id" v-for="project in projects">
        <template #header>
          <h6 class="mb-0">u must finish {{project.todo}} todo</h6>
        </template>
        <b-card-text>{{project.content}}</b-card-text>
        <b-card-text style="float:right">{{project.finishDate}}</b-card-text>
        <template #footer>
          <em>
            <b-progress :value="project.progress" max=100 show-progress animated></b-progress>
          </em>
        </template>
      </b-card>
    </b-card-group>
  </div>
  <hr />
</div>
</template>

<script>
export default {
  name: "ProfileOverview",

  data() {
    return {
      selected: 'a',
      options: [
        {value: 'a', text : 'Proceeding projects'},
        {value: 'b', text : 'Done projects'},
      ],
      projects_proceeding: [
        {
          id: 1,
          todo: 6,
          title: "title1",
          content: "content1",
          progress: 5,
          finishDate: "2022-08-10"
        },
        {
          id: 2,
          todo: 0,
          title: "title2",
          content: "content2",
          progress: 40,
          finishDate: "2022-08-01"
        },
        {
          id: 3,
          todo: 2,
          title: "title3",
          content: "content3",
          progress: 88,
          finishDate: "2022-07-14"
        },
        {
          id: 4,
          todo: 8,
          title: "title4",
          content: "content4",
          progress: 88,
          finishDate: "2022-07-14"
        },
        {
          id: 5,
          todo: 8,
          title: "title5",
          content: "content5",
          progress: 0,
          finishDate: "2022-07-14"
        }
      ],
      projects_done: [
        {
          id: 1,
          todo: 0,
          title: "done title2",
          content: "content1",
          progress: 5,
          finishDate: "2022-08-10"
        },
        {
          id: 2,
          todo: 0,
          title: "done title2",
          content: "content2",
          progress: 40,
          finishDate: "2022-08-01"
        }
      ],
      projects: [
        {
          id: 1,
          todo: 6,
          title: "title1",
          content: "content1",
          progress: 5,
          finishDate: "2022-08-10"
        },
        {
          id: 2,
          todo: 0,
          title: "title2",
          content: "content2",
          progress: 40,
          finishDate: "2022-08-01"
        },
        {
          id: 3,
          todo: 2,
          title: "title3",
          content: "content3",
          progress: 88,
          finishDate: "2022-07-14"
        },
        {
          id: 4,
          todo: 8,
          title: "title4",
          content: "content4",
          progress: 88,
          finishDate: "2022-07-14"
        },
        {
          id: 5,
          todo: 8,
          title: "title5",
          content: "content5",
          progress: 0,
          finishDate: "2022-07-14"
        }
      ]
    }
  },
  computed: {
    formatProjects() {
      return this.projects.reduce((c,n,i) => {
        if (i%2 === 0)
          c.push([]);
        c[c.length -1].push(n);
        return c;
      }, []);
    }
  },
  methods: {
    selectChanged(choice) {
      if(choice === 'a')
        this.projects = this.projects_proceeding;
      else
        this.projects = this.projects_done;
    }
  }
}
</script>
<style lang="scss" scoped>
#overview {
  display: table;
  margin: 8% auto;
  width:50%;

  .project-section {
    margin-top:5%;
    height: auto;
    border: 2px solid var(--grey);
    border-radius: 10px;
  }
  .search-section {
    float: right;
  }
  .b-card-group {
    margin: 50px auto;
    .b-card {
      max-width: 50%;
      position: inherit;
    }
  }

}



</style>
