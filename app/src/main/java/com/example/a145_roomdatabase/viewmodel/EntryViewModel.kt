package com.example.a145_roomdatabase.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.a145_roomdatabase.repositori.RepositoriSiswa
import com.example.a145_roomdatabase.room.Siswa

class EntryViewModel(private val repositoriSiswa: RepositoriSiswa) : ViewModel() {

    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set


    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa): Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }
}


data class UIStateSiswa(
    val detailSiswa: DetailSiswa = DetailSiswa(),
    val isEntryValid: Boolean = false
)


data class DetailSiswa(
    val id: Int = 0,
    val nama: String = "",
    val alamat: String = "",
    val telpon: String = ""
)

