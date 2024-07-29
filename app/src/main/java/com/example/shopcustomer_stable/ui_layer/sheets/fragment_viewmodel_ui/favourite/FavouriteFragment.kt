package com.example.shopcustomer_stable.ui_layer.sheets.fragment_viewmodel_ui.favourite

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shopcustomer_stable.R
import com.example.shopcustomer_stable.databinding.FragmentFavouriteBinding
import com.example.shopcustomer_stable.ui_layer.adapter.FavItemsAdapter
import com.example.shopcustomer_stable.ui_layer.model.ProductsModel

class FavouriteFragment : Fragment() {

    private var _binding : FragmentFavouriteBinding?=null
    private val binding get() = _binding!!

    private lateinit var viewModel: FavouriteViewModel
    lateinit var favList:ArrayList<ProductsModel>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
//        return inflater.inflate(R.layout.fragment_favourite, container, false)
        _binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        val root = binding.root
        //init viewHolder
        viewModel = ViewModelProvider(this)[FavouriteViewModel::class.java]
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favList = ArrayList<ProductsModel>()
        loadFav()
    }

    private fun loadFav() {
        favList.add(ProductsModel(R.drawable.netflix1,"One Shoulder Linen Dress", 2000, 1400,null,intArrayOf(28,30,32,34,36),intArrayOf(R.color.theme,R.color.green,R.color.hint),20,"dummy specifications\n\ndummy\nspecs",false,"DY435","dresses","12:25 AM"))
        favList.add(ProductsModel(R.drawable.netflix2,"One Shoulder Linen Dress", 5302, 2655,null,intArrayOf(32,34,36),null,20,"dummy specifications",false,"DY435","tops","05:30 PM"))
        favList.add(ProductsModel(R.drawable.netflix3,"One Shoulder Linen Dress", 1600, 1256,null,intArrayOf(28,30,32),null,20,"dummy specifications",false,"DY435","bottoms","05:30 PM"))
        favList.add(ProductsModel(R.drawable.netflix1,"One Shoulder Linen Dress", 655, 452,null,intArrayOf(36),null,20,"dummy specifications",false,"DY435","tops","05:20 PM"))
        favList.add(ProductsModel(R.drawable.netflix2,"One Shoulder Linen Dress", 5150, 3512,null,intArrayOf(28,30),null,20,"dummy specifications",false,"DY435","jumpsuit","06:30 PM"))
        favList.add(ProductsModel(R.drawable.netflix3,"One Shoulder Linen Dress", 1653, 1268,null,intArrayOf(28,30,36),null,20,"dummy specifications",false,"DY435","tops","07:30 PM"))
        favList.add(ProductsModel(R.drawable.netflix3,"One Shoulder Linen Dress", 1653, 1268,null,intArrayOf(28,30,32,34,36),null,20,"dummy specifications",false,"DY435","tops","02:30 PM"))
        favList.add(ProductsModel(R.drawable.netflix1,"One Shoulder Linen Dress", 2000, 1400,null,intArrayOf(28,30),null,20,"dummy specifications",false,"DY435","dresses","10:30 PM"))
        favList.add(ProductsModel(R.drawable.netflix2,"One Shoulder Linen Dress", 5302, 2655,null,intArrayOf(28,30,32,34,36),null,20,"dummy specifications",false,"DY435","tops","12:30 PM"))
        favList.add(ProductsModel(R.drawable.netflix3,"One Shoulder Linen Dress", 1600, 1256,null,intArrayOf(28,30,36),null,20,"dummy specifications",false,"DY435","bottoms","05:30 PM"))
        favList.add(ProductsModel(R.drawable.netflix1,"One Shoulder Linen Dress", 655, 452,null,intArrayOf(28,34,36),null,20,"dummy specifications",false,"DY435","tops","05:30 PM"))
        favList.add(ProductsModel(R.drawable.netflix2,"One Shoulder Linen Dress", 5150, 3512,null,intArrayOf(28,30,32,34,36),null,20,"dummy specifications",false,"DY435","jumpsuit","05:30 PM"))
        favList.add(ProductsModel(R.drawable.netflix3,"One Shoulder Linen Dress", 1653, 1268,null,intArrayOf(28,30,32),null,20,"dummy specifications",false,"DY435","tops","03:30 PM"))
        favList.add(ProductsModel(R.drawable.netflix3,"One Shoulder Linen Dress", 1653, 1268,null,intArrayOf(28,30,32,34,36),null,20,"dummy specifications",false,"DY435","tops","09:30 PM"))

//        binding.favRv.adapter = context?.let { FavItemsAdapter(it, favList) }
        binding.favRv.adapter = FavItemsAdapter(requireContext(), favList)

    }

}