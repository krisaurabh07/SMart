package com.example.myappmata


class CategoryModel(
    val type: Int,
    val sliderModel: List<SliderModel>,
    val hsModel: List<ProductHShomeModel>,
    val grideModel: List<ProductHShomeModel>,
    val stripaddsModel:List<HomeAddStripModel>,
    val subCategoryModel:List<SubCategoryModel>
)


object categorySuplierModel {

    val categorySuplierList = listOf(
        CategoryModel(
            1,
            crosoulSuplier.crosouls,
            ProductHshomeListSuplier.producthshomelists,
            ProductHshomeListSuplier.producthshomelists,
            HomeAddStripModel.homeaddStripSuplier.stripSuplier,
            SubCategorySuplier.subcategoryList
        ),
        CategoryModel(
            4,
            crosoulSuplier.crosouls,
            ProductHshomeListSuplier.producthshomelists,
            ProductHshomeListSuplier.producthshomelists,
            HomeAddStripModel.homeaddStripSuplier.stripSuplier,
            SubCategorySuplier.subcategoryList

        ),
        CategoryModel(
            0,
            crosoulSuplier.crosouls,
            ProductHshomeListSuplier.producthshomelists,
            ProductHshomeListSuplier.producthshomelists,
            HomeAddStripModel.homeaddStripSuplier.stripSuplier,
            SubCategorySuplier.subcategoryList
        ),
        CategoryModel(
            2,
            crosoulSuplier.crosouls,
            ProductHshomeListSuplier.producthshomelists,
            ProductHshomeListSuplier.producthshomelists,
            HomeAddStripModel.homeaddStripSuplier.stripSuplier,
            SubCategorySuplier.subcategoryList
        ),
        CategoryModel(
            1,
            crosoulSuplier.crosouls,
            ProductHshomeListSuplier.producthshomelists,
            ProductHshomeListSuplier.producthshomelists,
            HomeAddStripModel.homeaddStripSuplier.stripSuplier,
            SubCategorySuplier.subcategoryList
        ),
        CategoryModel(
            3,
            crosoulSuplier.crosouls,
            ProductHshomeListSuplier.producthshomelists,
            ProductHshomeListSuplier.producthshomelists,
            HomeAddStripModel.homeaddStripSuplier.stripSuplier,
            SubCategorySuplier.subcategoryList
        )

    )


}






