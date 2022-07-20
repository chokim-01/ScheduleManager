<template>
<div id="sidebar">
  <aside v-if="getSidebarState">
    <h3>{{title}}</h3>
    <hr />
    <div class="menu">
      <div v-for="(content,i) in menu">
        <router-link class="button" :to="content.to">
          <b-icon class="icons" :icon="content.icon"></b-icon>
          <span class="text">{{content.text}}</span>
        </router-link>
      </div>
    </div>
    <div class="menu">
      <router-link class="button bottom" to="/">
        <b-icon class="icons" icon="box-arrow-right"></b-icon>
        <span class="text">LogOut</span>
      </router-link>
    </div>
  </aside>
</div>
</template>

<script>
export default {
  name: "Sidebar",
  computed: {
    getSidebarState() {
      const state = this.$route.path.split("/")
      switch (state[1]) {
        case '':
          return false
        case 'profile':
          this.menu = [...this.profile]
          this.title = 'My profile'
          console.log("to profile")
          break
        case 'project':
          if(state[2] === 'undefined') {
            console.log("here")
            break
          }
          this.projectDetail.forEach( (value, index, array) => {
            console.log(value.to)
            const uri = '/project/'+state[2]
            if(value.to < 10) {
              this.projectDetail[index].to = uri +value.to
            } else {
              var lastIndex = value.to.lastIndexOf('/')
              this.projectDetail[index].to = uri + value.to.substring(lastIndex,value.to.length)
            }
          })
          this.menu = [...this.projectDetail]
          this.title = 'Project no : ' + state[2]
          console.log("to Project")
          break
        case 'projects':
          if (state[2] === 'all')
            return false
          this.menu = [...this.projects]
          this.title = 'My projects'
          console.log("to Projects")
          break
        default:
          console.log(" default")
      }
      return state[1]
    }
  },
  data() {
    return {
      title: '',
      menu: [],
      profile: [{
          id: 1,
          to: '/profile/overview',
          icon: 'inbox',
          text: 'Overview'
        },
        {
          id: 2,
          to: '/profile/edit',
          icon: 'info-circle',
          text: 'Info'
        }
      ],
      projects: [{
          id: 1,
          to: '/projects/my',
          icon: 'inbox',
          text: 'My projects'
        },
        {
          id: 2,
          to: '/projects/notifications',
          icon: 'inbox',
          text: 'Notifications'
        },
        {
          id: 3,
          to: '/projects/todo',
          icon: 'inbox',
          text: 'Today Todo'
        },
      ],
      projectDetail: [{
          id: 1,
          to: '/detail',
          icon: 'inbox',
          text: 'Detail'
        },
        {
          id: 2,
          to: '/todo',
          icon: 'inbox',
          text: 'Today Todo'
        },
        {
          id: 3,
          to: '/issues',
          icon: 'inbox',
          text: 'Issues'
        },
        {
          id: 4,
          to: '/management',
          icon: 'inbox',
          text: 'Management'
        }
      ]
    }
  }
}
</script>
<style lang="scss" scoped>
aside {
    position: fixed;
    z-index: 9999;
    top: 55px;
    left: 0;
    display: flex;
    flex-direction: column;
    min-height: 100vh;
    overflow: hidden;
    padding: 1rem;
    width: var(--sidebar-width);
    background-color: var(--dark);
    color: var(--light);
    padding-bottom: 50%;
    transition: 0.2s ease-out;

    .bottom {
        position: fixed;
        bottom: 3%;
        width: var(--sidebar-width);
    }
    .button .text,
    h3 {
        opacity: 1;
    }

    .button {
        .icons {
            margin-right: 1rem;
        }
        .logout {
            }
    }

    button {
        cursor: pointer;
        appearance: none;
        border: none;
        outline: none;
        background: none;
        color: var(--light);
    }

    h3 {
        color: var(--grey);
        font-size: 0.875rem;
        margin-bottom: 0.5rem;
        text-transform: uppercase;
    }

    .menu {
        margin: 0 -1rem;

        .button {
            display: flex;
            align-items: center;
            text-decoration: none;

            padding: 0.5rem 1rem;
            transition: 0.2s ease-out;

            .icons {
                font-size: 2rem;
                color: var(--light);
                margin-right: 1rem;
                transition: 0.2s ease-out;
            }

            .text {
                color: var(--light);
                transition: 0.2s ease-out;
            }

            &.router-link-exact-active,
            &:hover {
                background-color: var(--dark-alt);

                .icons,
                .text {
                    color: var(--primary);
                }
            }

            &.router-link-exact-active {
                background-color: var(--dark-alt);
                border-right: 5px solid var(--primary);

                .material-icons,
                .text {
                    color: var(--primary);
                }
            }
        }
    }

    @media (max-width: 1024px) {
        width: calc(2rem + 32px);
        h3 {
            margin-left: -4px;
        }
        .menu {
            transition: 0.3s ease-out;
            .button .text {
                opacity: 0;
            }

        }

    }
}
</style>
