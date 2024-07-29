package com.example.shopcustomer_stable.ui_layer.sheets.fragment_viewmodel_ui.cart

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shopcustomer_stable.R
import com.example.shopcustomer_stable.databinding.FragmentCartBinding
import com.example.shopcustomer_stable.ui_layer.adapter.CartAdapter
import com.example.shopcustomer_stable.ui_layer.model.ProductsModel
import com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.shipping_address_activity.ShippingAddressActivity

class CartFragment : Fragment() {

    private var _binding :FragmentCartBinding?=null
    private val binding get() = _binding!!

    private lateinit var viewModel: CartViewModel
    private lateinit var cartList: ArrayList<ProductsModel>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
//        return inflater.inflate(R.layout.fragment_cart, container, false)
        _binding = FragmentCartBinding.inflate(inflater, container,false)
        val view = binding.root
        viewModel = ViewModelProvider(this)[CartViewModel::class.java]
        cartList = ArrayList()
        return view
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadCartItems()
        binding.subtotalTv.text = getString(R.string.dummy_price)

        binding.checkoutBtn.setOnClickListener{
            startActivity(Intent(requireContext(), ShippingAddressActivity::class.java))
        }

    }

    private fun loadCartItems() {
        cartList.add(ProductsModel(R.drawable.netflix3,"One Shoulder Linen Dress", 1653, 1268,null,intArrayOf(28,30,36),null,20,"dummy specifications",false,"DY435","tops","07:30 PM"))
        cartList.add(ProductsModel(R.drawable.netflix1,"One Shoulder Linen Dress", 2000, 1400,null,intArrayOf(28,30),null,20,"dummy specifications",false,"DY435","dresses","10:30 PM"))
        cartList.add(ProductsModel(R.drawable.netflix3,"One Shoulder Linen Dress", 1653, 1268,null,intArrayOf(28,30,32,34,36),null,20,"dummy specifications",false,"DY435","tops","02:30 PM"))
        cartList.add(ProductsModel(R.drawable.netflix2,"One Shoulder Linen Dress", 5302, 2655,null,intArrayOf(28,30,32,34,36),null,20,"dummy specifications",false,"DY435","tops","12:30 PM"))
        cartList.add(ProductsModel(R.drawable.netflix3,"One Shoulder Linen Dress", 1600, 1256,null,intArrayOf(28,30,36),null,20,"dummy specifications",false,"DY435","bottoms","05:30 PM"))

        binding.favRv.adapter = CartAdapter(requireContext(),cartList)

    }

}