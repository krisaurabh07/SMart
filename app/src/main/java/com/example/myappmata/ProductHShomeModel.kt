package com.example.myappmata

data class ProductHShomeModel(var title: String,var price: String,var productimg: Int,var productdescp: String)

object ProductHshomeListSuplier {

    val producthshomelists = listOf(

        ProductHShomeModel("Soft Drinks","₹ 80",R.drawable.product8,"Thumps 2liter"),
        ProductHShomeModel("Suger","₹ 215",R.drawable.product1,"Suger(5Kg)"),
        ProductHShomeModel("Almond","₹ 215",R.drawable.product2,"Almond(200Gram)"),
        ProductHShomeModel("Unibic cookies","₹ 50",R.drawable.product3,"Unibic cookies(200Gram)"),
        ProductHShomeModel("Lays","₹ 50",R.drawable.product4,"Lays Pouch(200Gram)"),
        ProductHShomeModel("Combo Pack","₹ 200",R.drawable.product5,"Colgate Combo Pack"),
        ProductHShomeModel("Chocos","₹ 30",R.drawable.product6,"Chocos 1"),
        ProductHShomeModel("Cups Noodles","₹ 80",R.drawable.product7,"Cups Noodles 1")

    )
}