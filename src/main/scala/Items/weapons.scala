package cl.uchile.dcc
package Items

import Units.character

abstract class Weapon(val Name : String, val Weight : Int, val ATKPoints : Int, val Owner: character) extends AbstractItem {
  override def beSet(source:character):Unit =
    source.WeaponSlot = Some(this)
}

abstract class NormalWeapon(override val Name : String,override val Weight : Int,override val ATKPoints : Int,override val Owner: character) extends Weapon(Name, Weight, ATKPoints, Owner)

class Dagger(Name:String, Weight:Int, ATKPoints:Int, Owner: character) extends NormalWeapon(Name, Weight, ATKPoints, Owner)
  
class Sword(Name:String, Weight:Int, ATKPoints:Int, Owner: character) extends NormalWeapon(Name, Weight, ATKPoints, Owner)

class Bow(Name:String, Weight:Int, ATKPoints:Int, Owner: character) extends NormalWeapon(Name, Weight, ATKPoints, Owner)

