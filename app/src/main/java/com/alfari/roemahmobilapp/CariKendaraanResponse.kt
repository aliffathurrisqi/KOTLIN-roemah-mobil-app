package com.alfari.roemahmobilapp

data class CariKendaraanResponse(

    val result:List<Data>) {

    data class Data(
        val nopol: String?
    )
}

