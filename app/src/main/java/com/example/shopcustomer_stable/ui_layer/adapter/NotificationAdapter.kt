package com.example.shopcustomer_stable.ui_layer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.shopcustomer_stable.R
import com.example.shopcustomer_stable.databinding.EachNotificationItemRvBinding
import com.example.shopcustomer_stable.ui_layer.model.NotificationModel

class NotificationAdapter(var context: Context, var notificationList: List<NotificationModel>) : Adapter<NotificationAdapter.MyViewHolder>() {

    inner class MyViewHolder(var binding: EachNotificationItemRvBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(EachNotificationItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return notificationList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val notification = notificationList[position]

        holder.binding.notificationIv.setImageResource(R.drawable.netflix1)
        holder.binding.notificationTitleTv.text = notification.nTitle
        holder.binding.notificationTimeTv.text = notification.nTime

        if (notification.nTime.equals(System.currentTimeMillis())){
            holder.binding.notificationTimeTv.text = context.getString(R.string.just_now)
        }


    }

}