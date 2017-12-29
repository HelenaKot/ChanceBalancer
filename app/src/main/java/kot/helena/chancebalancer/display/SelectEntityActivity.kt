package kot.helena.chancebalancer.display

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import kot.helena.chancebalancer.R
import kot.helena.chancebalancer.define.DefineEntityActivity
import kot.helena.chancebalancer.utils.EntityRW
import kotlinx.android.synthetic.main.activity_main.*

class SelectEntityActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy { recycler_view }
    private val adapter = DisplayEntityAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        if (adapter.isEmpty()) {
            startDefineEntityActivity()
        }
    }

    override fun onResume() {
        super.onResume()
        refreshAdapterData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.select_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_new -> startDefineEntityActivity()
            R.id.action_delete -> startDeleteMode()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        refreshAdapterData()
    }

    private fun refreshAdapterData() {
        adapter.setData(EntityRW.loadEntities(this))
    }

    private fun startDefineEntityActivity() {
        startActivity(Intent(this, DefineEntityActivity::class.java))
    }

    private fun startDeleteMode() {

    }

}