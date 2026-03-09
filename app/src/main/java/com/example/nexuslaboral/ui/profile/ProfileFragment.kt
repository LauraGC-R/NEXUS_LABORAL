package com.example.nexuslaboral.ui.profile

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nexuslaboral.R
import com.example.nexuslaboral.data.session.SessionManager

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLogout = view.findViewById<Button>(R.id.btnLogout)
        val sessionManager = SessionManager(requireContext())

        btnLogout.setOnClickListener {
            sessionManager.logout()
            findNavController().navigate(R.id.navigation_login)
        }
    }
}