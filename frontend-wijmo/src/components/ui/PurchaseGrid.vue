<template>
    <div style="max-height:80vh;">
        <div class="hierarchy">
            <div>Purchase &nbsp; ></div>
            <div>&nbsp; 매입</div>
        </div>
        <div class="gs-bundle-of-buttons" style="max-height:10vh;">
            <v-btn @click="addNewRow" class="contrast-primary-text" small color="primary" :disabled="!hasRole('PurchaseManager')">
                <v-icon small>mdi-plus-circle-outline</v-icon>등록
            </v-btn>
            <v-btn  @click="editSelectedRow" class="contrast-primary-text" small color="primary" :disabled="!hasRole('')">
                <v-icon small>mdi-pencil</v-icon>수정
            </v-btn>
            <v-btn @click="deleteSelectedRows" class="contrast-primary-text" small color="primary" :disabled="!hasRole('')">
                <v-icon small>mdi-minus-circle-outline</v-icon>삭제
            </v-btn>
            <excel-export-button class="contrast-primary-text" :exportService="this.exportService" :getFlex="getFlex" />
        </div>
        <QueryPurchase @search="search"></QueryPurchase>


        <!-- the grid -->
        <wj-flex-grid
            ref="flexGrid"
            :key="value.length"
            :autoGenerateColumns="false"
            :allowAddNew="false"
            :allowDelete="true"
            :allowPinning="'SingleColumn'"
            :newRowAtTop="false"
            :showMarquee="true"
            :selectionMode="'MultiRange'"
            :validateEdits="false"
            :itemsSource="value"
            :initialized="flexInitialized"
            :selectionChanged="onSelectionChanged"
            style="margin-top:10px; max-height:65vh;"
            class="wj-felx-grid"
        >
            <wj-flex-grid-filter :filterColumns="['RowHeader','purchaseType','purchaseDate','warehouseArrivalDate','storageFeePaymentDate','storageFeePaymentStatus','mainShipName','productName','accountId','purchaseDetails','accountId',]" />
            <wj-flex-grid-cell-template cellType="RowHeader" v-slot="cell">{{cell.row.index + 1}}</wj-flex-grid-cell-template>
            <wj-flex-grid-column binding="purchaseType" header="매입구분" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="purchaseDate" header="매입일자" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="warehouseArrivalDate" header="입고일자" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="storageFeePaymentDate" header="보관료부담일자" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="storageFeePaymentStatus" header="보관료부담여부" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="mainShipName" header="본선명" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="productName" header="품명" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="itemId" header="품목" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <ItemId v-model="cell.item.itemId" :editMode="editMode"></ItemId>
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
            <wj-flex-grid-column binding="accountId" header="거래처" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <AccountId v-model="cell.item.accountId" :editMode="editMode"></AccountId>
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
        </wj-flex-grid>
        <PurchaseDetailDetailGrid label="PurchaseDetails" offline v-if="selectedRow" v-model="selectedRow.purchaseDetails"/>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <template>
                    <v-card>
                        <v-toolbar
                            color="primary"
                            class="elevation-0"
                            height="50px"
                        >
                            <div style="color:white; font-size:17px; font-weight:700;">매입 등록</div>
                            <v-spacer></v-spacer>
                            <v-icon
                                color="white"
                                small
                                @click="closeDialog()"
                            >mdi-close</v-icon>
                        </v-toolbar>
                        <v-card-text>
                            <Purchase :offline="offline"
                                :isNew="!itemToEdit"
                                :editMode="true"
                                v-model="newValue"
                                @add="append"
                                @edit="edit"
                            />
                        </v-card-text>
                    </v-card>
                </template>
            </v-dialog>
        </v-col>
        <v-col style="margin-bottom:40px;">
            <div class="text-center">
                <v-dialog
                    width="332.5"
                    fullscreen
                    hide-overlay
                    transition="dialog-bottom-transition"
                >
                    <v-btn
                        style="position:absolute; top:2%; right:2%"
                        @click="closeDialog()"
                        depressed
                        icon 
                        absolute
                    >
                        <v-icon>mdi-close</v-icon>
                    </v-btn>
                </v-dialog>
            </div>
        </v-col>
    </div>
</template>

<script>
import BaseGrid from '../base-ui/BaseGrid'

export default {
    name: 'purchaseGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'purchases',
    }),
    watch: {
        newValue: {
            deep:true,
            handler:function(){
                if(!this.newValue){
                    this.newValue = {
                        'purchaseNo': 0,
                        'purchaseType': '',
                        'purchaseDate': '2023-10-23',
                        'warehouseArrivalDate': '2023-10-23',
                        'storageFeePaymentDate': '2023-10-23',
                        'storageFeePaymentStatus': false,
                        'mainShipName': '',
                        'productName': '',
                        'accountId': {},
                        'purchaseDetails': [],
                        'accountId': {},
                    }
                }
            }
        }
    },
    methods:{
    }
}
</script>