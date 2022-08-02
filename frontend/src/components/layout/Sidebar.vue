<template>
  <v-navigation-drawer id="app-drawer" app color="grey" floating persistent mobile-breakpoint="960" width="280" v-if="getSidebarState">
    <div>
      <v-layout class="fill-height" column>
        <v-list>
          <v-list-item>
            <v-toolbar-title>
              <v-icon class="mr-2">{{title}}</v-icon>
            </v-toolbar-title>
          </v-list-item>
          <hr class="mt-2 mb-2">
          <v-list-item-group active-class="white--text">
            <template v-for="menu in menus">
              <template v-if="menu.childrens">
                <!-- 자식 메뉴가 있는경우 -->
                <v-list-group :prepend-icon="menu.icon" :key="menu.id">
                  <template v-slot:activator>
                    <v-list-item-title>{{menu.title}}</v-list-item-title>
                  </template>
                  <template v-for="children in menu.childrens">
                    <v-list-item :to="children.to" :key="children.id" class="ml-2">
                      <v-list-item-icon>
                        <v-icon>{{children.icon}}</v-icon>
                      </v-list-item-icon>
                      <v-list-item-title>
                        {{children.text}}
                      </v-list-item-title>
                    </v-list-item>
                  </template>
                </v-list-group>
              </template>
              <template v-else>
                <!-- 단일 메뉴일 경우 -->
                <v-list-item :to="menu.to" :key="menu.id">
                  <v-list-item-icon>
                    <v-icon>{{menu.icon}}</v-icon>
                  </v-list-item-icon>
                  <v-list-item-title>{{menu.text}}</v-list-item-title>
                </v-list-item>
              </template>
            </template>
          </v-list-item-group>
        </v-list>
      </v-layout>
    </div>
  </v-navigation-drawer>
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
          this.menus = [...this.profile]
          this.title = 'My profile'
          console.log("to profile")
          break
        case 'project':
          if (state[2] === 'undefined') {
            console.log("here")
            break
          }
          this.projectDetail.forEach((value, index, array) => {
            console.log(value.to)
            const uri = '/project/' + state[2]
            if (value.to < 10) {
              this.projectDetail[index].to = uri + value.to
            } else {
              var lastIndex = value.to.lastIndexOf('/')
              this.projectDetail[index].to = uri + value.to.substring(lastIndex, value.to.length)
            }
          })
          this.menus = [...this.projectDetail]
          this.title = 'Project no : ' + state[2]
          console.log("to Project")
          break
        case 'projects':
          if (state[2] === 'all')
            return false
          this.menus = [...this.projects]
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
      menus: [],
      profile: [{
          id: 1,
          to: '/profile/overview',
          icon: 'mdi-inbox',
          text: 'Overview'
        },
        {
          id: 2,
          to: '/profile/edit',
          icon: 'mdi-account-cog',
          text: 'Info'
        }
      ],
      projects: [{
          id: 1,
          to: '/projects/my',
          icon: 'mdi-layers-triple-outline',
          text: 'My projects'
        },
        {
          id: 2,
          to: '/projects/notifications',
          icon: 'mdi-bell-alert-outline',
          text: 'Notifications'
        },
        {
          id: 3,
          to: '/projects/todo',
          icon: 'mdi-calendar-clock',
          text: 'Today Todos'
        },
      ],
      projectDetail: [{
          id: 1,
          to: '/detail',
          icon: 'mdi-inbox',
          text: 'Detail'
        },
        {
          id: 2,
          to: '/todo',
          icon: 'mdi-calendar-clock',
          text: 'Today Todo'
        },
        {
          id: 3,
          to: '/issues',
          icon: 'mdi-alarm',
          text: 'Issues'
        },
        {
          id: 4,
          to: '/management',
          icon: 'mdi-application-edit-outline',
          text: 'Management'
        }
      ]
    }
  }
}
</script>
<style>
.v-navigation-drawer {
  top:65px !important;
}
</style>
