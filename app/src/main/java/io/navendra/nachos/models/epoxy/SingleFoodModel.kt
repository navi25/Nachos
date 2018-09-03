package io.navendra.nachos.models.epoxy

import android.support.annotation.DrawableRes
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import io.navendra.nachos.R
import kotlinx.android.synthetic.main.singlefood_layout.view.*

/**
 * This class needs to be abstract as Epoxy inherits this class to form SingleFoodModel_() class.
 * Also this is one of the ways a Epoxy model can be written.
 * For more visit:
 * https://github.com/airbnb/epoxy/wiki/Epoxy-Models
 */
@EpoxyModelClass(layout = R.layout.singlefood_layout)
abstract class SingleFoodModel : EpoxyModelWithHolder<SingleFoodModel.FoodHolder>(){

    @EpoxyAttribute
    var id:Long = 0

    @EpoxyAttribute
    @DrawableRes
    var image : Int = 0

    @EpoxyAttribute
    var title:String? = ""

    @EpoxyAttribute
    var desc:String = ""


    override fun bind(holder: FoodHolder?) {
        holder!!.imageView.setImageResource(image)
        holder.descView.text = desc
        holder.titleView.text = title
    }


    /**
     * This is ViewHolder class equivalent to Google's RecyclerView.ViewHolder class
     */
    inner class FoodHolder : EpoxyHolder(){

        lateinit var imageView:ImageView
        lateinit var titleView: TextView
        lateinit var descView:TextView

        override fun bindView(itemView: View?) {
            imageView = itemView!!.image
            titleView = itemView.title
            descView = itemView.desc
        }

    }

}