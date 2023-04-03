package com.example.android3dop1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var _num = MutableLiveData<Int>()
    var num: LiveData<Int> = _num
    var meaning = 0

    fun minus(){
        meaning--
        _num.value = meaning
    }

    fun plus(){
        meaning++
        _num.value = meaning
    }
}