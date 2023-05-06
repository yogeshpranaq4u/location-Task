package com.example.demoproject.Utits

import androidx.fragment.app.Fragment
import com.example.demoproject.R
import com.example.demoproject.ui.BusinessNewsFragment
import com.example.demoproject.ui.HomeFragment

const val PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$"
const val EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
const val USER_MAIL_KEY = "user_mail_key"
const val email = "admin@admin.com"
const val password = "Admin@_123"
const val API_KEY = "apikey=18c45117fde34e1baad8f5f3eb56c5f9"
var SELECTED_POSITION = 0
val fragmentList: ArrayList<Fragment> = arrayListOf(HomeFragment(), BusinessNewsFragment())
val fragmentTitleList: ArrayList<String> = arrayListOf("All", "Business")