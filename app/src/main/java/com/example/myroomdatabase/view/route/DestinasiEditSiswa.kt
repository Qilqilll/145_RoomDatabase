package com.example.myroomdatabase.view.route

import com.example.myroomdatabase.R
import com.example.myroomsatu.view.route.DestinasiNavigasi

object DestinasiEditSiswa : DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = R.string.edit_siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}