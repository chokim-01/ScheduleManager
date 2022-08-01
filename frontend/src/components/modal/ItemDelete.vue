<template>
  <v-dialog v-model="show" max-width="500px">
    <v-card>
      <v-card-title class="text-h5 grey lighten-2">
        Delete {{type}}
      </v-card-title>
      <v-card-text>
        really want delete this? {{content}}
      </v-card-text>
      <v-divider></v-divider>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn color="error" text>
          Delete
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
  name: 'ItemDelete',
  props: ['visible','type','content'],
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
  }
}
</script>
