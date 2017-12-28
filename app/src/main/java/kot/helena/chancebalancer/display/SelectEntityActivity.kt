package kot.helena.chancebalancer.display

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kot.helena.chancebalancer.EntityModel
import kot.helena.chancebalancer.R
import kot.helena.chancebalancer.define.DefineEntityActivity
import kot.helena.chancebalancer.utils.EntityRW
import kotlinx.android.synthetic.main.activity_main.*

class SelectEntityActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy { recycler_view }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        startDefineEntityActivity()
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = DisplayEntityAdapter()
        recyclerView.adapter = adapter

        val data = ArrayList<EntityModel>()
        data.add(EntityModel())
        data.add(EntityModel())

        adapter.setData(EntityRW.loadEntities(this))
    }

    private fun startDefineEntityActivity() {
        startActivity(Intent(this, DefineEntityActivity::class.java))
    }

}