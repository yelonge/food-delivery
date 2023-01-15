
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"

import OrderView from "./components/OrderView"
import OrderViewDetail from "./components/OrderViewDetail"
import RestaurantManager from "./components/listers/RestaurantCards"
import RestaurantDetail from "./components/listers/RestaurantDetail"

import DeliveryManager from "./components/listers/DeliveryCards"
import DeliveryDetail from "./components/listers/DeliveryDetail"

import NotificationManager from "./components/listers/NotificationCards"
import NotificationDetail from "./components/listers/NotificationDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },

            {
                path: '/orders',
                name: 'OrderView',
                component: OrderView
            },
            {
                path: '/orders/:id',
                name: 'OrderViewDetail',
                component: OrderViewDetail
            },
            {
                path: '/restaurants',
                name: 'RestaurantManager',
                component: RestaurantManager
            },
            {
                path: '/restaurants/:id',
                name: 'RestaurantDetail',
                component: RestaurantDetail
            },

            {
                path: '/deliveries',
                name: 'DeliveryManager',
                component: DeliveryManager
            },
            {
                path: '/deliveries/:id',
                name: 'DeliveryDetail',
                component: DeliveryDetail
            },

            {
                path: '/notifications',
                name: 'NotificationManager',
                component: NotificationManager
            },
            {
                path: '/notifications/:id',
                name: 'NotificationDetail',
                component: NotificationDetail
            },



    ]
})
