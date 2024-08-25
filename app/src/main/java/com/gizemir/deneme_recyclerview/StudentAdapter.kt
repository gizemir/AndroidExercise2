package com.gizemir.deneme_recyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gizemir.deneme_recyclerview.databinding.RecyclerRowBinding

class StudentAdapter(val studentList: ArrayList<Student>): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    class StudentViewHolder(val binding: RecyclerRowBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        //ana sayfada liste görünecek(her birinin sadece isimleri)
        holder.binding.textViewRecyclerView.text = studentList[position].name
        //anasayfadaki her bir elemana, item'e tıklanıldığında listedeki her bir elemanın tüm bilgileri diğer sayfada gösterilecek
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, InformationActivity::class.java)
            intent.putExtra("studentInfo", studentList[position])
            holder.itemView.context.startActivity(intent)
        }

    }
}