package com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.signup_activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.example.shopcustomer_stable.common.returnText
import com.example.shopcustomer_stable.databinding.ActivitySignUpBinding
import com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.login_activity.LoginActivity

class SignUpActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }

    val signUpActivityViewModel by viewModels<SignUpActivityViewModel>(
        factoryProducer = {
            object  : ViewModelProvider.Factory{
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return SignUpActivityViewModel(this@SignUpActivity) as T
                }
            }
        }
    )
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            signupButton.setOnClickListener {
                signUpActivityViewModel.signUp(
                    returnText(emailEt),
                    returnText(confirmPasswordEt)

                )

            }
            loginBtn.setOnClickListener {
                startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
            }
        }


    }


}