package com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.product_activity

import android.content.Intent
import android.graphics.Paint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.shopcustomer_stable.R
import com.example.shopcustomer_stable.databinding.ActivityProductBinding
import com.example.shopcustomer_stable.ui_layer.adapter.mini_views_adapters.ProductColorListAdapter
import com.example.shopcustomer_stable.ui_layer.adapter.mini_views_adapters.ProductSizeListAdapter
import com.example.shopcustomer_stable.ui_layer.model.ProductsModel
import com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.payment_activity.PaymentActivity

class ProductActivity : AppCompatActivity() {
    lateinit var productList: ArrayList<ProductsModel>
    private var product = ProductsModel()
    var selectedQuantity: Long = 1

    private val binding by lazy {
        ActivityProductBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        productList = ArrayList<ProductsModel>()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            product = intent.getSerializableExtra("DATA", ProductsModel::class.java)!!
        } else {
            product = intent.getSerializableExtra("DATA") as ProductsModel
        }

        //        binding.imageView.background = product.pImage!!
        binding.imageView.background = resources.getDrawable(product.pImage!!)
        binding.pNameTv.text = product.pName
        binding.pDiscountedPriceTv.text = product.pDiscountedPrice.toString()
        binding.pPriceTv.text = product.pPrice.toString()
        binding.pPriceTv.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        binding.selectedQuantityTv.text = selectedQuantity.toString()
        binding.pSpecsTv.text = product.pSpecificationDetails

        val priceDifference: Float = product.pPrice?.minus(product.pDiscountedPrice!!)!!.toFloat()
        val ogPrice: Float = product.pPrice!!.toFloat()
        val discountPercent: Float = (priceDifference / ogPrice) * 100
        val displayPercent = discountPercent.toString().split(".")

        //holder.binding.flashSaleProductDiscountPercentageTv.text = discountPercent.toString().plus("% off")
        binding.pDiscountPercentageTv.text = displayPercent[0].toString().plus("% off")

        binding.plusBtnIv.setOnClickListener {
            if (selectedQuantity < product.pAvailableStock!! && selectedQuantity > 0) {
                binding.selectedQuantityTv.text = selectedQuantity++.toString()
            } else {
                Toast.makeText(this, "quantity not allowed", Toast.LENGTH_SHORT).show()
            }
        }

        binding.minusBtnIv.setOnClickListener {
            if (selectedQuantity >= 1) {
                binding.selectedQuantityTv.text = selectedQuantity--.toString()
            } else {
                Toast.makeText(this, "minimum quantity should be 1", Toast.LENGTH_SHORT).show()
            }
        }

        binding.pAvailableSizeRv.adapter = product.pAvailableSizes?.let { ProductSizeListAdapter(this, it) }
        binding.pColorRv.adapter = product.pAvailableColors?.let { ProductColorListAdapter(this, it) }

        binding.buyNowBtn.setOnClickListener{
            startActivity(Intent(this, PaymentActivity::class.java).putExtra("DATA",product))
        }
    }
}