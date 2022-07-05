<template>
  <div>
    <b-modal id="modal-Sign" centered hide-header hide-footer>
      <b-tabs content-class="mt-3" justified>
        <!-- Sign In Section -->
        <b-tab title="Sign In" active>
          <form>
            <div class="form-group">
              <label>ID</label>
              <input type="text" class="form-control form-control-lg"/>
            </div>
            <div class="form-group">
              <label>Password</label>
              <input type="password" class="form-control form-control-lg"/>
            </div>
            <button type="submit" class="btn btn-dark btn-lg btn-block">Sign In</button>
            <p class="forgot-password text-right mt-2 mb-4">
              <router-link to="/forgotPasswd" @click.native="hideModal()">Forgot password ?</router-link>
            </p>
          </form>

        </b-tab>

        <!-- Sign Up Section -->
        <b-tab title="Sign Up">
          <form>
            <div class="form-group">
              <label>ID</label>
              <input type="text" class="form-control form-control-lg"/>
            </div>
            <div class="form-group">
              <label>NickName</label>
              <input type="text" class="form-control form-control-lg"/>
            </div>
            <div class="form-group">
              <label>Email address</label>
              <input type="email" class="form-control form-control-lg"/>
            </div>
            <div class="form-group">
              <label>Password</label>
              <input type="password" class="form-control form-control-lg"/>
            </div>
            <button type="submit" class="btn btn-dark btn-lg btn-block">Sign Up</button>
          </form>
        </b-tab>
      </b-tabs>
    </b-modal>
  </div>
</template>
<script>
export default {
  name: "SignIn",
  methods: {
    hideModal() {
      this.$root.$emit('bv::hide::modal', 'modal-Sign', '#btnShow')
    }
  }
}
</script>