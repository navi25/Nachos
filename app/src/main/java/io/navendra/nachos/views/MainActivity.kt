package io.navendra.nachos.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.navendra.nachos.R
import io.navendra.nachos.viewmodels.SingleFoodController

class MainActivity : AppCompatActivity() {

    private val recyclerView : RecyclerView by lazy { findViewById<RecyclerView>(R.id.recycler_view) }
    private val singleFoodController : SingleFoodController by lazy { SingleFoodController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()
    }

    private fun initRecycler(){
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.apply {
            layoutManager = linearLayoutManager
            setHasFixedSize(true)
            adapter = singleFoodController.adapter
            addItemDecoration(DividerItemDecoration(this@MainActivity, linearLayoutManager.orientation))
        }

        //This statement builds model and add it to the recycler view
        singleFoodController.requestModelBuild()
    }
}
