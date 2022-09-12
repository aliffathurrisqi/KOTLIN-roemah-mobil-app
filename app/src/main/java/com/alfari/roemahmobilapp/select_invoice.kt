package com.alfari.roemahmobilapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_select_invoice.*

class select_invoice : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_invoice)

        var btn_beli = findViewById(R.id.btnBeli) as Button
        var btn_tukartambah = findViewById(R.id.btntukartambah) as Button
        var btn_help = findViewById(R.id.btnHelp) as Button

        btn_beli.setOnClickListener {
            val pembelian = Intent(this@select_invoice, input_beli::class.java)
            startActivity(pembelian)
        }

        btn_tukartambah.setOnClickListener {
            val tukartambah = Intent(this@select_invoice, input_tukartambah::class.java)
            startActivity(tukartambah)
        }

        btn_data.setOnClickListener {
            val data = Intent(this@select_invoice, data_transaksi::class.java)
            startActivity(data)
        }

        btn_help.setOnClickListener {
            val help = Intent(Intent.ACTION_VIEW, Uri.parse("http://wa.me/6282322442293"))
            startActivity(help)
        }
    }
}
