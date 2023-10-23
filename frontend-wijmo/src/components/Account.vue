<template>
    <div>
        <String label="계정 이름" v-model="value.accountName" :editMode="editMode"/>
        <String label="대표자" v-model="value.representative" :editMode="editMode"/>
        <String label="사업자 번호" v-model="value.businessRegistrationNumber" :editMode="editMode"/>
        <String label="업종" v-model="value.industry" :editMode="editMode"/>
        <String label="종목" v-model="value.category" :editMode="editMode"/>
        <String label="거래처 구분" v-model="value.customerType" :editMode="editMode"/>
        <Address offline label="주소" v-model="value.address" :editMode="editMode" @change="change"/>

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
    name: 'Account',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "accounts"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

