// state
const sidebarState = {
  state: {
    message: ''
  },
  mutations: {
    setState(state,data) {
      state.message = data
    }
  },
  getters: {
    getMsg(state) {
      return `${state.message}`
    }
  }
}

export default sidebarState
