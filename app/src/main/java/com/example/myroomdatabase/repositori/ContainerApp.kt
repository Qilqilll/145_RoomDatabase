package com.example.myroomdatabase.repositori

import android.app.Application
import android.content.Context
import com.example.myroomdatabase.repositori.OfflineRepositoriSiswa
import com.example.myroomdatabase.repositori.RepositoriSiswa
import com.example.myroomdatabase.room.DatabaseSiswa

interface ContainerApp {
    val repositoriSiswa : RepositoriSiswa
}

class ContainerDataApp(private val context: Context):
    ContainerApp {
    override val repositoriSiswa: RepositoriSiswa by lazy {
        OfflineRepositoriSiswa(DatabaseSiswa.getDatabase(context).siswaDao())
    }
}

class AplikasiSiswa : Application() {
    lateinit var containerApp: ContainerApp
    override fun onCreate() {
        super.onCreate()
        containerApp = ContainerDataApp(this)
    }
}
