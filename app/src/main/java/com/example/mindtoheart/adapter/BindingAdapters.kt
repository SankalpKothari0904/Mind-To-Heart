package com.example.mindtoheart.adapter

import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.databinding.BindingAdapter


class BindingAdapters {

    companion object {
        @BindingAdapter("Image")
        @JvmStatic
        fun setImageViewResource(imageView: ImageView, imageResourceId: Int) {
            imageView.setImageResource(imageResourceId)
        }

        @BindingAdapter("Text")
        @JvmStatic
        fun setQuestionText(textView: TextView, stringResourceId: Int) {
            textView.setText(stringResourceId)
        }

        @BindingAdapter("RadioButton")
        @JvmStatic
        fun setRadioButtonText(radioButton: RadioButton, stringResourceId: Int) {
            radioButton.setText(stringResourceId)
        }
    }
}
