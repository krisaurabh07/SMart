package com.example.myappmata


data class SubCategoryModel(val categoryName: String,val categoryIcon: Int)

object SubCategorySuplier {

    val subcategoryList = listOf(
        SubCategoryModel("Dals & Pulses",R.drawable.red_home_24),
        SubCategoryModel("Ghee & Oils",R.drawable.cat1),
        SubCategoryModel("Atta & Flours",R.drawable.cat2),
        SubCategoryModel("Masalas & Spices",R.drawable.cat3),
        SubCategoryModel("Rice & Rice Product",R.drawable.cat4),
        SubCategoryModel("Dry Fruits, Nuts & Seeds",R.drawable.cat5),
        SubCategoryModel("Suger, Jaggery & Salt",R.drawable.cat6),
        SubCategoryModel("Suger, Jaggery & Salt",R.drawable.cat6),
        SubCategoryModel("Suger, Jaggery & Salt",R.drawable.cat6)


    )

}
