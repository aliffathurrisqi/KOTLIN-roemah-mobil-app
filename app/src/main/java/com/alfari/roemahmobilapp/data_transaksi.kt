package com.alfari.roemahmobilapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
//import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_data_transaksi.*


class data_transaksi : AppCompatActivity() {

//    lateinit var rvBeli : RecyclerView
//    lateinit var dbBeli : DatabaseReference
//    lateinit var dbTukar : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_transaksi)

        btnBeli.setOnClickListener {
            val data_beli = Intent(this@data_transaksi, read_databeli::class.java)
            startActivity(data_beli)
        }

        btnTukar.setOnClickListener {
            val data_tukar = Intent(this@data_transaksi, read_datatukar::class.java)
            startActivity(data_tukar)
        }

        btnBack.setOnClickListener {
            val menu = Intent(this@data_transaksi, select_invoice::class.java)
            startActivity(menu)
        }

//        rvBeli = findViewById(R.id.rvBeli)
//        dbBeli =  FirebaseDatabase.getInstance().getReference("transaksi").child("Data Pembelian")
//
//        logDataBeli()



    }

//    private fun logDataBeli(){
//        var FirebaseRecyclerAdapter = object : FirebaseRecyclerAdapter<BeliAdapter, BeliViewHolder>(BeliAdapter::class.java,
//            R.layout.item_beli, BeliViewHolder::class.java, dbBeli){
//
//            override fun populateViewHolder(viewHoder : BeliViewHolder?, model : BeliAdapter?, position : Int ){
//
//            }
//
//        }
//    }
//
//    class BeliViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//    }

}
