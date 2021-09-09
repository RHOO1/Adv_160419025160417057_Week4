package com.example.a160419025_advweek4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a160419025_advweek4.model.Student

class DetailViewModel: ViewModel() {
    val studentLD = MutableLiveData<Student>()

    fun fetch() {
        val student1 = Student("16055", "Nonie", "1998/09/28", "5718444778", "http://dummyimage.com/75x100.jpg/cc0000/ffffff")

        studentLD.value = student1
    }
}