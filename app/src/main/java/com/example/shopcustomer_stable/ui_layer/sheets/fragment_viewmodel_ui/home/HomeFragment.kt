package com.example.shopcustomer_stable.ui_layer.sheets.fragment_viewmodel_ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shopcustomer_stable.R
import com.example.shopcustomer_stable.common.Products
import com.example.shopcustomer_stable.databinding.FragmentHomeBinding
import com.example.shopcustomer_stable.ui_layer.adapter.FlashSaleAdapter
import com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.notification_activity.NotificationActivity
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    lateinit var homeViewModel: HomeViewModel
    private lateinit var productList: ArrayList<Products>
    lateinit var adapter: FlashSaleAdapter
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View {

        val Homeviewmodel: HomeViewModel by viewModels<HomeViewModel>(
            factoryProducer = {
                object  : ViewModelProvider.Factory{
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return HomeViewModel(requireActivity()) as T
                    }
                }
            }
        )
       homeViewModel = Homeviewmodel
        homeViewModel
       // homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        productList =ArrayList<Products>()

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productList= arrayListOf()
        adapter= FlashSaleAdapter(requireContext(),productList)
        binding.saleItemsRv.adapter=adapter
       /* binding.notificationBtn.setOnClickListener{
            startActivity(Intent(context, NotificationActivity::class.java))
        }*/
        homeViewModel.gettop5Data {
            adapter.update(it)
        }
    }

    /*private fun addProductInList() {
        productList.add(Products(R.drawable.netflix1,"One Shoulder Linen Dress", 2000, 1400,null,intArrayOf(28,30,32,34,36),null,20,getString(R.string.dummy_text),false,"DY435","dresses","12:25 AM"))
        productList.add(Products(R.drawable.netflix2,"One Shoulder Linen Dress", 5302, 2655,null,intArrayOf(32,34,36),null,20,getString(R.string.dummy_text),false,"DY435","tops","05:30 PM"))
        productList.add(Products(R.drawable.netflix3,"One Shoulder Linen Dress", 1600, 1256,null,intArrayOf(28,30,32),null,20,getString(R.string.dummy_text),false,"DY435","bottoms","05:30 PM"))
        productList.add(Products(R.drawable.netflix1,"One Shoulder Linen Dress", 655, 452,null,intArrayOf(36),null,20,getString(R.string.dummy_text),false,"DY435","tops","05:20 PM"))
        productList.add(Products(R.drawable.netflix2,"One Shoulder Linen Dress", 5150, 3512,null,intArrayOf(28,30),null,20,getString(R.string.dummy_text),false,"DY435","jumpsuit","06:30 PM"))
        productList.add(Products(R.drawable.netflix3,"One Shoulder Linen Dress", 1653, 1268,null,intArrayOf(28,30,36),null,20,getString(R.string.dummy_text),false,"DY435","tops","07:30 PM"))
        productList.add(Products(R.drawable.netflix3,"One Shoulder Linen Dress", 1653, 1268,null,intArrayOf(28,30,32,34,36),null,20,getString(R.string.dummy_text),false,"DY435","tops","02:30 PM"))
        productList.add(Products(R.drawable.netflix1,"One Shoulder Linen Dress", 2000, 1400,null,intArrayOf(28,30),null,20,getString(R.string.dummy_text),false,"DY435","dresses","10:30 PM"))
        productList.add(Products(R.drawable.netflix2,"One Shoulder Linen Dress", 5302, 2655,null,intArrayOf(28,30,32,34,36),null,20,getString(R.string.dummy_text),false,"DY435","tops","12:30 PM"))
        productList.add(Products(R.drawable.netflix3,"One Shoulder Linen Dress", 1600, 1256,null,intArrayOf(28,30,36),null,20,getString(R.string.dummy_text),false,"DY435","bottoms","05:30 PM"))
        productList.add(Products(R.drawable.netflix1,"One Shoulder Linen Dress", 655, 452,null,intArrayOf(28,34,36),null,20,getString(R.string.dummy_text),false,"DY435","tops","05:30 PM"))
        productList.add(Products(R.drawable.netflix2,"One Shoulder Linen Dress", 5150, 3512,null,intArrayOf(28,30,32,34,36),null,20,getString(R.string.dummy_text),false,"DY435","jumpsuit","05:30 PM"))
        productList.add(Products(R.drawable.netflix3,"One Shoulder Linen Dress", 1653, 1268,null,intArrayOf(28,30,32),null,20,getString(R.string.dummy_text),false,"DY435","tops","03:30 PM"))
        productList.add(Products(R.drawable.netflix3,"One Shoulder Linen Dress", 1653, 1268,null,intArrayOf(28,30,32,34,36),null,20,getString(R.string.dummy_text),false,"DY435","tops","09:30 PM"))

       // binding.saleItemsRv.adapter = context?.let { FlashSaleAdapter(it, productList) }

    }*/

    private fun addDataInCarousel() {
        binding.carousel.addData(CarouselItem(R.drawable.netflix1))
        binding.carousel.addData(CarouselItem(R.drawable.netflix2))
        binding.carousel.addData(CarouselItem(R.drawable.netflix3))
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}