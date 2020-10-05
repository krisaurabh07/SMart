package com.example.myappmata

data class ProductCategoryModel(var productcatName:String)

object ProductCategorySuplier {

    val productCategory = listOf(
        ProductCategoryModel("Rice"),
        ProductCategoryModel("Dal"),
        ProductCategoryModel("Atta"),
        ProductCategoryModel("Salt"),
        ProductCategoryModel("Oil"),
        ProductCategoryModel("Masala"),
        ProductCategoryModel("Biscut")

    )
}