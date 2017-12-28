package kot.helena.chancebalancer.define

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.LinearLayout
import kot.helena.chancebalancer.EntityModel
import kot.helena.chancebalancer.R
import kot.helena.chancebalancer.utils.EntityRW
import kotlinx.android.synthetic.main.activity_define_entity.*

class DefineEntityActivity : AppCompatActivity() {
    private val container: LinearLayout by lazy { entity_container }
    private val button: Button by lazy { add_entity_button }
    private val finishButton: Button by lazy { finish_button }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_define_entity)
        addEntityView()
        button.setOnClickListener({ addEntityView() })
        finishButton.setOnClickListener({ this.finish() })
    }

    private fun addEntityView() {
        container.addView(DefineEntityView(this))
    }

    override fun finish() {
        EntityRW.saveEntities(collectEntities(), this)
        super.finish()
    }

    private fun collectEntities(): List<EntityModel> {
        val outputList: ArrayList<EntityModel> = ArrayList()
        (0 until container.childCount).mapTo(outputList) { (container.getChildAt(it) as DefineEntityView).model }
        return outputList
    }

}