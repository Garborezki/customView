package com.example.nikita.customview.other.customView

import android.content.Context
import android.text.Editable
import android.text.InputType.TYPE_CLASS_NUMBER
import android.text.TextWatcher
import android.util.AttributeSet
import android.widget.EditText

class CustomEditText(context: Context, attrs: AttributeSet) : EditText(context, attrs) {

    init {

        inputType = TYPE_CLASS_NUMBER
        addTextChangedListener(object : TextWatcher {

            var flag = true

            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (flag) {
                    flag = false
                    setText(phoneFormat())
                    setSelection(text.length)
                    flag = true
                }
            }

        })
        setText(phoneFormat())

    }

    private fun phoneFormat(): String {
        var phoneFormat = ""
        val simpleTextInFild = simpleFormat()
        for (i in 0..(simpleTextInFild.length - 1)) {
            when (i) {
                0 -> {
                    phoneFormat += "+${simpleTextInFild[i]}"
                }
                1 -> {
                    phoneFormat += " (${simpleTextInFild[i]}"
                }
                3 -> {
                    phoneFormat += "${simpleTextInFild[i]}"
                }
                2, 5, 6, 8, 10 -> {
                    phoneFormat += simpleTextInFild[i]
                }

                4 -> {
                    phoneFormat += ") ${simpleTextInFild[i]}"
                }

                7, 9 -> {
                    phoneFormat += " ${simpleTextInFild[i]}"
                }
            }
        }
        return phoneFormat
    }

    private fun simpleFormat(): String {
        var sampleText = ""
        for (i in 0..(text.length - 1)) {
            if (text[i] in '1'..'9') {
                sampleText += text[i]
            }
        }

        return sampleText
    }

}