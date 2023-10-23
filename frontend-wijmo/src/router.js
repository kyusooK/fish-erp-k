
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import AccountManager from "./components/ui/AccountGrid"
import ItemManager from "./components/ui/ItemGrid"

import PurchaseManager from "./components/ui/PurchaseGrid"




export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/accounts',
                name: 'AccountManager',
                component: AccountManager
            },
            {
                path: '/items',
                name: 'ItemManager',
                component: ItemManager
            },

            {
                path: '/purchases',
                name: 'PurchaseManager',
                component: PurchaseManager
            },





    ]
})
