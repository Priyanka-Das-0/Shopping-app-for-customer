package com.example.shopcustomer_stable.ui_layer.sheets.fragment_viewmodel_ui.home

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shopcustomer_stable.common.PRODUCT_PATH
import com.example.shopcustomer_stable.common.Products
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class HomeViewModel(requireActivity: FragmentActivity) : ViewModel() {
 lateinit var top5product: ArrayList<Products>
       // MutableLiveData(ArrayList<Products?>(null))


    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
    fun gettop5Data(function: (productList:ArrayList<Products>)->Unit) {
        val tempList = ArrayList<Products>()

        Firebase.firestore.collection(PRODUCT_PATH).limit(5).get().addOnSuccessListener {
            tempList.clear()
            for (i in it.documents) {
                val tempProduct = i.toObject<Products>()
                tempList.add(tempProduct!!)
            }
            function(tempList)
        }

    }
}
