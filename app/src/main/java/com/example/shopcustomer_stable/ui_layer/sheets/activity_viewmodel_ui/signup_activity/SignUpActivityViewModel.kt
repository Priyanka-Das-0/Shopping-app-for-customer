package com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.signup_activity

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.shopcustomer_stable.R
import com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.main_activity.MainActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivityViewModel(val context: Activity) : ViewModel() {


    fun signUp(email: String, password: String) {
        Firebase.auth.createUserWithEmailAndPassword(
            email,
            password
        ).addOnCompleteListener {
            if (it.isSuccessful) {
                diaShowDiaLog()
            } else {
                Toast.makeText(context, it.exception?.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }


    fun diaShowDiaLog() {

        val dialog = Dialog(context)
        dialog.setContentView(R.layout.registration_completed_dialog)

        val lp = WindowManager.LayoutParams()
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        if (Build.VERSION_CODES.S <= Build.VERSION.SDK_INT) {
            lp.blurBehindRadius = 16
        }

        lp.flags = WindowManager.LayoutParams.FLAG_BLUR_BEHIND

        dialog.window?.attributes = lp
        dialog.setCancelable(false)
        dialog.show()

        dialog.findViewById<Button>(R.id.done_btn).setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
            context.finish()
        }
    }
}