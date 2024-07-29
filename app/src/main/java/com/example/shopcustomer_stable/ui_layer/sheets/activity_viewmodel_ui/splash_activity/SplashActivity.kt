package com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.splash_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.shopcustomer_stable.R
import com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.login_activity.LoginActivity
import com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.main_activity.MainActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


//        runBlocking {
//            delay(1500)
//            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
//            finish()
//        }
//
//       ============= animation not visible with this method ================

        Handler(Looper.getMainLooper()).postDelayed({

            if (Firebase.auth.currentUser == null) {
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }
        }, 500)

    }
}