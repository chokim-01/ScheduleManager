<template>
<div id="project-detail-section">
  <v-row>
    <v-col class="card-container" v-for="card in cards">
      <v-col class="cards" :style="{borderColor: card.color}">
        <v-col>
          {{card.title}}
          <v-btn class="btn-end" outlined color="indigo" v-if="card.title!=='Done'" @click="itemAddShow=!itemAddshow">
            <v-icon>mdi-pencil</v-icon>
          </v-btn>
        </v-col>
        <v-col>
          <v-card class="items" v-for="item in card.items" v-if="item.show !== false">
            <v-card-title>
              {{item.title}}
              <v-spacer></v-spacer>
              <v-btn plain @click="deleteCard(card.id,item.id)">X</v-btn>
            </v-card-title>
            <v-card-text>
              {{item.content}}
            </v-card-text>
          </v-card>
        </v-col>
      </v-col>

    </v-col>
  </v-row>
  <v-row>
    <v-spacer></v-spacer>
    <v-btn color="error" @click="deleteProject">Delete project</v-btn>
  </v-row>
  <ItemAdd :visible="itemAddShow" @close="itemAddShow=false"/>
  <!-- itemId와 cId를 같이 보내고 받는다. -->
  <ItemDelete :visible="itemDelShow" :type="type" :content="content" @close="itemDelShow=false" />
</div>
</template>
<script>
import ItemAdd from "../components/modal/ItemAdd.vue"
import ItemDelete from "../components/modal/ItemDelete.vue"
export default {
  name: "ProjectDetail",
  components: {
    ItemAdd,
    ItemDelete
  },
  methods: {
    deleteCard(cId,iId) {
      this.cards[cId].items[iId].show = false
      this.type = 'todo'
      this.content = 'todo content'
      this.itemDelShow = true
    },
    deleteProject() {
      this.type = 'project'
      this.content = 'project content'
      this.itemDelShow = true
    }
  },
  data() {
    return {
      id: this.$route.params.id,
      itemAddShow: false,
      itemDelShow: false,
      type: '',
      content: '',

      cards: [{
          id: 0,
          title: "In Progress",
          color: "blue",
          items: [{
              id: 0,
              title: "Title 1",
              content: "Content 1",
              show: true
            },
            {
              id: 1,
              title: "Title 2",
              content: "Content 2",
              show: true
            }
          ],
        },
        {
          id: 1,
          title: "Todo",
          color: "green",
          items: [{
              id: 0,
              title: "Title 1",
              content: "Content 1",
              show: true
            },
            {
              id: 1,
              title: "Title 2",
              content: "Content 2",
              show: true
            }
          ],
        },
        {
          id: 2,
          title: "Issue",
          color: "red",
          items: [{
              id: 0,
              title: "Title 1",
              content: "Content 1",
              show: true
            },
            {
              id: 1,
              title: "Title 2",
              content: "Content 2",
              show: true
            }
          ],
        },
        {
          id: 3,
          title: "Done",
          color: "grey",
          items: [{
              id: 0,
              title: "Title 1",
              content: "Content 1",
              show: true
            },
            {
              id: 1,
              title: "Title 2",
              content: "Content 2",
              show: true
            }
          ],
        },
      ],
      titles_date: [

      ]
    }
  }
}
</script>
<style lang="scss" scoped>
#project-detail-section {
    display: grid;
    margin: 8% 5% 0;
    .card-container {
        display: grid;
        gap: 1em;
    }
    .cards {
        padding: 1em;
        box-shadow: 0 3px 5px grey;
        border-top: 3px solid grey;
    }
    .btn-end {
        float: right;
    }
    .items {
        margin-top: 1em;
        box-shadow: 0 3px 5px grey;
        border-top: 3px solid grey;
    }

}
</style>
