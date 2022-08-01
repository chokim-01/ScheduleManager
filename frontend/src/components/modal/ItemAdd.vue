<template>
  <v-dialog v-model="show" max-width="500px">
    <v-card>
      <v-card-title class="text-h5 grey lighten-2">
        Add Todo
      </v-card-title>
      <v-divider></v-divider>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn color="primary" text>
          Add
        </v-btn>
        <v-btn color="primary" text @click="show=false">
          Cancel
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>
<script>
export default {
  name: 'ItemAdd',
  props: ['visible'],
  computed: {
    show: {
      get() {
        return this.visible
      },
      set(value) {
        if (!value) {
          this.$emit('close')
        }
      }
    }
  },
  mounted() {
    console.log(1423)
  }
}
</script>
