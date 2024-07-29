package com.example.shopcustomer_stable.ui_layer.adapter.mini_views_adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopcustomer_stable.databinding.ProductColorListRvBinding

class ProductColorListAdapter(var context: Context, var colorList : IntArray): RecyclerView.Adapter<ProductColorListAdapter.MyViewHolder>() {

    inner class MyViewHolder(var binding: ProductColorListRvBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ProductColorListRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return colorList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val colors = colorList[position]

//        colors.pAvailableColors?.let { holder.binding.pItemColorView.background.setTint(it[0]) }
        holder.binding.pItemColorView.background

    }
}