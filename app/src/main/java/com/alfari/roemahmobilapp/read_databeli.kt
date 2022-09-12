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

class read_databeli : AppCompatActivity() {

    private val api by lazy { ApiRetrofit().endpoint }
    private lateinit var beliAdapter: BeliAdapter
    private lateinit var listDataBeli : RecyclerView
    private lateinit var btnKembali : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_databeli)
        btnKembali = findViewById(R.id.btnKembali)

        btnKembali.setOnClickListener{
            val kembali = Intent(this@read_databeli, data_transaksi::class.java)
            startActivity(kembali)
        }
        setupList()

    }

    override fun onStart() {
        super.onStart()
        getData()
    }

    private fun setupList(){
        listDataBeli = findViewById(R.id.rv_databeli)
        beliAdapter = BeliAdapter(arrayListOf())
        listDataBeli.adapter = beliAdapter
    }

    private fun getData(){
        api.data_beli().enqueue((object  : Callback<DataBeli>{
            override fun onFailure(p0: Call<DataBeli>, p1: Throwable) {
                Log.e("read_databeli", p1.toString())
            }

            override fun onResponse(p0: Call<DataBeli>, response: Response<DataBeli>) {
                if(response.isSuccessful){

                    val listData = response.body()!!.result
                    beliAdapter.setData(listData)
                }
            }

        }))
    }
}
