package com.example.myroomdatabase.view.route

import com.example.myroomdatabase.R
import com.example.myroomsatu.view.route.DestinasiNavigasi

object DestinasiDetailSiswa : DestinasiNavigasi {
    override val route = "detail_siswa"
    override val titleRes = R.string.detail_siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}