<template>
<div class="project-section">
  <b-card-group class="b-card-group" deck v-for="(projects,i) in formatProjects">
    <b-card @click="choiceCard($event,i,j)" :title="project.title" header-tag="header" footer-tag="footer" v-for="(project,j) in projects">
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
  <b-modal ref="modal-center" centered :title="project.title">
    <p class="my-4">{{project.content}}</p>
    <router-link :to="{ name: 'ProjectDetail', params: { project_id: this.project.id} }">
      <b-button>Show project Details</b-button>
      </router-link>
  </b-modal>
</div>
</template>

<script>

export default {
  name: "ProjectList",
  props: ['countOfCard','selected','openFlag'],
  computed: {
    formatProjects() {
      return this.projects.reduce((c,n,i) => {
        if (i%this.countOfCard === 0)
          c.push([]);
        c[c.length -1].push(n);
        return c;
      }, []);
    }
  },
  watch : {
    'selected': function(data) {
      if(data === 'c')
        this.projects = this.projects_done;
      else
        this.projects = this.projects_proceeding;
    }
  },
  mounted() {
    this.projects = [...this.projects_proceeding];
  },
  methods: {
    choiceCard(ev,k,l) {
      const key = k * this.countOfCard + l;
      this.project = this.projects[key];
      if(this.openFlag)
        this.$refs['modal-center'].show();
      else
        this.$router.push({ name: 'ProjectDetail', params: {project_id: this.project.id} })

    }
  },
  data() {
    return {
      project:{},
      projects: [],
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
      ]
    }
  }
}
</script>
<style lang="scss" scoped>
.b-card-group {
  margin: 50px auto;
  .b-card {
    position: inherit;
  }
}
.project-section {
  margin-top:5%;
  height: auto;
  border: 2px solid var(--grey);
  border-radius: 10px;
}
</style>
