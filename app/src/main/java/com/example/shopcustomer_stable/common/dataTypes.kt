package com.example.shopcustomer_stable.common

import androidx.annotation.Keep


data class Products(
    var uid: Int=0,
    var productDisplayImage: String?=null,
    var productDisplayImages: ArrayList<String>?= arrayListOf(),
    var productName: String?=null,
    var productDes: String?=null,
    var productPrice: Long?=null,
    var productDiscountPercent: Long?=null,
    var productSize: String?=null,
    var productColor: List<ProductColor>?= arrayListOf()
)

//data class ProductColor(var colorName: String?=null, var colorCode: Int?=null)
{
    // No-argument constructor for Firestore
    constructor() : this(0)
}

@Keep
data class ProductColor(
    var colorName: String? = null,
    var colorCode: Int? = null
) {
    // No-argument constructor for Firestore
    constructor() : this(null, null)
}