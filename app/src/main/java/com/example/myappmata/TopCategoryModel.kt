package com.example.myappmata

data class TopCategoryModel(val itemName: String,val imageIcon: Int)

    object topCategorySuplier {
       val topcategoryList = listOf(
           TopCategoryModel("Home",R.drawable.red_home_24),
           TopCategoryModel("Staples",R.drawable.cat1),
           TopCategoryModel("Snacks & Beverages",R.drawable.cat2),
           TopCategoryModel("Packaged Food",R.drawable.cat3),
           TopCategoryModel("Personal & Baby Care",R.drawable.cat4),
           TopCategoryModel("Household Care",R.drawable.cat5),
           TopCategoryModel("Dairy & Eggs",R.drawable.cat6)


       )

    }









