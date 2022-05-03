package com.example.contactlist

data class User(val name:String, val lastMsg:String, val lastMsgTime:String,
                val phoneNumber:String, val country:String, var imgId:Int)
