<template>
     <v-row class="fill-height overflow-auto" id="project-section" :style="`transform:translateX(${50/countOfCard}%);`">
       <v-col v-for="(item,idx) in projects" :key="item.title" :cols="(12/itemsPerRow)">
         <v-card min-width="100%" class="card fill-height" :to="`/project/${item.id}/detail`">
           <v-card-title>
               <span class="font-weight-light text-truncate">
                 <span v-text="item.title"></span>
               </span>
               <v-spacer></v-spacer>
               <template v-if="item.auth === 'manager'">
                 <v-icon>mdi-account-tie</v-icon>
               </template>
               <template v-if="item.auth === 'contributor'">
                 <v-icon>mdi-account</v-icon>
               </template>
           </v-card-title>
           <v-divider></v-divider>
           <v-card-text>
             <span v-html="item.content" class="mr-2"></span>
           </v-card-text>
           <v-divider/>
           <v-progress-linear color="light-blue" height="9" :value="item.progress" striped></v-progress-linear>
         </v-card>
       </v-col>
     </v-row>
 </template>

<script>
export default {
  name: "ProjectList",
  props: ['countOfCard', 'selected', 'openFlag'],
  computed: {
    numberOfPages() {
      return Math.ceil(this.beers.length / this.ipp)
    },
    rowsPerPage() {
      return this.rpp
    },
    itemsPerRow() {
      if(this.countOfCard === 1)
        return 1
      switch (this.$vuetify.breakpoint.name) {
        case 'xs':
          return 1
        case 'sm':
          return 1
        default:
          return 2
      }
    },
    ipp() {
      return Math.ceil(this.rowsPerPage * this.itemsPerRow)
    }
  },
  watch: {
    'selected': function(data) {
      if (data === 'c')
        this.projects = this.projects_done;
      else
        this.projects = this.projects_proceeding;
    }
  },
  mounted() {
    this.projects = [...this.projects_proceeding];
  },
  methods: {
    choiceCard(ev, k, l) {
      const key = k * this.countOfCard + l;
      this.project = this.projects[key];
      if (this.openFlag)
        this.$refs['modal-center'].show();
      else
        this.$router.push('/project/' + this.project.id + '/detail')

    }
  },
  data() {
    return {
      project: {},
      projects: [],
      projects_proceeding: [{
          id: 1,
          todo: 6,
          title: "title1",
          content: "content1",
          progress: 5,
          finishDate: "2022-08-10",
          auth: "manager"
        },
        {
          id: 2,
          todo: 0,
          title: "title2",
          content: "content2",
          progress: 40,
          finishDate: "2022-08-01",
          auth: "manager"
        },
        {
          id: 3,
          todo: 2,
          title: "title3",
          content: "content3",
          progress: 88,
          finishDate: "2022-07-14",
          auth: "contributor"
        },
        {
          id: 4,
          todo: 8,
          title: "title4",
          content: "content4",
          progress: 88,
          finishDate: "2022-07-14",
          auth: "contributor"
        },
        {
          id: 5,
          todo: 8,
          title: "title5",
          content: "content5",
          progress: 0,
          finishDate: "2022-07-14",
          auth: "manager"
        }
      ],
      projects_done: [{
          id: 1,
          todo: 0,
          title: "done title2",
          content: "content1",
          progress: 100,
          finishDate: "2022-08-10",
          auth: "contributor"
        },
        {
          id: 2,
          todo: 0,
          title: "done title2",
          content: "content2",
          progress: 100,
          finishDate: "2022-08-01",
          auth: "manager"
        }
      ]
    }
  }
}
</script>
<style lang="scss" scoped>
#project-section {
    margin-top: 5%;
    .auth {
      font-size: 15px;
      border-radius: 10px;
      border: 2px solid black;
    }
}
</style>
