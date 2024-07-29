package com.example.shopcustomer_stable.ui_layer.adapter.mini_views_adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.shopcustomer_stable.databinding.ProductSizeListRvBinding

class ProductSizeListAdapter(var context: Context, var sizeList : IntArray):Adapter<ProductSizeListAdapter.MyViewHolder>() {

    inner class MyViewHolder(var binding: ProductSizeListRvBinding):ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ProductSizeListRvBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun getItemCount(): Int {
        return sizeList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val sizes = sizeList[position]

//        holder.binding.pItemSizeTv.text = sizes.pAvailableSizes?.get(0).toString()
        holder.binding.pItemSizeTv.text = sizes.toString()

    }
}