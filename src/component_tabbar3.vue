<template>
    <div class="app">

        <weiui_tabbar
                ref="reflectName"
                class="tabbar"
                :weiui="{ tabType: 'bottom' }"
                :tabPages="tabPages"></weiui_tabbar>

    </div>
</template>

<style>
    .app {
        flex: 1
    }

    .tabbar {
        flex: 1;
        width: 750px;
    }
</style>

<script>
    export default {
        data() {
            return {
                tabPages: [
                    {
                        title: '首页',
                        selectedIcon: 'home',
                        url: 'http://dotwe.org/raw/dist/b5fd96d8d790f0100bdfc20b93eedf09.bundle.wx',
                    },
                    {
                        title: '好友',
                        selectedIcon: 'http://demo.sc.chinaz.com/Files/pic/icons/6749/g7.png',
                        unSelectedIcon: 'http://demo.sc.chinaz.com/Files/pic/icons/6749/g4.png',
                        url: 'http://dotwe.org/raw/dist/ba938c9aaebe41e5f60b98f90bd0bf61.bundle.wx',
                        message: 9
                    },
                    {
                        title: '圈子',
                        selectedIcon: 'aperture 26sp',
                        url: 'http://dotwe.org/raw/dist/fb6f016b0116969b6b503e1d3a35285f.bundle.wx',
                        message: 18
                    },
                    {
                        title: '设置',
                        selectedIcon: 'gear-b',
                        unSelectedIcon: 'gear-a',
                        url: 'http://dotwe.org/raw/dist/ad0045a7cff0b3a680d9de6dd4806e81.bundle.wx',
                        dot: true
                    },
                ],
            }
        }
    };
</script>
