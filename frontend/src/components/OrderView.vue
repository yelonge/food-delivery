<template>

    <v-data-table
        :headers="headers"
        :items="order"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'OrderView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "orderId", value: "orderId" },
                { text: "status", value: "status" },
                { text: "customerId", value: "customerId" },
                { text: "menuId", value: "menuId" },
                { text: "qty", value: "qty" },
                { text: "address", value: "address" },
            ],
            order : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/orders'))

            temp.data._embedded.orders.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.order = temp.data._embedded.orders;
        },
        methods: {
        }
    }
</script>

