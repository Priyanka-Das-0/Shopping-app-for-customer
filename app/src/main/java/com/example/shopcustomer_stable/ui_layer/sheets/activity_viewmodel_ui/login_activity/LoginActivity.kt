package com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.login_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shopcustomer_stable.R
import com.example.shopcustomer_stable.common.returnText
import com.example.shopcustomer_stable.databinding.ActivityLoginBinding
import com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.forgot_pass_activity.ForgotPasswordActivity
import com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.main_activity.MainActivity
import com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.signup_activity.SignUpActivity
import com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.signup_activity.SignUpActivityViewModel

class LoginActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    val loginActivityViewModel by viewModels<LoginActivityViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return LoginActivityViewModel(this@LoginActivity) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)


        binding.apply {
            loginBtn.setOnClickListener {
                    loginActivityViewModel.loginUser(
                        returnText(emailEt),
                        returnText(passwordEt)
                    )
            }



            signupBtn.setOnClickListener {
                startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
            }

            forgotPasswordTvBtn.setOnClickListener {
                startActivity(Intent(this@LoginActivity, ForgotPasswordActivity::class.java))
            }
        }
    }
}