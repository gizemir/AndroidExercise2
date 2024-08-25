package com.gizemir.deneme_recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.gizemir.deneme_recyclerview.databinding.ActivityInformationBinding
import com.gizemir.deneme_recyclerview.databinding.ActivityMainBinding

class InformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInformationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//diğer sayfadaki item'ın bilgileri bu sayfada görünecek
        val maindenGelenIntent = intent
        val studentInfo = maindenGelenIntent.getSerializableExtra("studentInfo") as Student
        binding.imageView.setImageResource(studentInfo.photo)
        binding.textViewId.text = studentInfo.id.toString()
        binding.textViewName.text = studentInfo.name
        binding.textViewSurname.text = studentInfo.surname
    }
}