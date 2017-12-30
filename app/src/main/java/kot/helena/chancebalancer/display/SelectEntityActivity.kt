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
import kotlinx.android.synthetic.main.activity_display_entity.*

class SelectEntityActivity : AppCompatActivity(), SelectEntityPresenter.SelectEntityUI {
    private val recyclerView: RecyclerView by lazy { recycler_view }
    private val adapter = DisplayEntityAdapter()
    private val presenter = SelectEntityPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_entity)
        initRecyclerView()
        if (adapter.isEmpty()) {
            startDefineEntityActivity()
        }
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        refreshAdapterData()
    }

    private fun refreshAdapterData() {
        adapter.setData(EntityRW.loadEntities(this))
    }

    override fun onResume() {
        super.onResume()
        presenter.ui = this
        refreshAdapterData()
    }

    override fun onPause() {
        presenter.ui = null
        super.onPause()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.select_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return presenter.menuOptionSelected(item)
    }

    override fun startDefineEntityActivity() {
        startActivity(Intent(this, DefineEntityActivity::class.java))
    }

    override fun wipeData() {
        EntityRW.wipeEntities(this)
        refreshAdapterData()
    }

}