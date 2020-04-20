package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFollow.setOnClickListener(View.OnClickListener {
            val webpage = Uri.parse("http://mobile.twitter.com/iykeafrica")
            val webIntent = Intent(Intent.ACTION_VIEW, webpage)
            val packageManager = packageManager
            val activities = packageManager.queryIntentActivities(webIntent, 0)
            val isIntentSafe = activities.size > 0
            if (isIntentSafe) {
                startActivity(Intent.createChooser(webIntent, "Share using"))
            }
        })

        ivTwitter.setOnClickListener(View.OnClickListener {
            val webpage = Uri.parse("http://mobile.twitter.com/iykeafrica")
            val webIntent = Intent(Intent.ACTION_VIEW, webpage)
            val packageManager = packageManager
            val activities = packageManager.queryIntentActivities(webIntent, 0)
            val isIntentSafe = activities.size > 0
            if (isIntentSafe) {
                startActivity(Intent.createChooser(webIntent, "Share using"))
            }
        })

        ivLinkedin.setOnClickListener(View.OnClickListener {
            val webpage = Uri.parse("https://www.linkedin.com/in/ikechi-ucheagwu-110a8566")
            val webIntent = Intent(Intent.ACTION_VIEW, webpage)
            val packageManager = packageManager
            val activities = packageManager.queryIntentActivities(webIntent, 0)
            val isIntentSafe = activities.size > 0
            if (isIntentSafe) {
                startActivity(Intent.createChooser(webIntent, "Share using"))
            }
        })

        ivPininterest.setOnClickListener(View.OnClickListener {
            val webpage = Uri.parse("https://www.pinterest.com/ikechiucheagwu/")
            val webIntent = Intent(Intent.ACTION_VIEW, webpage)
            val packageManager = packageManager
            val activities = packageManager.queryIntentActivities(webIntent, 0)
            val isIntentSafe = activities.size > 0
            if (isIntentSafe) {
                startActivity(Intent.createChooser(webIntent, "Share using"))
            }
        })

        ivFacebook.setOnClickListener(View.OnClickListener {
            val webpage = Uri.parse("https://www.facebook.com/Iykeafrica")
            val webIntent = Intent(Intent.ACTION_VIEW, webpage)
            val packageManager = packageManager
            val activities = packageManager.queryIntentActivities(webIntent, 0)
            val isIntentSafe = activities.size > 0
            if (isIntentSafe) {
                startActivity(Intent.createChooser(webIntent, "Share using"))
            }
        })
        ivGmail.setOnClickListener(View.OnClickListener {
            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.type = "text/plain"
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("ikechiucheagwu@gmail.com"))
            val packageManager = packageManager
            val activities = packageManager.queryIntentActivities(emailIntent, 0)
            val isIntentSafe = activities.size > 0
            if (isIntentSafe) {
                startActivity(Intent.createChooser(emailIntent, "Share using"))
            }
        })
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "The activity is in onStart state")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "The activity is in onResume state")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "The activity is in onStop state")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "The activity is in onPause state")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "The activity is in onRestart state")
    }

}
