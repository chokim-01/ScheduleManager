<template>
  <div>
    <ProfileSidebar/>
    <div id="edit">
      <!--<form action="" @submit="checkForm"> -->
      <form action="">
        <!-- default -->
        <b-img :src=image_src rounded="circle"/>

        <br/>
        <ImageUpload :image="image" @change="changed"/>
        <input type="text" name="id"/><br/>
        <input readonly type="email" name="id" value="email@email"/><br/>
        <input type="password" name="password"/><br/>
        <button type="submit">Edit</button>
      </form>
    </div>
  </div>
</template>

<script>
import ProfileSidebar from "../components/layout/ProfileSidebar.vue";
import ImageUpload from "../components/ImageUpload.vue";

export default {
  name: "ProfileEdit",
  components: {ProfileSidebar, ImageUpload},
  data() {
    return {
      image_src: require('@/assets/images/default.png'),
      image:""
    }
  },
  methods: {
    changed(value) {
      this.image = value;
      console.log(this.image);
    }
  }
}
</script>

<style scoped>
#edit {
  display: table;
  margin-left: auto;
  margin-right: auto;

}
#edit img {
  width: 10rem;
  height: auto;
}
</style>