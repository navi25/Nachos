package io.navendra.nachos.models

data class MultiFood (
        val image:Int=-1,
        val title:String="",
        val description:String="",
        val foods : List<Food> = mutableListOf<Food>()
)