package kot.helena.chancebalancer.utils

import android.content.Context
import kot.helena.chancebalancer.EntityModel
import kot.helena.chancebalancer.R
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

object EntityRW {

    fun addSavedEntities(args: List<EntityModel>, context: Context) {
        val sumList = ArrayList<EntityModel>()
        sumList.addAll(loadEntities(context))
        sumList.addAll(args)
        saveEntities(sumList, context)
    }

    private fun saveEntities(args: List<EntityModel>, context: Context) {
        val fos: FileOutputStream = context.openFileOutput(context.getString(R.string.save_name), Context.MODE_PRIVATE)
        val oos = ObjectOutputStream(fos)
        oos.writeObject(args)
        oos.close()
        fos.close()
    }

    fun loadEntities(context: Context): List<EntityModel> {
        return try {
            val fis: FileInputStream = context.openFileInput(context.getString(R.string.save_name))
            val ois = ObjectInputStream(fis)
            val output: List<EntityModel> = ois.readObject() as List<EntityModel>
            ois.close()
            fis.close()
            output
        } catch (e: Throwable) {
            emptyList()
        }
    }

    fun wipeEntities(context: Context) {
        context.deleteFile(context.getString(R.string.save_name))
    }

}