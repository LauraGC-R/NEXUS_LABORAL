package com.example.nexuslaboral.video

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.nexuslaboral.databinding.ActivityVideoWebViewBinding

class VideoWebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVideoWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val videoId = intent.getStringExtra("VIDEO_ID") ?: return
        val videoTitle = intent.getStringExtra("VIDEO_TITLE") ?: "Video"

        // Configurar toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = videoTitle
        binding.toolbar.setNavigationOnClickListener { finish() }

        // Cargar video
        loadVideo(videoId)
    }

    private fun loadVideo(videoId: String) {
        binding.webView.apply {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            settings.loadWithOverviewMode = true
            settings.useWideViewPort = true

            webViewClient = WebViewClient()
            webChromeClient = WebChromeClient()

            // Usar HTML personalizado (más compatible)
            val html = """
            <html>
            <head>
                <style>
                    body, html { 
                        margin:0; 
                        padding:0; 
                        width:100%; 
                        height:100%; 
                        background: black;
                    }
                </style>
            </head>
            <body>
                <iframe width="100%" height="100%" 
                    src="https://www.youtube.com/embed/$videoId?autoplay=1&rel=0" 
                    frameborder="0" 
                    allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" 
                    allowfullscreen>
                </iframe>
            </body>
            </html>
            """
            loadData(html, "text/html", "utf-8")
        }
    }

    override fun onBackPressed() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}