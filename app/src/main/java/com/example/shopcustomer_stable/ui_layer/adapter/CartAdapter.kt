package com.example.shopcustomer_stable.ui_layer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.shopcustomer_stable.databinding.EachFavItemRvBinding
import com.example.shopcustomer_stable.ui_layer.model.ProductsModel

class CartAdapter(var context: Context, var cartItems: List<ProductsModel>) : Adapter<CartAdapter.MyViewHolder>() {

    inner class MyViewHolder(var binding: EachFavItemRvBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(EachFavItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val items = cartItems[position]

        holder.binding.cartQuantityLayout.visibility = View.VISIBLE
        holder.binding.cartQuantityPriceLayout.visibility = View.VISIBLE
        holder.binding.cartCancelBtn.visibility = View.VISIBLE
        val qty = 2

        items.pImage?.let { holder.binding.favProductIv.setImageResource(it) }
        holder.binding.favPNameTv.text = items.pName
        holder.binding.favPCodeTv.text = items.pCode
        holder.binding.favPSizeTv.text = items.pAvailableSizes?.get(0)?.toString()

        items.pAvailableColors?. let { holder.binding.favPColorCv.background.setTint(it[0]) }
        holder.binding.favPriceTv.text = items.pDiscountedPrice.toString()

        holder.binding.cartQuantityTv.text = qty.toString()
        holder.binding.cartTotalPriceTv.text = items.pDiscountedPrice?.times(qty).toString()

        holder.binding.cartCancelBtn.setOnClickListener{
            holder.itemView.visibility = View.GONE
        }



    }
}