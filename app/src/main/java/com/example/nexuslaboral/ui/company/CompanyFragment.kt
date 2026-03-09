package com.example.nexuslaboral.ui.company

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.nexuslaboral.R

class CompanyFragment : Fragment(R.layout.fragment_company) {

    private val VIDEO_EMPRESA = "sN8_xJp30Dc"      // Video 3 niveles de empaque
    private val VIDEO_SANTA_CATARINA = "llcuJJPnsqg" // Video Conmersa en Monterrey

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val boxEmpresa = view.findViewById<FrameLayout>(R.id.boxEmpresaThumb)
        val boxSite = view.findViewById<FrameLayout>(R.id.boxSiteThumb)
        val imgEmpresa = view.findViewById<ImageView>(R.id.imgEmpresaThumb)
        val imgSite = view.findViewById<ImageView>(R.id.imgSiteThumb)

        // Click para reproducir DENTRO de la app
        boxEmpresa.setOnClickListener {
            imgEmpresa.visibility = View.GONE
            reproducirVideoAqui(boxEmpresa, VIDEO_EMPRESA)
        }

        boxSite.setOnClickListener {
            imgSite.visibility = View.GONE
            reproducirVideoAqui(boxSite, VIDEO_SANTA_CATARINA)
        }

        // (OPCIONAL) Click largo para abrir en YouTube
        boxEmpresa.setOnLongClickListener {
            abrirEnYouTube(VIDEO_EMPRESA)
            true
        }

        boxSite.setOnLongClickListener {
            abrirEnYouTube(VIDEO_SANTA_CATARINA)
            true
        }
    }

    private fun reproducirVideoAqui(contenedor: FrameLayout, videoId: String) {
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
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
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

    private fun abrirEnYouTube(videoId: String) {
        try {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$videoId")))
        } catch (e: Exception) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=$videoId")))
        }
    }
}