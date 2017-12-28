package kot.helena.chancebalancer.display

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kot.helena.chancebalancer.EntityModel
import kot.helena.chancebalancer.R
import kotlinx.android.synthetic.main.activity_main.*

class SelectEntityActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy { recycler_view }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = DisplayEntityAdapter()
        recyclerView.adapter = adapter

        val data = ArrayList<EntityModel>()
        data.add(EntityModel())
        data.add(EntityModel())

        adapter.setData(data)
    }

}