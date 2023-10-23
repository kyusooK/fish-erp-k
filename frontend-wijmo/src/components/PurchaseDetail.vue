<template>

    <div>
        <div class="detail-title">
        PurchaseDetail
        </div>
        <v-col>
            <ItemId offline label="ItemId" v-model="value.itemId" :editMode="editMode" @change="change"/>
            <BigDecimal offline label="UnitPrice" v-model="value.unitPrice" :editMode="editMode" @change="change"/>
            <Number label="Qty" v-model="value.qty" :editMode="editMode"/>
        </v-col>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </div>
</template>

<script>
import BaseEntity from './base-ui/BaseEntity'

export default {
    name: 'PurchaseDetail',
    mixins:[BaseEntity],
    components:{
    },
    data: () => ({
        path: 'PurchaseDetails',
    }),
    props: {
    },
    watch: {
        value(val){
            this.value = val;
            this.change();
        },
    },
    async created(){
        if (this.value && this.value.id !== undefined) {
            this.value = await this.repository.findById(this.value.id)
        }
    },
    methods: {
        pick(val){
            this.value = val;
            this.change();
        },
    }
}
</script>

