package kot.helena.chancebalancer.define

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.widget.LinearLayout
import kot.helena.chancebalancer.EntityModel
import kot.helena.chancebalancer.R
import kot.helena.chancebalancer.utils.AppCompatExtension.hideActionBar
import kot.helena.chancebalancer.utils.AppCompatExtension.setStatusBarColor
import kot.helena.chancebalancer.utils.EntityRW
import kotlinx.android.synthetic.main.activity_define_entity.*

class DefineEntityActivity : AppCompatActivity() {
    private val container: LinearLayout by lazy { entity_container }
    private val button: FloatingActionButton by lazy { add_entity_button }
    private val finishButton: FloatingActionButton by lazy { finish_button }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_define_entity)
        this.hideActionBar()
        this.setStatusBarColor(R.color.colorAccentDark)
        addEntityView()
        button.setOnClickListener({ addEntityView() })
        finishButton.setOnClickListener({ this.finish() })
    }

    private fun addEntityView() {
        container.addView(DefineEntityView(this))
    }

    override fun finish() {
        EntityRW.addSavedEntities(collectEntities(), this)
        super.finish()
    }

    private fun collectEntities(): List<EntityModel> {
        val outputList: ArrayList<EntityModel> = ArrayList()
        (0 until container.childCount).map { (container.getChildAt(it) as DefineEntityView).model }
                .filterTo(outputList) { it.notEmpty() }
        return outputList
    }

}
