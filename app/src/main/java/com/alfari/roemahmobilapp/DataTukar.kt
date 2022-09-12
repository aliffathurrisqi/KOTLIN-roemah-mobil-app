package com.alfari.roemahmobilapp

data class DataTukar(
    val result:List<Data>) {

    data class Data(
        val nama_customer: String?,
        val jenis_transaksi: String?,
        val nopol: String?,
        val nama_kendaraan: String?,
        val nopol_tukar: String?,
        val nama_kendaraan_tukar: String?,
        val jumlah_pembayaran: String?,
        val waktu: String?
    )

}