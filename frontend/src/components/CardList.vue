<template>
<v-row justify="center" style="margin-top:2%">
  <v-col cols="8" v-for="(card,idx) in cards" :key="cards.id">
    <v-card min-width="100%">
      <v-card-title>
        <span class="font-weight-light text-truncate">
          <span>{{card.title}}</span>
        </span>
        <v-spacer></v-spacer>
        <span>{{card.author}}</span>
      </v-card-title>
      <v-divider></v-divider>
      <v-col class="text-right">
        date :
        <span>{{card.date}}</span>
      </v-col>
      <v-card-text>
        <span v-html="card.content" class="mr-4"></span>
      </v-card-text>
      <v-divider />

      <v-col>
        <v-card-text>
          <v-icon>mdi-chat</v-icon>
          Comments
          <v-row>
            <v-col sm="8">
              <v-text-field v-model="comment" label="...comments"></v-text-field>
            </v-col>
            <v-col class="text-right">
              <v-btn :disabled="comment === ''" @click="commentWrite(idx)">Write</v-btn>
            </v-col>
          </v-row>
        </v-card-text>
      </v-col>
      <!-- comments area -->
      <v-col v-for="(cmt, idx2) in card.comments">
        <v-row justify="center">
          <v-col sm="8">
            <span readonly>{{cmt.content}}</span>
          </v-col>
          <v-col sm="2">
            <span readonly>{{cmt.author}}</span>
          </v-col>
          <v-col class="text-right">{{cmt.date}}</v-col>
        </v-row>
        <v-divider></v-divider>
      </v-col>
    </v-card>
  </v-col>
</v-row>
</template>
<script>
export default {
  name: "CardList",
  props: ['cards'],
  methods: {
    commentWrite(idx) {
      const nowDate = (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10)
      let dictObj = {}
      dictObj['author'] = 'nowAuthor'
      dictObj['content'] = this.comment
      dictObj['date'] = nowDate
      this.comment = ''
      this.cards[idx].comments.push(dictObj)
    }
  },
  data() {
    return {
      comment: ''
    }
  }
}
</script>
