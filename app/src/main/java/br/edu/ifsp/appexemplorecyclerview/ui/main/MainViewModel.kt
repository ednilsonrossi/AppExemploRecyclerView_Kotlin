package br.edu.ifsp.appexemplorecyclerview.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.edu.ifsp.appexemplorecyclerview.data.AlgoImportante

class MainViewModel : ViewModel() {
    private val arr: ArrayList<AlgoImportante> = ArrayList()

    private val _datasource = MutableLiveData<List<AlgoImportante>>()
    val datasource: LiveData<List<AlgoImportante>> = _datasource

    private val _inserted = MutableLiveData<Boolean>()
    val inserted: LiveData<Boolean> = _inserted

    private val _deleted = MutableLiveData<Boolean>()
    val deleted: LiveData<Boolean> = _deleted

    init {
        _datasource.value = arr
    }

    fun insertAlgo(algo: AlgoImportante) {
        arr.add(algo)
        _datasource.value = arr
        _inserted.value = true
    }

    fun deleteAlgo(position: Int) {
        arr.removeAt(position)
        _datasource.value = arr
        _deleted.value = true
    }
}