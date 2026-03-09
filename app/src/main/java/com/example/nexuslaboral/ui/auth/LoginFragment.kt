package com.example.nexuslaboral.ui.auth

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nexuslaboral.R
import com.example.nexuslaboral.data.session.SessionManager

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLogin = view.findViewById<Button>(R.id.btnLogin)
        val sessionManager = SessionManager(requireContext())

        btnLogin.setOnClickListener {
            sessionManager.setLoggedIn(true)
            findNavController().navigate(R.id.navigation_courses)
        }
    }
}