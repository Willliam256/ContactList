package com.example.contactlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.contactlist.databinding.ActivityUserDetailsBinding

class UserDetailsActivity : AppCompatActivity() {
    private lateinit var binding:ActivityUserDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //capturing the added data from the data source
        val name = intent.getStringExtra("name")
        val country = intent.getStringExtra("country")
        val contact = intent.getStringExtra("contact")
        val image = intent.getIntExtra("image", R.drawable.me)

        //connecting the data source data to the interface
        findViewById<ImageView>(R.id.details_image).setImageResource(image)
        findViewById<TextView>(R.id.user_name).text = name
        binding.country.text = country
        binding.contact.text = contact

    }
}