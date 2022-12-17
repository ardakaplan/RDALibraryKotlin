package com.ardakaplan.rdalibrary.helpers.extensions

import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText

/**
 * Created by Arda Kaplan at 12.04.2022 - 20:24
 *
 * ardakaplan101@gmail.com
 */
fun EditText.showOnlyNumericKeyboard() {

    inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_VARIATION_PASSWORD

    transformationMethod = NumericKeyBoardTransformationMethod()
}

fun EditText.getPureText(): String {

    return text.toString().trim()
}

fun EditText.setAfterTextChange(doAfter: (text: Editable?) -> Unit) {

    addTextChangedListener(object : TextWatcher {

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(s: Editable?) {

            doAfter(s)
        }
    })
}

fun EditText.setImeActionDone(action: () -> Unit) {

    setOnEditorActionListener { _, actionId, _ ->

        if (actionId == EditorInfo.IME_ACTION_DONE || actionId == KeyEvent.KEYCODE_ENTER) {

            action()
        }
        false
    }
}


class NumericKeyBoardTransformationMethod : PasswordTransformationMethod() {
    override fun getTransformation(source: CharSequence, view: View?): CharSequence {
        return source
    }
}