package io.navendra.nachos.models

import android.support.annotation.StringRes

data class Food (
        val image:Int=-1,
        val title:String="",
        @StringRes val description:Int=-1
)