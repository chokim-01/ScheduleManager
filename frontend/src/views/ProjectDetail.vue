<template>
<div id="project-detail-section">
  <v-row>
    <h2>
      Project Name
    </h2>
  </v-row>
  <v-row justify="end">
    <v-btn justify="end" outlined color="indigo" @click="itemAddShow=!itemAddShow">
      Add item
      <v-icon>mdi-pencil</v-icon>
    </v-btn>
  </v-row>
  <v-row>
    <v-col class="card-container" v-for="card in cards">
      <v-col class="cards" :style="{borderColor: card.color}">
        <v-col>
          {{card.title}}
        </v-col>
        <v-col class="itemlist">
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
  <ItemAdd :visible="itemAddShow" @close="itemAddShow=false" @add="addItem"/>
  <!-- itemId와 cId를 같이 보내고 받는다. -->
  <ItemDelete :visible="itemDelShow" :type="type" :id="content" @close="itemDelShow=false" @delete="deleteItem"/>
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
      this.cId = cId
      this.iId = iId
      this.type = 'todo'
      this.content = 'todo content'
      this.itemDelShow = true
    },
    deleteProject() {
      this.type = 'project'
      this.content = 'project content'
      this.itemDelShow = true
    },
    deleteItem() {
      console.log(this.cId, this.iId)
      this.cards[this.cId].items[this.iId].show = false
      this.itemDelShow = false
    },
    addItem(data) {
      this.itemAddShow = false
      const nowDate = (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10)
      console.log(data[2])
      for(let i = 0;i<data[2].length;i++) {
        let dictObj = {}
        dictObj['id'] = this.cards[1].items.length
        dictObj['title'] = data[0]
        dictObj['content'] = data[1]
        dictObj['show'] = true

        if(data[2][i] === nowDate)
            this.cards[0].items.push(dictObj)
        else
            this.cards[1].items.push(dictObj)
      }
    }
  },
  data() {
    return {
      id: this.$route.params.id,
      itemAddShow: false,
      itemDelShow: false,
      type: '',
      content: '',
      cId: 0,
      iId: 0,

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
          title: "Todos",
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
          title: "Issues",
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
    margin: 4% 5% 0;
    .card-container {
        display: grid;
        gap: 1em;
    }
    .cards {
        padding: 1em;
        box-shadow: 0 3px 5px grey;
        border-top: 3px solid grey;
        .itemlist {
          height:calc(500px);
          overflow: auto;
        }
        .items {
            margin-top: 1em;
            box-shadow: 0 3px 5px grey;
            border-top: 3px solid grey;
        }
    }


}
</style>
