package com.example.grocerry.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import com.example.grocerry.R


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val buttonClick1 = findViewById<Button>(R.id.sign)
        buttonClick1.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)}
            val buttonClick2 = findViewById<Button>(R.id.log)
            buttonClick2.setOnClickListener {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)}


    }
}