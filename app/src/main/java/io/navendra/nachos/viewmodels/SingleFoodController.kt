package io.navendra.nachos.viewmodels

import com.airbnb.epoxy.EpoxyController
import io.navendra.nachos.models.Food
import io.navendra.nachos.models.FoodDataFactory
import io.navendra.nachos.models.epoxy.SingleFoodModel_

class SingleFoodController : EpoxyController(){

    var foodItems : List<Food>

    init {
        foodItems = FoodDataFactory.getFoodItems(10)
    }

    override fun buildModels() {
        var i:Long =0

        foodItems.forEach {food ->
            SingleFoodModel_()
                    .id(i++)
                    .image(food.image)
                    .title(food.title)
                    .desc(food.description)
                    .addTo(this)
        }
    }

}