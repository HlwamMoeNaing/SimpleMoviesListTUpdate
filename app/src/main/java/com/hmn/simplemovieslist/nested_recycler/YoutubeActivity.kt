package com.hmn.simplemovieslist.nested_recycler

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.hmn.simplemovieslist.R

class YoutubeActivity : AppCompatActivity() {
    lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube)

        val toolbar = findViewById<Toolbar>(R.id.toolbar_youtube)
       setSupportActionBar(toolbar)


        webView = findViewById(R.id.webView)
        loadUtube()
        val webSetting = webView.settings
        webSetting.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()


    }

    fun loadUtube() {
        val videoId = intent.getStringExtra("videoId")
        webView.loadUrl("https://www.youtube.com/watch?v=" + videoId)

    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }


}

