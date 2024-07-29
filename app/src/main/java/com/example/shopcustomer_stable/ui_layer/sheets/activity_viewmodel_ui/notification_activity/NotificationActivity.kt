package com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.notification_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shopcustomer_stable.R
import com.example.shopcustomer_stable.databinding.ActivityNotificationBinding
import com.example.shopcustomer_stable.ui_layer.adapter.NotificationAdapter
import com.example.shopcustomer_stable.ui_layer.model.NotificationModel

class NotificationActivity : AppCompatActivity() {
    lateinit var notificationList:ArrayList<NotificationModel>
    private val binding by lazy {
        ActivityNotificationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        notificationList = ArrayList<NotificationModel>()

        showNotifications()

    }

    private fun showNotifications() {
        notificationList.add(NotificationModel(R.drawable.netflix1,"New Deals", "10:30 AM"))
        notificationList.add(NotificationModel(R.drawable.netflix2,"Diwali Dhamaka", "08:30 AM"))
        notificationList.add(NotificationModel(R.drawable.netflix3,"republic day sale", "22:30 AM"))
        notificationList.add(NotificationModel(R.drawable.netflix1,"Christmas Offer", "10:30 AM"))
        notificationList.add(NotificationModel(R.drawable.netflix3,"Black Friday Sale", "08:30 AM"))
        notificationList.add(NotificationModel(R.drawable.netflix1,"New Deals", "22:30 AM"))

        binding.notificationRv.adapter = NotificationAdapter(this, notificationList)
    }
}