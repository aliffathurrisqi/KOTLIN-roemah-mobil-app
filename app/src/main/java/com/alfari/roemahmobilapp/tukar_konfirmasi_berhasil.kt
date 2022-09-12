package com.alfari.roemahmobilapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class tukar_konfirmasi_berhasil : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tukar_konfirmasi_berhasil)

        var btnKembali = findViewById(R.id.btnKembali) as Button
        var btnMenu = findViewById(R.id.btnMenu) as Button

        btnKembali.setOnClickListener {
            val kembali = Intent(this@tukar_konfirmasi_berhasil, input_tukartambah::class.java)
            startActivity(kembali)
        }

        btnMenu.setOnClickListener {
            val menu = Intent(this@tukar_konfirmasi_berhasil, select_invoice::class.java)
            startActivity(menu)
        }
    }
}
