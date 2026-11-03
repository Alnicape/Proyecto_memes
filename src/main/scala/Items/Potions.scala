package cl.uchile.dcc
package Items

import Exceptions.InvalidInputException

abstract class Potion(val Name:String) extends AbstractItem {
  override def beSet(source: Units.Character): Unit = throw InvalidInputException("Cannot set a potion like a weapon")
}

class HealingPotion(Name:String) extends Potion(Name)
class StrengthPotion(Name:String) extends Potion(Name)
class ManaPotion(Name:String) extends Potion(Name)
class MagicStrengthPotion(Name:String) extends Potion(Name)
