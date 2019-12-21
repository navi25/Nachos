package io.navendra.nachos.models.epoxy

import androidx.annotation.DrawableRes
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import io.navendra.nachos.R
import io.navendra.nachos.models.Food

/**
 * This class needs to be abstract as Epoxy inherits this class to form SingleFoodModel_() class.
 * Also this is one of the ways a Epoxy model can be written.
 * For more visit:
 * https://github.com/airbnb/epoxy/wiki/Epoxy-Models
 */
@EpoxyModelClass(layout = R.layout.singlefood_layout)
abstract class SingleFoodModel (@EpoxyAttribute var food: Food) : EpoxyModelWithHolder<SingleFoodModel.FoodHolder>(){

    override fun bind(holder: FoodHolder) {
        holder.imageView.setImageResource(food.image)
        holder.titleView.text = food.title
    }

    /**
     * This is ViewHolder class equivalent to Google's RecyclerView.ViewHolder class
     */
    inner class FoodHolder : KotlinHolder(){

        val imageView by bind<ImageView>(R.id.image)
        val titleView by bind<TextView>(R.id.title)
        val descView by bind<TextView>(R.id.desc)

    }

}


