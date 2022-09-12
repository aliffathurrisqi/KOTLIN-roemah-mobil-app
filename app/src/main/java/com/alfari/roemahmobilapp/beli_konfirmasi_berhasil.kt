package com.alfari.roemahmobilapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class beli_konfirmasi_berhasil : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beli_konfirmasi_berhasil)

        var btnKembali = findViewById(R.id.btnKembali) as Button
        var btnMenu = findViewById(R.id.btnMenu) as Button

        btnKembali.setOnClickListener {
            val kembali = Intent(this@beli_konfirmasi_berhasil, input_beli::class.java)
            startActivity(kembali)
        }

        btnMenu.setOnClickListener {
            val menu = Intent(this@beli_konfirmasi_berhasil, select_invoice::class.java)
            startActivity(menu)
        }
    }
}
