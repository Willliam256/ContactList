package com.example.contactlist

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contactlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userArrayList:ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setting the data source using arrays
        val proImages = arrayOf<Int>(
            R.drawable.me, R.drawable.me2, R.drawable.me3
        )

        val names = arrayOf(
            "Bob Williams", "Don Ivan", "Thorax Voong"
        )

        val lastMsg = arrayOf(
            "Hello William", "Your Money Is ready Iav", "Voong Come Take Me Home"
        )
        val lastMsgTime = arrayOf(
            "7:00AM", "12:21PM", "4:09PM"
        )
        val phoneNumber = arrayOf(
            "849373994893", "74839400484", "37834483728"
        )
        val country = arrayOf(
            "Canada", "Uganda", "Kenya"
        )

        //capture individual respective data from the arrays using the for loop and pass it to the ArrayList
        userArrayList = ArrayList()

        for (i in names.indices){
            val user = User(names[i], lastMsg[i], lastMsgTime[i], phoneNumber[i], country[i], proImages[i])
            userArrayList.add(user)
        }

        binding.mainListview.adapter = MyAdapter(this, userArrayList)
        binding.mainListview.isClickable = true
        binding.mainListview.setOnItemClickListener{parent, view, position, id ->
//            val name = names[position]
            val country = country[position]
            val contact = phoneNumber[position]
            val image = proImages[position]

            val intent = Intent(this, UserDetailsActivity::class.java)
            intent.putExtra("name", names[position])
            intent.putExtra("country", country)
            intent.putExtra("contact", contact)
            intent.putExtra("image", image)

            startActivity(intent)

        }
    }
}