package com.example.grocerry

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import android.widget.ProgressBar
import com.example.grocerry.Activity.HomeActivity
import com.example.grocerry.Activity.MainActivity2

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var progressBar = findViewById<ProgressBar>(R.id.pBar) as ProgressBar
        progressBar.visibility = View.VISIBLE

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler(Looper.getMainLooper()).postDelayed({
            val sharedPreference =  getSharedPreferences("MySharedPref", Context.MODE_PRIVATE)
            if(!sharedPreference.getString("email", null).equals(null))
            {
                val intent = Intent(this, HomeActivity::class.java)
                progressBar.visibility = View.INVISIBLE
            startActivity(intent)

            }
            else
            {
                val intent = Intent(this, MainActivity2::class.java)
                progressBar.visibility = View.INVISIBLE
                startActivity(intent)


            }
            finish()

        }, 5)



    }
}