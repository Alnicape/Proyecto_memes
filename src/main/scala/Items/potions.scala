package cl.uchile.dcc
package Items

import Exceptions.{invalidInputException, invalidPotion}

import cl.uchile.dcc.Units.{character, magicCharacter}

abstract class potion(val Name:String) extends AbstractItem {
  override def beSet(source: Units.character): Unit = throw invalidInputException("Cannot set a potion like a weapon")
}

abstract class normalPotion(override val Name:String) extends potion(Name)
abstract class magicPotion(override val Name: String) extends potion(Name)

class HealingPotion(Name:String) extends normalPotion(Name) {
  override def beConsumed(source: character): Unit = {
    val newHealth : Int = math.min(math.round(source.HP + source.MaxHP*0.2).toInt, source.MaxHP)
    source.HP_(newHealth)
  }
}
class StrengthPotion(Name:String) extends normalPotion(Name) {
  override def beConsumed(source:character):Unit ={
    val newDefense : Int = math.round(source.Defense*1.15).toInt
    source.Defense_(newDefense)
  }
}
class ManaPotion(Name:String) extends magicPotion(Name) {
  override def beConsumed(source: character): Unit = {
    source match{
      case s:magicCharacter =>
        val newMana : Int = math.min(math.round(s.MaxMana*0.3 + s.ManaPoints).toInt,s.MaxMana)
        s.ManaPoints_(newMana)
      case _ =>
        throw invalidPotion("Cannot use a magicalPotion into a normal character")
    }
  }
}
class MagicStrengthPotion(Name:String) extends magicPotion(Name) {
  override def beConsumed(source: character): Unit = ??? //I still don´t know how to implement this
}
