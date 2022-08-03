<template>
<v-dialog v-model="show" max-width="500px">
  <v-card>
    <v-card-title class="text-h5 grey lighten-2">
      Add Todo
    </v-card-title>
    <v-divider></v-divider>
    <v-form ref="ItemAddForm" v-model="valid" lazy-validation>
      <v-card-text>
        <v-row>
          <v-col cols="12" sm="6">
            <v-text-field label="title" :rules="rules" v-model="title">
            </v-text-field>
          </v-col>
          <v-col cols="12" sm="6">
            <v-menu ref="menu" v-model="menu" :close-on-content-click="false" :return-value.sync="date" transition="scale-transition" offset-y min-width="auto">
              <template v-slot:activator="{ on, attrs }">
                <v-text-field v-model="date" :rules="calendarRules" label="Picker in menu" prepend-icon="mdi-calendar" readonly v-bind="attrs" v-on="on"></v-text-field>
              </template>
              <v-date-picker multiple v-model="date" no-title scrollable :min="nowDate">
                <v-spacer></v-spacer>
                <v-btn text color="primary" @click="menu = false">
                  Cancel
                </v-btn>
                <v-btn text color="primary" @click="$refs.menu.save(date)">
                  Ok
                </v-btn>
              </v-date-picker>
            </v-menu>
          </v-col>
        </v-row>
        <v-divider></v-divider>
        {{date}}
        <v-textarea auto-grow counter label="content" v-model="content"></v-textarea>
      </v-card-text>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn :disabled="!valid" color="primary" text @click="itemAddMethod">
          Add
        </v-btn>
        <v-btn color="primary" text @click="show=false">
          Cancel
        </v-btn>
      </v-card-actions>
    </v-form>
  </v-card>
</v-dialog>
</template>
<script>
export default {
  name: 'ItemAdd',
  props: ['visible'],
  computed: {
    nowDate: {
      get() {
        return new Date().toISOString()
      }
    },
    show: {
      get() {
        return this.visible
      },
      set(value) {
        if (!value) {
          this.title = '',
            this.content = '',
            this.date = [],

            this.$emit('close')
        }
      }
    }
  },
  methods: {
    itemAddMethod() {
      if (this.$refs.ItemAddForm.validate()) {
        // axios
        if (this.content === '')
          this.content = this.title
        this.$emit('add', [this.title, this.content, this.date])
      }
    }
  },
  data() {
    return {
      valid: true,
      title: '',
      content: '',
      date: [],
      menu: false,

      rules: [
        v => !!v || "Required"
      ],
      calendarRules: [
        v => (v && v.length >= 1) || "choice Min 1 date"
      ]
    }
  }
}
</script>
