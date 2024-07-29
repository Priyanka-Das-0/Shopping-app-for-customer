package com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.login_activity

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.main_activity.MainActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivityViewModel(var activity: Activity) : ViewModel() {

    fun loginUser(email: String, password: String) {
        Firebase.auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                activity.startActivity(Intent(activity, MainActivity::class.java))
                activity.finish()
            } else {
                Toast.makeText(activity, it.exception?.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}