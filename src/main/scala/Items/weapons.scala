package cl.uchile.dcc
package Items

import Units.character

import cl.uchile.dcc.Exceptions.invalidInputException

abstract class Weapon(val Name : String, val Weight : Int, val ATKPoints : Int, val Owner: character) extends AbstractItem {
  override def beSet(source:character):Unit =
    source.WeaponSlot = Some(this)

  override def beConsumed(source: character): Unit = throw invalidInputException("A weapon cannot be consumed")
}

abstract class NormalWeapon(override val Name : String,override val Weight : Int,override val ATKPoints : Int,override val Owner: character) extends Weapon(Name, Weight, ATKPoints, Owner)

class Dagger(Weight:Int, ATKPoints:Int, Owner: character,Name:String = "Dagger") extends NormalWeapon(Name, Weight, ATKPoints, Owner)
  
class Sword(Weight:Int, ATKPoints:Int, Owner: character,Name:String = "Sword") extends NormalWeapon(Name, Weight, ATKPoints, Owner)

class Bow(Weight:Int, ATKPoints:Int, Owner: character,Name:String = "Bow") extends NormalWeapon(Name, Weight, ATKPoints, Owner)

