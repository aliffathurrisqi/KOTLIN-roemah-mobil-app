package com.alfari.roemahmobilapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class input_tukartambah : AppCompatActivity() {

    lateinit var btn_tambah: Button
    lateinit var btn_kembali: Button
    lateinit var namaPembeli: EditText
    lateinit var btn_cari: Button
    lateinit var kendaraan: TextView
    lateinit var tahun: TextView
    lateinit var nopol: EditText
    lateinit var warna: TextView
    lateinit var harga: TextView
    lateinit var merek_tukar: EditText
    lateinit var tahun_tukar: EditText
    lateinit var nopol_tukar: EditText
    lateinit var warna_tukar: EditText
    lateinit var jumlah: EditText

    private val api by lazy { ApiRetrofit().endpoint }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_tukartambah)

        btn_tambah = findViewById(R.id.btn_data_beli)
        btn_kembali = findViewById(R.id.btn_kembali)
        btn_cari = findViewById(R.id.btn_cari_tukar)
        namaPembeli = findViewById(R.id.beli_namaPembeli)
        kendaraan = findViewById(R.id.tukar_kendaraan_nama_beli)
        nopol = findViewById(R.id.tukar_kendaraaan_nopol_beli)
        tahun = findViewById(R.id.tukar_kendaraan_tahun_beli)
        warna = findViewById(R.id.tukar_kendaraan_warna_beli)
        harga = findViewById(R.id.tukar_kendaraan_harga_beli)
        merek_tukar = findViewById(R.id.tukar_kendaraan_merek)
        tahun_tukar = findViewById(R.id.tukar_kendaraan_tahun)
        nopol_tukar = findViewById(R.id.tukar_kendaraan_nopol)
        warna_tukar = findViewById(R.id.tukar_kendaraan_warna)
        jumlah = findViewById(R.id.beli_transaksi_jumlah)

        btn_tambah.setOnClickListener {
            simpanData()
        }

        btn_cari.setOnClickListener {
            CariKendaraan()
        }

        btn_kembali.setOnClickListener {
            backToMenu()
        }

    }

    private fun backToMenu() {
        val kembali = Intent(this@input_tukartambah, select_invoice::class.java)
        startActivity(kembali)
    }

    private fun simpanData() {
        val in_nopol = nopol.text.toString()
        val in_nama_customer = namaPembeli.text.toString()
        val in_jumlah = jumlah.text.toString()
        val in_nopol_tukar = nopol_tukar.text.toString()
        val in_nama_tukar = merek_tukar.text.toString()
        val in_tahun_tukar = tahun_tukar.text.toString()
        val in_warna_tukar = warna_tukar.text.toString()

        api.input_tukar(
            in_nopol,
            in_nopol_tukar,
            in_nama_tukar,
            in_tahun_tukar,
            in_warna_tukar,
            in_nama_customer,
            in_jumlah
        )
            .enqueue(object : Callback<InputTukar> {
                override fun onFailure(p0: Call<InputTukar>, p1: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(p0: Call<InputTukar>, p1: Response<InputTukar>) {
                    val konfirmasi =
                        Intent(this@input_tukartambah, tukar_konfirmasi_berhasil::class.java)
                    startActivity(konfirmasi)

                }

            })

    }

    private fun CariKendaraan() {
        val in_nopol = nopol.text.toString()

        api.cari_kendaraan(in_nopol).enqueue(object : Callback<DataKendaraan> {
            override fun onFailure(p0: Call<DataKendaraan>, p1: Throwable) {
            }

            override fun onResponse(p0: Call<DataKendaraan>, response: Response<DataKendaraan>) {
                if (response.isSuccessful) {
                    kendaraan.text = response.body()!!.result[0].nama_kendaraan
                    tahun.text = response.body()!!.result[0].tahun_pembuatan
                    warna.text = response.body()!!.result[0].warna
                    harga.text = response.body()!!.result[0].harga
//                        namaKendaraan.text = in_nopol
                }
            }

        })

    }
}