package com.example.shopcustomer_stable.common

import android.widget.EditText

const val PRODUCT_IMAGES_FOLDER_PATH = "Product_images"
const val PRODUCT_DISPLAY_IMAGES_FOLDER_PATH = "Product_Display_images"
const val PRODUCT_PATH = "Product_path"

fun returnText(view: EditText): String {
    return view.text.toString()
}
