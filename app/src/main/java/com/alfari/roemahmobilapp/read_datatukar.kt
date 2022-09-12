package com.alfari.roemahmobilapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class read_datatukar : AppCompatActivity() {

    private val api by lazy { ApiRetrofit().endpoint }
    private lateinit var tukarAdapter: TukarAdapter
    private lateinit var listDataTukar : RecyclerView
    private lateinit var btnKembali : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_datatukar)
        btnKembali = findViewById(R.id.btnKembali)

        btnKembali.setOnClickListener{
            val kembali = Intent(this@read_datatukar, data_transaksi::class.java)
            startActivity(kembali)
        }
        setupList()

    }

    override fun onStart() {
        super.onStart()
        getData()
    }

    private fun setupList(){
        listDataTukar = findViewById(R.id.rv_datatukar)
        tukarAdapter = TukarAdapter(arrayListOf())
        listDataTukar.adapter = tukarAdapter
    }

    private fun getData(){
        api.data_tukar().enqueue((object  : Callback<DataTukar>{
            override fun onFailure(p0: Call<DataTukar>, p1: Throwable) {
                Log.e("read_datatukar", p1.toString())
            }

            override fun onResponse(p0: Call<DataTukar>, response: Response<DataTukar>) {
                if(response.isSuccessful){

                    val listData = response.body()!!.result
                    tukarAdapter.setData(listData)
                }
            }

        }))
    }
}
