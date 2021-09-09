package com.example.a160419025_advweek4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a160419025_advweek4.R
import com.example.a160419025_advweek4.model.Student
import com.example.a160419025_advweek4.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_student_detail.*
import java.util.*

class StudentDetailFragment() : Fragment() {
    private lateinit var viewModel: DetailViewModel

    var student: Student? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch()
        
        student = viewModel.studentLD.value

        txtDetailID.setText(student?.id)
        txtDetailName.setText(student?.name)
        txtDetailBoD.setText(student?.bod)
        txtDetailPhone.setText(student?.phone)
        
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer { 
            student = it
        })
    }
}