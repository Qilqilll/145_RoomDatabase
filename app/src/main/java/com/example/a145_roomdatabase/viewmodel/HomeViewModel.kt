package com.example.a145_roomdatabase.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a145_roomdatabase.repositori.RepositoriSiswa
import com.example.a145_roomdatabase.room.Siswa
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
