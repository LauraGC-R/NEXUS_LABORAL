package com.example.nexuslaboral.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nexuslaboral.R
import com.example.nexuslaboral.data.session.SessionManager

class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            val sessionManager = SessionManager(requireContext())

            if (sessionManager.isLoggedIn()) {
                findNavController().navigate(R.id.navigation_courses)
            } else {
                findNavController().navigate(R.id.navigation_company)
            }
        }, 1500)
    }
}