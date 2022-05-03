package com.example.contactlist

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(private val context: Activity,  private val arrayList: ArrayList<User>): ArrayAdapter<User>(context,
    R.layout.row_item_main_listview, arrayList) {

    override fun getCount(): Int {
        return super.getCount()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater:LayoutInflater = LayoutInflater.from(context)
        val view:View = inflater.inflate(R.layout.row_item_main_listview, null)

        //referring to the elements in the row_item layout
        val contactName = view.findViewById<TextView>(R.id.contact_name)
        val lastMessage = view.findViewById<TextView>(R.id.last_message)
        val messageTime = view.findViewById<TextView>(R.id.last_msg_time)
        val profileImage = view.findViewById<ImageView>(R.id.profile_image)

        //Setting data from the data class to the elements referred
        contactName.text = arrayList[position].name
        lastMessage.text = arrayList[position].lastMsg
        messageTime.text = arrayList[position].lastMsgTime
        profileImage.setImageResource(arrayList[position].imgId)

        return view
    }
}