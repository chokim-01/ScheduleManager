<template>
<div id="project-issues-section">
  <v-row>
    <h2>
      Project Issues
    </h2>
  </v-row>

  <v-row>
    <CardList :cards="cards"></CardList>
  </v-row>
</div>
</template>
<script>
import CardList from "../components/CardList.vue"
export default {
  name: "ProjectIssues",
  components: {
    CardList
  },
  data() {
    return {
      cards: [{
          id: 0,
          title: 'title1',
          content: 'content1',
          author: 'author1',
          date: '2022-08-03',
          comments: [{
              content: 'comment1',
              author: 'author1',
              date: '2022-08-03',
            },
            {
              content: 'comment2',
              author: 'author2',
              date: '2022-08-04',
            },
          ]
        },
        {
          id: 0,
          title: 'title2',
          content: 'content2',
          author: 'author2',
          date: '2022-08-03',
          comments: [{
              content: 'comment3',
              author: 'author1',
              date: '2022-08-03',
            },
            {
              content: 'comment4',
              author: 'author2',
              date: '2022-08-04',
            },
          ]
        }
      ]
    }
  }
}
</script>
<style lang="scss" scoped>
#project-issues-section {
    display: grid;
    margin: 4% 5% 0;
}
</style>
