package com.alfari.roemahmobilapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class input_beli : AppCompatActivity() {

    lateinit var btn_tambah : Button
    lateinit var btn_kembali : Button
    lateinit var btn_cari : Button
    lateinit var namaPembeli : EditText
    lateinit var namaKendaraan : TextView
    lateinit var tahun : TextView
    lateinit var nopol: EditText
    lateinit var warna : TextView
    lateinit var harga : TextView
    lateinit var jumlah : EditText


    private lateinit var kendaraanAdapter: KendaraanAdapter

//    lateinit var catatan : EditText
//    lateinit var spinner : Spinner

    private val api by lazy { ApiRetrofit().endpoint }
//    private lateinit var kendaraanAdapter: KendaraanAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_beli)

        btn_tambah = findViewById(R.id.btn_data_beli)
        btn_kembali = findViewById(R.id.btn_kembali)
        btn_cari = findViewById(R.id.btn_cari)
        namaPembeli = findViewById(R.id.beli_namaPembeli)
//        pembayaran = findViewById(R.id.beli_pembayaran)
        namaKendaraan = findViewById(R.id.beli_kendaraan_nama)
        nopol = findViewById(R.id.beli_kendaraan_nopol)
        tahun = findViewById(R.id.beli_kendaraan_tahun)
        warna = findViewById(R.id.beli_kendaraan_warna)
        harga = findViewById(R.id.beli_kendaraan_harga)
        jumlah = findViewById(R.id.beli_transaksi_jumlah)
//        catatan = findViewById(R.id.beli_transaksi_catatan)
//        spinner = findViewById(R.id.spnKendaraan)

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

    private fun backToMenu(){
        val kembali = Intent(this@input_beli, select_invoice::class.java)
        startActivity(kembali)
    }

//    private fun getData(){
//        api.data_kendaraan().enqueue((object  : Callback<DataKendaraan> {
//            override fun onFailure(p0: Call<DataKendaraan>, p1: Throwable) {
//                Log.e("read_databeli", p1.toString())
//            }
//
//            override fun onResponse(p0: Call<DataKendaraan>, response: Response<DataKendaraan>) {
//                if(response.isSuccessful){
//
//                    val listData = response.body()!!.result
//                    kendaraanAdapter.setData(listData)
//                }
//            }
//
//        }))
//    }

    private fun simpanData(){
        val in_nopol = nopol.text.toString()
        val in_nama_customer = namaPembeli.text.toString()
        val in_jumlah = jumlah.text.toString()

        api.input_beli(
            in_nopol,
            in_nama_customer,
            in_jumlah)
            .enqueue(object : Callback<InputBeli>{
                override fun onFailure(p0: Call<InputBeli>, p1: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(p0: Call<InputBeli>, p1: Response<InputBeli>) {
                    val konfirmasi = Intent(this@input_beli, beli_konfirmasi_berhasil::class.java)
                    startActivity(konfirmasi)

                }

            })



//        //val in_nopol = Spinner
//
//        if(in_jumlah.isEmpty()){
//            jumlah.error = "Masukkan nominal transaksi !"
//            return
//        }
//
//        if(in_catatan.isEmpty()){
//            catatan.error = "Bila kosong isikan tanda -"
//            return
//        }
//
//
//
//        if (in_jumlah != null){
//
//                val konfirmasi = Intent(this@input_beli, beli_konfirmasi_berhasil::class.java)
//                startActivity(konfirmasi)
//
//        }

    }

    private fun CariKendaraan() {
        val in_nopol = nopol.text.toString()

        api.cari_kendaraan(in_nopol).enqueue(object : Callback<DataKendaraan>{
            override fun onFailure(p0: Call<DataKendaraan>, p1: Throwable) {
            }
            override fun onResponse(p0: Call<DataKendaraan>, response: Response<DataKendaraan>) {
                if(response.isSuccessful){
                        namaKendaraan.text = response.body()!!.result[0].nama_kendaraan
                        tahun.text = response.body()!!.result[0].tahun_pembuatan
                        warna.text = response.body()!!.result[0].warna
                        harga.text = response.body()!!.result[0].harga
//                        namaKendaraan.text = in_nopol
                  }
            }

        })




//        api.cari_kendaraan(
//            in_nopol
//        )
//            .enqueue(object : Callback<DataKendaraan> {
//                override fun onFailure(p0: Call<DataKendaraan>, p1: Throwable) {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                }
//
//                override fun onResponse(p0: Call<DataKendaraan>, p1: Response<DataKendaraan>) {
//                    if(response.isSuccessful){
//                        namaKendaraan.text = Response.body()!!.result.get(0).nama_kendaraan
//                        //namaKendaraan.text = "Masuk"
//                        tahun.text = Response.body()!!.result.get(0).tahun_pembuatan
//                        warna.text = Response.body()!!.result.get(0).warna
//                        harga.text = Response.body()!!.result.get(0).harga
//                    }
////
////                            }
////                        }
//
//
////                    api.data_kendaraan(in_nopol).enqueue((object  : Callback<DataKendaraan>{
////                        override fun onFailure(p0: Call<DataKendaraan>, p1: Throwable) {
////
////                        }
////
////                        override fun onResponse(p0: Call<DataKendaraan>, response: Response<DataKendaraan>) {
////                            if(response.isSuccessful){
////
////                            }
////                        }
////
////                    }))
//                }
//
//            })
    }

}
