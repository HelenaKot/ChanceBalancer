package kot.helena.chancebalancer

import java.io.Serializable

class EntityModel : Serializable {
    var name: String = ""
    var attackChance: Int = 0
    var attackDamage: Int = 0
    var defenceChance: Int = 0
    var defenceTimes: Int = 0
    var health: Int = 0
    var armor: Int = 0
}