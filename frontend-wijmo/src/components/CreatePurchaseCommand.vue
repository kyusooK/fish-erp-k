<template>

    <v-card outlined>
        <v-card-title>
            CreatePurchase
        </v-card-title>

        <v-card-text>
            <String label="PurchaseType" v-model="value.purchaseType" :editMode="editMode"/>
            <String label="SupplierCode" v-model="value.supplierCode" :editMode="editMode"/>
            <Date label="PurchaseDate" v-model="value.purchaseDate" :editMode="editMode"/>
            <Date label="WarehouseArrivalDate" v-model="value.warehouseArrivalDate" :editMode="editMode"/>
            <Date label="StorageFeePaymentDate" v-model="value.storageFeePaymentDate" :editMode="editMode"/>
            <Boolean label="StorageFeePaymentStatus" v-model="value.storageFeePaymentStatus" :editMode="editMode"/>
            <String label="MainShipName" v-model="value.mainShipName" :editMode="editMode"/>
            <String label="ProductName" v-model="value.productName" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="createPurchase"
            >
                CreatePurchase
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'CreatePurchaseCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.purchaseType = '';
            this.value.supplierCode = '';
            this.value.purchaseDate = '2023-10-23';
            this.value.warehouseArrivalDate = '2023-10-23';
            this.value.storageFeePaymentDate = '2023-10-23';
            this.value.storageFeePaymentStatus = false;
            this.value.mainShipName = '';
            this.value.productName = '';
        },
        watch: {
        },
        methods: {
            createPurchase() {
                this.$emit('createPurchase', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

