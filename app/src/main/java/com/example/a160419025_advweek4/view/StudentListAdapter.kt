package com.example.a160419025_advweek4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160419025_advweek4.R
import com.example.a160419025_advweek4.model.Student
import kotlinx.android.synthetic.main.student_list_item.view.*
import java.util.*

class StudentListAdapter(val studentList: ArrayList<Student>): RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>() {
    class StudentViewHolder(val view: View): RecyclerView.ViewHolder(view)

    fun updateStudentList(newStudent: List<Student>) {
        studentList.clear()
        studentList.addAll(newStudent)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater =  LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.student_list_item, parent, false)

        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.view.txtItemID.text = studentList[position].id;
        holder.view.txtItemName.text = studentList[position].name;

        holder.view.btnItemDetails.setOnClickListener {
            val action = StudentListFragmentDirections.actionStudentDetail()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int = studentList.size
}