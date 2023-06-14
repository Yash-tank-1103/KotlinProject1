package com.example.grocerry.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.grocerry.Api.Api
import com.example.grocerry.Api.RetrofitClient
import com.example.grocerry.Model.LoginModel
import com.example.grocerry.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var loginemail = findViewById(R.id.loginemail) as EditText
        var loginpass = findViewById(R.id.loginpass) as EditText
        var login = findViewById(R.id.login) as Button
        login.setOnClickListener {

            val email = loginemail.text
            val password = loginpass.text
            if (email.isNullOrBlank()) {
                Toast.makeText(this@LoginActivity, "Email Required", Toast.LENGTH_LONG).show()

            } else if (password.isNullOrBlank()) {
                Toast.makeText(this@LoginActivity, "password Required", Toast.LENGTH_LONG).show()

            } else {
                logincheck(email.toString(), password.toString())





//                intent = Intent(applicationContext, HomeActivity::class.java)
//                startActivity(intent)


            }
        }


    }


    fun logincheck(email: String,password: String)
    {
        val retrofit=RetrofitClient.buildService(Api::class.java)

        retrofit.login(email,password).enqueue(
            object:Callback<LoginModel> {
                override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                    if (response.isSuccessful) {

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
                            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                            startActivity(intent)
                        }
                        else
                        {
                            Toast.makeText(applicationContext, response.body()?.response?.message,Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            }
        )


    }


}

