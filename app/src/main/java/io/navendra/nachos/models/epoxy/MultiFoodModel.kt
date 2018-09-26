package io.navendra.nachos.models.epoxy

import android.support.annotation.DrawableRes
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.airbnb.epoxy.*
import io.navendra.nachos.R
import io.navendra.nachos.models.Food
import io.navendra.nachos.viewmodels.SingleFoodController
import kotlinx.android.synthetic.main.multifood_layout.view.*

@EpoxyModelClass(layout = R.layout.multifood_layout)
abstract class MultiFoodModel : EpoxyModelWithHolder<MultiFoodModel.ViewHolder>(){

    @EpoxyAttribute
    var id : Long = 0

    @EpoxyAttribute
    @DrawableRes
    var image : Int = 0

    @EpoxyAttribute
    var title:String? = ""

    @EpoxyAttribute
    var desc:String = ""

    @EpoxyAttribute
    var foods:List<Food> = mutableListOf()

    override fun bind(holder: ViewHolder?) {
        holder?.imageView?.setImageResource(image)
        holder?.titleView?.text = title

        val singleFoodController = SingleFoodController()

        holder?.recyclerView?.apply {
            layoutManager = LinearLayoutManager(holder.recyclerView?.context,
                    LinearLayout.HORIZONTAL,false)

            adapter = singleFoodController.adapter
        }
        singleFoodController.requestModelBuild()
    }

    inner class ViewHolder : EpoxyHolder(){
         var imageView: ImageView? = null
         var titleView: TextView? = null
         var descView: TextView? = null
         var recyclerView : RecyclerView? = null

        override fun bindView(itemView: View?) {
            imageView = itemView?.image
            titleView = itemView?.title
            descView = itemView?.desc
            recyclerView = itemView?.rv
        }

    }
}