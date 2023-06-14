package com.example.grocerry.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.grocerry.Api.Api
import com.example.grocerry.Api.RetrofitClient
import com.example.grocerry.Model.LoginModel
import com.example.grocerry.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        var loginemail = findViewById(R.id.signupemail) as EditText
        var loginpass = findViewById(R.id.signuppass) as EditText
        var login = findViewById(R.id.signup) as Button
        login.setOnClickListener {

            val email = loginemail.text
            val password = loginpass.text
            if (email.isNullOrBlank()) {
                Toast.makeText(this@SignupActivity, "Email Required", Toast.LENGTH_LONG).show()

            } else if (password.isNullOrBlank()) {
                Toast.makeText(this@SignupActivity, "password Required", Toast.LENGTH_LONG).show()

            } else {
                signup(email.toString(),password.toString())

            }
        }



    }

    fun signup(email: String,password: String)
    {
        val retrofit= RetrofitClient.buildService(Api::class.java)

        retrofit.register(email,password).enqueue(
            object: Callback<LoginModel> {
                override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                    if (response.isSuccessful) {
                        Log.d("9852525", "onResponse: "+ response.body()?.response?.message)
                        if(response.body()?.response?.status.toString()=="201") {
                            Toast.makeText(
                                applicationContext,
                                response.body()?.response?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                            val sharedPreferences =
                                getSharedPreferences("MySharedPref", MODE_PRIVATE)
                            val myEdit = sharedPreferences.edit()
                            myEdit.putString("email", email.toString())
                            myEdit.putString("password", password.toString())
                            myEdit.apply()
                            val intent = Intent(this@SignupActivity, HomeActivity::class.java)
                            startActivity(intent)
                        }
                        else
                        {
                            Toast.makeText(applicationContext, response.body()?.response?.message,Toast.LENGTH_SHORT).show()
                        }

                    }

                }

                override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                    Toast.makeText(applicationContext, "try again ith new username",Toast.LENGTH_SHORT).show()

                }
            }
        )


    }
}