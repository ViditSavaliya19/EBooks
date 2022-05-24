package com.example.ebooks.Screen.ReadBooK_Screen.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View.GONE
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.ebooks.databinding.ActivityReadBookBinding


class ReadBook_Activity : AppCompatActivity() {
    lateinit var binding: ActivityReadBookBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var data = intent.getStringExtra("link")

        binding.webView.setWebChromeClient(object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, progress: Int) {
                if (progress == 100) {
                    binding.progressCircular.visibility = GONE
                }
            }
        })

        binding.webView.settings.javaScriptEnabled = true
        binding.webView.setWebViewClient(WebViewClient())
        binding.webView.settings.setSupportZoom(true)
        binding.webView.loadUrl("$data")


    }
}