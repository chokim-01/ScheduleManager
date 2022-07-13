<template>
<div id="sidebar">
  <aside v-if="$route.path !== '/'">
      <h3>Menu</h3>
      <hr/>
    <div class="menu">
      <router-link class="button" to="/profile/overview">
        <b-icon class="icons" icon="inbox"></b-icon>
        <span class="text">Overview</span>
      </router-link>
      <router-link class="button" to="/profile/edit">
        <b-icon class="icons" icon="info-circle"></b-icon>
        <span class="text">Info</span>
      </router-link>
    </div>
  </aside>
</div>
</template>

<script>
export default {
  name: "ProfileSidebar",
}
</script>
<style lang="scss" scoped>
aside {
    position: fixed;
    z-index: 9999;
    top: 55px;
    left:0;
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

    .button .text,
    h3 {
        opacity: 1;
    }

    .button {
        .icons {
            margin-right: 1rem;
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
