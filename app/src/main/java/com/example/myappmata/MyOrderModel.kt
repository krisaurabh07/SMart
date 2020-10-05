package com.example.myappmata

data class MyOrderModel(val itemicon: Int) {

    object orderSuplier {
        val orderDataList = listOf(
            MyOrderModel(R.drawable.cat1),
            MyOrderModel(R.drawable.cat2),
            MyOrderModel(R.drawable.cat3),
            MyOrderModel(R.drawable.cat4),
            MyOrderModel(R.drawable.cat5),
            MyOrderModel(R.drawable.cat6)
        )
    }
}
