package io.navendra.nachos.viewmodels

import com.airbnb.epoxy.AutoModel
import com.airbnb.epoxy.EpoxyController
import io.navendra.nachos.models.Food
import io.navendra.nachos.models.FoodDataFactory
import io.navendra.nachos.models.MultiFood
import io.navendra.nachos.models.epoxy.MultiFoodModel_

class MultiFoodController : EpoxyController(){


    var multiFoodItems : List<MultiFood>

    init {
        multiFoodItems = FoodDataFactory.getMultiFoodItems(10)
    }

    override fun buildModels() {
        var i:Long =0

        multiFoodItems.forEach {food ->
            MultiFoodModel_()
                    .id(i++)
                    .image(food.image)
                    .title(food.title)
                    .desc(food.description)
                    .foods(food.foods)
                    .addTo(this)
        }
    }

}