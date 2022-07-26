<template>
<v-dialog v-model="show" max-width="500px">
  <div>
    <v-tabs v-model="tab" show-arrows icons-and-text dark grow>
      <v-tabs-slider color="purple darken-4"></v-tabs-slider>
      <v-tab v-for="i in tabs">
        <v-icon large>{{ i.icon }}</v-icon>
        <div class="caption py-1">{{ i.name }}</div>
      </v-tab>
      <v-tab-item>
        <v-card class="px-4">
          <v-card-text>
            <v-form ref="SignInForm" v-model="valid" lazy-validation>
              <v-row>
                <v-col cols="12">
                  <v-text-field v-model="signIn.id" :rules="loginIdRules" label="ID" required></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field v-model="signIn.password" :append-icon="signIn.show ? 'mdi-eye':'mdi-eye-off'" :rules="[rules.required, rules.min]" :type="signIn.show ? 'text' : 'password'" name="input-10-1" label="Password" hint="At least 8 characters"
                    counter @click:append="signIn.show = !signIn.show"></v-text-field>
                </v-col>
                <v-col class="d-flex" cols="12" sm="6" xsm="12">
                </v-col>
                <v-spacer></v-spacer>
                <v-col class="d-flex" cols="12" sm="3" xsm="12" align-end>
                  <v-btn x-large block :disabled="!valid" color="success" @click="signInMethod"> Sign In </v-btn>
                </v-col>
              </v-row>
            </v-form>
          </v-card-text>
        </v-card>
      </v-tab-item>
      <v-tab-item>
        <v-card class="px-4">
          <v-card-text>
            <v-form ref="SignUpForm" v-model="valid" lazy-validation>
              <v-row>
                <v-col cols="12">
                  <v-text-field v-model="signUp.id" :rules="[rules.required]" label="ID" maxlength="20" required></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field v-model="signUp.name" :rules="[rules.required]" label="Name" maxlength="10" required></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field v-model="signUp.email" :rules="emailRules" label="E-mail" required></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field v-model="signUp.password" :append-icon="signUp.show ? 'mdi-eye' : 'mdi-eye-off'" :rules="[rules.required, rules.min]" :type="signUp.show ? 'text' : 'password'" name="input-10-1" label="Password"
                    hint="At least 8 characters" counter @click:append="signUp.show = !signUp.show"></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field block v-model="signUp.verify" :append-icon="signUp.show ? 'mdi-eye' : 'mdi-eye-off'" :rules="[rules.required, passwordMatch]" :type="signUp.show ? 'text' : 'password'" name="input-10-1" label="Confirm Password" counter
                    @click:append="signUp.show = !signUp.show"></v-text-field>
                </v-col>
                <v-spacer></v-spacer>
                <v-col class="d-flex ml-auto" cols="12" sm="3" xsm="12">
                  <v-btn x-large block :disabled="!valid" color="success" @click="signUpMethod">Register</v-btn>
                </v-col>
              </v-row>
            </v-form>
          </v-card-text>
        </v-card>
      </v-tab-item>
    </v-tabs>
  </div>
</v-dialog>
</template>

<script>
export default {
  name: 'SignModal',
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
    },
    passwordMatch() {
      return () => this.signUp.password === this.signUp.verify || "Password must match";
    }
  },
  methods: {
    signInMethod() {
      if (this.$refs.SignInForm.validate()) {
        // submit form to server/API here...
        console.log(this.signIn)
      }
    },
    signUpMethod() {
      if (this.$refs.SignUpForm.validate()) {
        // submit form to server/API here...
        console.log(this.signUp)
      }
    },
    reset() {
      this.$refs.form.reset();
    },
    resetValidation() {
      this.$refs.form.resetValidation();
    }
  },
  data() {
    return {
      tab: 0,
      tabs: [{
          name: "Sign In",
          icon: "mdi-account"
        },
        {
          name: "Sign Up",
          icon: "mdi-account-outline"
        }
      ],
      valid: true,
      signIn: [{
        password: "",
        id: "",
        show: true
      }],
      signUp: [{
        id: "",
        name: "",
        email: "",
        password: "",
        verify: "",
        show: false
      }],
      loginIdRules: [
        v => !!v || "Required",
        v => (v && v.length >= 5) || "Min 5 characters"
      ],
      emailRules: [
        v => !!v || "Required",
        v => /.+@.+\..+/.test(v) || "E-mail must be valid"
      ],
      rules: {
        required: value => !!value || "Required.",
        min: v => (v && v.length >= 8) || "Min 8 characters"
      }
    }
  }
}
</script>
