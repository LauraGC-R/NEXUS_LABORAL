package com.example.nexuslaboral.ui.safety

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.nexuslaboral.R

class SafetyFragment : Fragment(R.layout.fragment_safety) {

    private val VIDEO_SEGURIDAD = "MnJkIl3XJDQ"  // ID del video de seguridad

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val boxSafety = view.findViewById<FrameLayout>(R.id.boxSafetyThumb)
        val imgSafety = view.findViewById<ImageView>(R.id.imgSafetyThumb)

        boxSafety.setOnClickListener {
            imgSafety.visibility = View.GONE
            reproducirVideo(boxSafety, VIDEO_SEGURIDAD)
        }
    }

    private fun reproducirVideo(contenedor: FrameLayout, videoId: String) {
        val webView = WebView(requireContext())
        webView.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        )

        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            loadWithOverviewMode = true
            useWideViewPort = true
        }

        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = WebViewClient()

        val html = """
        <html>
        <head>
            <style>
                body { margin:0; padding:0; background:black; }
                iframe { width:100%; height:100%; border:none; }
            </style>
        </head>
        <body>
            <iframe src="https://www.youtube.com/embed/$videoId?autoplay=1&rel=0"
                    allow="autoplay; encrypted-media"
                    allowfullscreen>
            </iframe>
        </body>
        </html>
        """

        webView.loadDataWithBaseURL("https://www.youtube.com", html, "text/html", "utf-8", null)
        contenedor.addView(webView)
    }
}