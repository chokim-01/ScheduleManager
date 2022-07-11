<template>
<div id="imgUpload">
  <form method="post" enctype="multipart/form-data">

    <input ref="image" @change="uploadImg()" type="file" id="chooseFile" name="chooseFile" accept="image/*">
  </form>
  <img :src="image_view" alt="">
</div>
</template>

<script>
export default {
  props: ["image"],
  data() {
    return {
      image_view: ""
    }
  },
  methods: {
    uploadImg() {
      const images = this.$refs['image'].files[0]
      this.image_view = URL.createObjectURL(images);

      this.$emit('change', images);
    }
  }
}
</script>

<style lang="scss" scoped>
#imgUpload {
    img {
        width: 15rem;
        height: auto;
    }

}
</style>
