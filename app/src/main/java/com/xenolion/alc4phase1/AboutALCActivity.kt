package com.xenolion.alc4phase1

import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Bundle
import android.view.MenuItem
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_about_alc.*


class AboutALCActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_alc)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        webViewAboutAlc.webViewClient = webViewClient
        webViewAboutAlc.loadUrl("https://andela.com/alc/")
        swipeRefreshLayout.isRefreshing = true
        swipeRefreshLayout.setOnRefreshListener { webViewAboutAlc.reload() }

    }

    private val webViewClient = object : WebViewClient() {
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            // If the page finishes the loading must stop!
            swipeRefreshLayout.isRefreshing = false
        }

        override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
            super.onReceivedError(view, request, error)
            // If there is an error tell the user! Likely Internet Connection!
            swipeRefreshLayout.isRefreshing = false
            Toast.makeText(
                this@AboutALCActivity,
                "Oops! Check your Internet Connection, then Swipe down to Refresh!",
                Toast.LENGTH_LONG
            ).show()
        }

        override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
            super.onReceivedSslError(view, handler, error)
            //Do nothing just continue
            handler!!.proceed()
        }

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            // If the user refreshes he has to see loading Progress!
            super.onPageStarted(view, url, favicon)
            swipeRefreshLayout.isRefreshing = true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item!!.itemId == android.R.id.home) {
            onBackPressed()
            return true
        } else {
            return super.onOptionsItemSelected(item)
        }
    }
}
