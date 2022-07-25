<template>
<div id="project-detail-section">
  <h1 style="text-align:center;">
    Project Id : {{id}}
  </h1>
  <div class="search-section">
    <h4>Project Style</h4>
    <b-form-select v-model="selected" :options="options" :openFlag="openFlag"></b-form-select>
  </div>
  <b-row class="project-detail">
    <b-col cols="3"  v-for="(cards,i) in formatCards">
      <b-card-group deck class="full-height">
        <b-card>
        <b-card-text>
          {{cards}}
        </b-card-text>
        </b-card>
      </b-card-group>
    </b-col>
  </b-row>

{{titles}}
{{titles_date}}
</div>
</template>
<script>
export default {
  name: "ProjectDetail.vue",
  computed: {
    formatCards() {
      if (this.selected === 'a') {
        // default
        return this.titles
      } else {
        // date
        return this.titles_date
      }
    }
  },
  mounted() {
    let today = new Date();
    for(let i = 0;i<10;i++) {
      today.setDate(today.getDate() + 1)
      this.titles_date.push(today.toLocaleDateString())
    }


  },
  data() {
    return {
      id: this.$route.params.id,
      selected: 'a',
      countOfCard: 2,
      openFlag: false,
      options: [{
          value: 'a',
          text: 'Default'
        },
        {
          value: 'b',
          text: 'Date'
        },
      ],
      titles: ["In progressive", "Todo", "Issue","Done"],
      titles_date: [

      ]
    }
  }
}
</script>
<style lang="scss" scoped>
#project-detail-section {
    display: grid;
    margin-top: 8%;
    transform: translateX(50%);
    width: 50%;

    .b-card-group {
        margin: 50px auto;
        .b-card {
            position: inherit;
        }
    }
    .search-section {
        float: right;
        width:200px;
        justify-self: end;
    }
    .project-detail {
        margin: 5%;
        height: auto;
        border: 2px solid var(--grey);
        border-radius: 10px;
    }
    .full-height {
      height:100%;
    }
    .b-card-group {
      margin: 50px auto;
      .b-card {
        position: inherit;
      }
    }
}
</style>
