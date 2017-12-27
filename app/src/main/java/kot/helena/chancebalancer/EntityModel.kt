package kot.helena.chancebalancer

import android.os.Parcel
import android.os.Parcelable

class EntityModel() : Parcelable{
    var name: String = ""
    var attackChance: Int = 0
    var attackDamage: Int = 0
    var defenceChance: Int = 0
    var defenceTimes: Int = 0
    var health: Int = 0
    var armor: Int = 0

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        attackChance = parcel.readInt()
        attackDamage = parcel.readInt()
        defenceChance = parcel.readInt()
        defenceTimes = parcel.readInt()
        health = parcel.readInt()
        armor = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(attackChance)
        parcel.writeInt(attackDamage)
        parcel.writeInt(defenceChance)
        parcel.writeInt(defenceTimes)
        parcel.writeInt(health)
        parcel.writeInt(armor)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EntityModel> {
        override fun createFromParcel(parcel: Parcel): EntityModel {
            return EntityModel(parcel)
        }

        override fun newArray(size: Int): Array<EntityModel?> {
            return arrayOfNulls(size)
        }
    }
}