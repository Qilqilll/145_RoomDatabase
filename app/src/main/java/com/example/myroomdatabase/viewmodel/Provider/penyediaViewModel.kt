package com.example.myroomdatabase.viewmodel.Provider

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myroomdatabase.repositori.AplikasiSiswa // *Perhatian: Baca Catatan di bawah
import com.example.myroomdatabase.viewmodel.DetailViewModel
import com.example.myroomdatabase.viewmodel.EditViewModel
import com.example.myroomdatabase.viewmodel.EntryViewModel
import com.example.myroomdatabase.viewmodel.HomeViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {

        initializer {
            HomeViewModel(aplikasiSiswa().containerApp.repositoriSiswa)
        }

        initializer {
            EntryViewModel(aplikasiSiswa().containerApp.repositoriSiswa)
        }

        initializer {
            DetailViewModel(
                createSavedStateHandle(),
                aplikasiSiswa().containerApp.repositoriSiswa
            )
        }

        // Bagian ini yang baru ditambahkan untuk Edit
        initializer {
            EditViewModel(
                createSavedStateHandle(),
                aplikasiSiswa().containerApp.repositoriSiswa
            )
        }
    }
}

/**
 * Fungsi ekstensi query untuk objek [Application] dan mengembalikan sebuah instance dari
 * [AplikasiSiswa].
 */
fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)