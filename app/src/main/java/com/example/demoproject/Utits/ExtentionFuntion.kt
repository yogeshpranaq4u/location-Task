package com.example.demoproject.Utits

import android.util.Log
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText
import java.util.regex.Pattern
import javax.security.auth.callback.Callback

fun TextInputEditText.onTextChanged(callback: (text: String) -> Unit) {
    addTextChangedListener {
        Log.d("", "onTextChanged A13 : $it")
        callback.invoke(it.toString())
    }
}

fun String.validateMail(): Boolean {
    val pattern = Pattern.compile(EMAIL_PATTERN)
    val matcher = pattern.matcher(this)
    return matcher.matches()
}

fun String.validatePassword(): Boolean {
    val pattern = Pattern.compile(PASSWORD_PATTERN)
    val matcher = pattern.matcher(this)
    return matcher.matches()
}