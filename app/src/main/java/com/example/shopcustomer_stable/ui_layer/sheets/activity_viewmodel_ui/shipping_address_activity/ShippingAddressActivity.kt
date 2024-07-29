package com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.shipping_address_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shopcustomer_stable.R
import com.example.shopcustomer_stable.databinding.ActivityShippingAddressBinding
import com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.payment_activity.PaymentActivity
import com.example.shopcustomer_stable.ui_layer.sheets.fragment_viewmodel_ui.cart.CartFragment

class ShippingAddressActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityShippingAddressBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.continueToShippingBtn.setOnClickListener {
            startActivity(Intent(this, PaymentActivity::class.java))
        }

        binding.textView3.setOnClickListener {
            startActivity(Intent(this, CartFragment::class.java))
            finish()
        }

    }
}