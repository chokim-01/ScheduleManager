<template>
<div id="sidebar">
  <aside :class="`${!is_expanded ? 'is-expanded':''}`" v-if="$route.path !== '/'">
    <div class="menu-toggle-wrap">
      <button class="menu-toggle" @click="ToggleMenu">
        <b-icon class="arrow-icon" icon="chevron-double-right"></b-icon>
      </button>
    </div>

    <h3>Menu</h3>
    <div class="menu">
      <router-link class="button" to="/profile/overview">
        <b-icon class="icons" icon="inbox"></b-icon>
        <span class="text">Overview</span>
      </router-link>
      <router-link class="button" to="/profile/edit">
        <b-icon class="icons" icon="info-circle"></b-icon>
        <span class="text">Edit</span>
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
<script setup>
import {
  ref
} from 'vue'

const is_expanded = ref(false)

const ToggleMenu = () => {
  is_expanded.value = !is_expanded.value
}
</script>

<style lang="scss" scoped>
aside {
    z-index: 9999;
    top: 55px;
    position: fixed;
    float: left;
    display: flex;
    flex-direction: column;
    width: calc(2rem + 32px);
    min-height: 100vh;
    overflow: hidden;
    padding: 1rem;
    background-color: var(--dark);
    color: var(--light);
    padding-bottom: 50%;
    transition: 0.2s ease-out;

    button {
        cursor: pointer;
        appearance: none;
        border: none;
        outline: none;
        background: none;
        color: var(--light);
    }

    .menu-toggle-wrap {
        display: flex;
        justify-content: flex-end;
        margin-bottom: 1rem;

        position: relative;
        top: 0;
        transition: 0.2s ease-out;

        .menu-toggle {
            transition: 0.2s ease-out;

            .arrow-icon {
                font-size: 1rem;
                color: var(--light);
            }

            &:hover {
                .arrow-icon {
                    color: var(--primary);
                }
            }
        }
    }

    .button .text,
    h3 {
        opacity: 0;
        transition: 0.3s ease-out;
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

    &.is-expanded {
        width: var(--sidebar-width);

        .menu-toggle-wrap {
            .menu-toggle {
                transform: rotate(-180deg);
            }
        }

        .button .text,
        h3 {
            opacity: 1;
        }

        .button {
            .icons {
                margin-right: 1rem;
            }
        }
    }

    @media (max-width: 768px) {
        position: fixed;
        z-index: 99;

    }
}
</style>
