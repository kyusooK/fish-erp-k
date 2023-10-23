<template>
    <div>
        <String label="품명" v-model="value.itemName" :editMode="editMode"/>
        <String label="코드" v-model="value.itemCode" :editMode="editMode"/>
        <ItemUnit offline label="단위" v-model="value.itemUnit" :editMode="editMode" @change="change"/>

        <v-divider class="border-opacity-100 my-divider"></v-divider>
        <v-layout row justify-end>
            <v-btn
                width="64px"
                color="primary"
                @click="save"
            >
                저장
            </v-btn>
        </v-layout>
    </div>
</template>


<script>

import BaseEntity from './base-ui/BaseEntity'

export default {
    name: 'Item',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "items"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

