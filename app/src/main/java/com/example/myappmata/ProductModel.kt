package com.example.myappmata

data class ProductModel(var title: String,var price: String,var productimg: Int,var productdescp: String)

object ProductSuplier {

    val productlists = listOf(

        ProductModel("Soft Drinks","₹ 80",R.drawable.product8,"Thumps 2liter"),
        ProductModel("Suger","₹ 215",R.drawable.product1,"Suger(5Kg)"),
        ProductModel("Almond","₹ 215",R.drawable.product2,"Almond(200Gram)"),
        ProductModel("Unibic cookies","₹ 50",R.drawable.product3,"Unibic cookies(200Gram)"),
        ProductModel("Lays","₹ 50",R.drawable.product4,"Lays Pouch(200Gram)"),
        ProductModel("Combo Pack","₹ 200",R.drawable.product5,"Colgate Combo Pack"),
        ProductModel("Chocos","₹ 30",R.drawable.product6,"Chocos 1"),
        ProductModel("Cups Noodles","₹ 80",R.drawable.product7,"Cups Noodles 1")

    )
}