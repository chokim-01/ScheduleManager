<template>
<div>

  <div id="edit">
    <b-form @submit="onSubmit" @reset="onReset">
      <div id="image-group">
        <b-img :src=form.image_src rounded="circle" />
        <hr />
        </hr />
        <b-form-group label="Edit Profile Image">
          <ImageUpload :image="form.image" @change="changed" />
        </b-form-group>
      </div>
      <hr />
      <b-form-group label="ID">
        <b-form-input readonly id="input-group" v-model="form.id" required></b-form-input>
      </b-form-group>
      <hr />
      <b-form-group label="Email">
        <b-form-input id="input-group" v-model="form.email" type="email" required></b-form-input>
        <b-button class="button-1" @click="emailValidateCheck">validate check</b-button>
      </b-form-group>
      <b-alert :show="validate.emailSuccess" variant="success">U can use this email</b-alert>
      <b-alert :show="validate.emailFail" variant="warning">Email already exists</b-alert>
      <hr />
      <b-form-group label="NickName *">
        <b-form-input id="input-group" v-model="form.name" required></b-form-input>
        <b-button class="button-1" @click="nameValidateCheck">validate check</b-button>
      </b-form-group>
      <b-alert :show="validate.nicknameSuccess" variant="success" >U can use this name</b-alert>
      <b-alert :show="validate.nicknameFail" variant="warning" >Name already exists</b-alert>
      <hr />
        <b-form-group label="Password *">
          <b-form-input id="input-group" v-model="form.password" type="password" placeholder="Enter password" required></b-form-input>
        </b-form-group>

        <div>
          <b-button class="button-2" type="reset" variant="danger">Reset</b-button>
          <b-button class="button-2" type="submit" variant="primary">Edit</b-button>
        </div>
    </b-form>

  </div>

</div>
</template>

<script>
import ImageUpload from "../components/ImageUpload.vue";

export default {
  name: "ProfileEdit",
  components: {
    ImageUpload
  },
  data() {
    return {
      validate: {
        emailSuccess: false,
        emailFail: false,
        nicknameSuccess: false,
        nicknameFail: false
      },
      form: {
        id: '',
        email:'',
        password:'',
        name:'',
        image_src: '',
        image: null
      },
      form_origin: {
        id: 'test-id',
        email:'test-email@email.com',
        password:'',
        name:'test',
        image_src: require('@/assets/images/default.png'),
        image: null
      }
    }
  },
  mounted: function() {
    this.form = this.form_origin;
  },
  methods: {
    changed(value) {
      this.image = value;
      console.log(this.image);
    },
    onSubmit(event) {
      event.preventDefault();
      alert(JSON.stringify(this.form));
    },
    onReset() {
      event.preventDefault();

      this.form = this.form_origin;
      this.validate.emailSuccess = false,
      this.validate.emailFail = false,
      this.validate.nicknameSuccess = false,
      this.validate.nicknameFail = false
    },
    nameValidateCheck() {
      this.validate.nicknameSuccess = true;
    },
    emailValidateCheck() {
      this.validate.emailSuccess = true;
    }
  }
}
</script>

<style lang="scss">
#edit {
  display: table;
  margin-left: auto;
  margin-right: auto;
  margin: 100px auto;
  width:500px;

  #image-group {
    text-align: center;
  }
  #input-group {
    display: inline;
    width:300px;
  }
  img {
    width: 10rem;
    height: auto;
  }
  .button-1 {
    float: right;
  }
  .button-2 {
    float:right;
    margin-left:40px;
    width:60px;
  }
}
</style>
