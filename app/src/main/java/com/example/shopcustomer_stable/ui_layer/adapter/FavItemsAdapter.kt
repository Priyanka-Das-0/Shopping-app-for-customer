package com.example.shopcustomer_stable.ui_layer.adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.shopcustomer_stable.databinding.EachFavItemRvBinding
import com.example.shopcustomer_stable.ui_layer.model.ProductsModel
import com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.product_activity.ProductActivity

class FavItemsAdapter(var context: Context, private var favItemsList: List<ProductsModel>) : Adapter<FavItemsAdapter.MyViewHolder>() {

    inner class MyViewHolder(var binding : EachFavItemRvBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(EachFavItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return favItemsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val favItems = favItemsList[position]

        favItems.pImage?.let { holder.binding.favProductIv.setImageResource(it) }
        holder.binding.favPNameTv.text = favItems.pName
        holder.binding.favPCodeTv.text = favItems.pCode
        holder.binding.favPSizeTv.text = favItems.pAvailableSizes?.get(0)?.toString()
//        favItems.pAvailableColors?.let { holder.binding.favPColorCv.background.setTint(it.get(0)) }
        favItems.pAvailableColors?. let { holder.binding.favPColorCv.background.setTint(it[0]) }
        holder.binding.favPriceTv.text = favItems.pDiscountedPrice.toString()

        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context, ProductActivity::class.java).putExtra("DATA",favItems))
        }

    }

}