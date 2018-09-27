package io.navendra.nachos.viewmodels

import com.airbnb.epoxy.EpoxyController
import io.navendra.nachos.models.Food
import io.navendra.nachos.models.FoodDataFactory
import io.navendra.nachos.models.epoxy.SingleFoodModel_

class SingleFoodController : EpoxyController(){

    private val foodItems : List<Food> = FoodDataFactory.getFoodItems(50)

    private var index = 0L

    override fun buildModels() = foodItems.forEach{
        SingleFoodModel_(it)
                .id(index++)
                .addTo(this)
    }

}