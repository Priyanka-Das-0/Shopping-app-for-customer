package com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.payment_activity

import android.app.Dialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import androidx.annotation.RequiresApi
import com.example.shopcustomer_stable.R
import com.example.shopcustomer_stable.databinding.ActivityPaymentBinding
import com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.main_activity.MainActivity
import com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.shipping_address_activity.ShippingAddressActivity

class PaymentActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityPaymentBinding.inflate(layoutInflater)
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.paynowBtn.setOnClickListener {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.payment_success_dialog)

            val lp = WindowManager.LayoutParams()
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT
            lp.width = WindowManager.LayoutParams.WRAP_CONTENT
            lp.blurBehindRadius = 12
            lp.flags = WindowManager.LayoutParams.FLAG_BLUR_BEHIND

            dialog.window?.attributes = lp
            dialog.setCancelable(false)
            dialog.show()

            dialog.findViewById<Button>(R.id.start_shopping_btn).setOnClickListener {
                startActivity(
                    Intent(
                        this,
                        MainActivity::class.java
                    ).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                )
            }

        }

        binding.textView2.setOnClickListener {
            startActivity(Intent(this, ShippingAddressActivity::class.java))
            finish()
        }

    }
}