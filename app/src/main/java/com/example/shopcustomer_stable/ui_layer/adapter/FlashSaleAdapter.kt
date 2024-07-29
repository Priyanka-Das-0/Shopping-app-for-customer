package com.example.shopcustomer_stable.ui_layer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.shopcustomer_stable.common.Products
import com.example.shopcustomer_stable.databinding.EachFlashSaleItemRvBinding

class FlashSaleAdapter(var context: Context, var productList: ArrayList<Products>) : Adapter<FlashSaleAdapter.MyViewHolder>() {

    inner class MyViewHolder(var binding: EachFlashSaleItemRvBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(EachFlashSaleItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return productList.size
    }
    fun update(List:ArrayList<Products>){
        productList?.clear()
        productList?.addAll(List)
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val product = productList?.get(position)


        holder.binding.flashSaleProductIv.load(product?.productDisplayImage){
           // placeholder(R.drawable) ussed to show a image when actual image is getting loaded
        }
        holder.binding.flashSaleProductNameTv.text = product?.productName
        holder.binding.flashSaleProductCodeTv.text = product?.uid.toString()
        holder.binding.flashSaleProductDiscountedPriceTv.text = if(
            product?.productPrice ==null || product?.productDiscountPercent== null){
            ""
        }
        else{
            (product.productPrice!! - (product.productDiscountPercent!! * product.productPrice!! /100)).toString()}
       /* holder.binding.flashSaleProductPriceTv.text = product.pPrice.toString()
        holder.binding.flashSaleProductPriceTv.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG

//        val priceDifference:Float = product.pPrice - product.pDiscountedPrice!!.toFloat()
        val priceDifference:Float = product.pPrice?.minus(product.pDiscountedPrice!!)!!.toFloat()
//        val ogPrice:Float = product.pPrice.toFloat()
        val ogPrice:Float = product.pPrice!!.toFloat()
        val discountPercent:Float = (priceDifference/ogPrice)*100
        val displayPercent = discountPercent.toString().split(".")

//        holder.binding.flashSaleProductDiscountPercentageTv.text = discountPercent.toString().plus("% off")
        holder.binding.flashSaleProductDiscountPercentageTv.text = displayPercent[0].toString().plus("% off")

        holder.itemView.setOnClickListener{
            context.startActivity(Intent(context, ProductActivity::class.java).putExtra("DATA",product))
        }*/

    }


}


