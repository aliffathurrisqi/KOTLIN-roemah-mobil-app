package com.alfari.roemahmobilapp

data class DataBeli(

    val result:List<Data>) {

    data class Data(
        val nama_customer: String?,
        val jenis_transaksi: String?,
        val nopol: String?,
        val nama_kendaraan: String?,
        val jumlah_pembayaran: String?,
        val waktu: String?
    )
}

