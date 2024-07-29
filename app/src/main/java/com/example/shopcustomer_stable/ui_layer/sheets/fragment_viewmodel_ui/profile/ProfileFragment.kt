package com.example.shopcustomer_stable.ui_layer.sheets.fragment_viewmodel_ui.profile

import android.app.Dialog
import android.content.Intent
import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import androidx.annotation.RequiresApi
import com.example.shopcustomer_stable.R
import com.example.shopcustomer_stable.databinding.FragmentProfileBinding
import com.example.shopcustomer_stable.ui_layer.sheets.activity_viewmodel_ui.login_activity.LoginActivity

class ProfileFragment : Fragment() {

    private var _binding:FragmentProfileBinding?=null
    private val binding get() = _binding!!

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        _binding= FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        return view
    }


    @RequiresApi(Build.VERSION_CODES.S)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.logoutBtn.setOnClickListener {
            val dialog = Dialog(requireContext())
            dialog.setContentView(R.layout.logout_confirmation_dialog)
            dialog.setCancelable(false)

            val lp = WindowManager.LayoutParams()
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT
            lp.width = WindowManager.LayoutParams.WRAP_CONTENT
            lp.blurBehindRadius = 12
            lp.flags = WindowManager.LayoutParams.FLAG_BLUR_BEHIND

            dialog.window?.attributes = lp
            dialog.show()

            dialog.findViewById<Button>(R.id.logout_btn).setOnClickListener{
                startActivity(
                    Intent(requireContext(), LoginActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).setFlags(
                        Intent.FLAG_ACTIVITY_CLEAR_TASK).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
            }
            dialog.findViewById<Button>(R.id.cancel_btn).setOnClickListener{
                dialog.dismiss()
            }

        }

    }

}