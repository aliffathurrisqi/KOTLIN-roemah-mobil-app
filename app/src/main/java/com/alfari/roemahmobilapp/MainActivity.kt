package com.alfari.roemahmobilapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private val api by lazy { ApiRetrofit().endpoint }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var log_username = findViewById(R.id.log_username) as EditText
        var log_password = findViewById(R.id.log_password) as EditText
        var btn_login = findViewById(R.id.btnlogin) as Button
        var btn_help = findViewById(R.id.btnHelp) as Button

        btn_login.setOnClickListener {
            val username = log_username.text.toString();
            val password = log_password.text.toString();
            if(username.equals("roemahmobil") && password.equals("admin")){
                val login = Intent(this@MainActivity, select_invoice::class.java)
                startActivity(login)
            }
        }

        btn_help.setOnClickListener {
            val help = Intent(Intent.ACTION_VIEW, Uri.parse("http://wa.me/6282322442293"))
            startActivity(help)


        }

    }
}
