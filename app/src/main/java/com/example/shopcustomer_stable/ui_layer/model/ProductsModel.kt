package com.example.shopcustomer_stable.ui_layer.model

import java.io.Serializable

data class ProductsModel(

    var pImage: Int? = null,
    var pName: String? = null,
    var pPrice: Long? = null,
    var pDiscountedPrice: Long? = null,
    var pRating: Float? = null,
    var pAvailableSizes: IntArray? = null,
    var pAvailableColors: IntArray? = null,
    var pAvailableStock: Long? = null,
    var pSpecificationDetails: String? = null,
    var pIsInWishlist: Boolean? = null,
    var pCode: String? = null,
    var category: String? = null,
    var time: String? = null

) : Serializable
