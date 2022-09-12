package com.alfari.roemahmobilapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BeliAdapter(
    val result: ArrayList<DataBeli.Data>
) : RecyclerView.Adapter<BeliAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_beli, parent, false)
    )

    override fun getItemCount() = result.size

    override fun onBindViewHolder(holder: BeliAdapter.ViewHolder, position: Int) {
        val result_item = result[position]
        holder.txtPembeli.text = result_item.nama_customer
        holder.txtKendaraan.text = result_item.nama_kendaraan
        holder.txtNopol.text = result_item.nopol
        holder.txtJumlah.text = "Rp " + result_item.jumlah_pembayaran
        holder.txtWaktu.text = result_item.waktu

    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val txtPembeli = view.findViewById<TextView>(R.id.txtPembeli)
        val txtKendaraan = view.findViewById<TextView>(R.id.txtKendaraan)
        val txtNopol = view.findViewById<TextView>(R.id.txtNopol)
        val txtJumlah = view.findViewById<TextView>(R.id.txtJumlah)
        val txtWaktu = view.findViewById<TextView>(R.id.txtWaktu)
    }

    public fun setData(data: List<DataBeli.Data>){
        result.clear()
        result.addAll(data)
        notifyDataSetChanged()
    }

}