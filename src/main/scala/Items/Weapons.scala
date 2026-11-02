package cl.uchile.dcc
package Items

import Actions.Action
import Items.Item
import Units.{Archer, BlackWizard, Character, Enemy, Knight, Thief, WhiteWizard}

abstract class Weapon(val Name : String, val Weight : Int, val ATKPoints : Int, val Owner: Character) extends AbstractItem {
  override def beSet(source:Character):Unit =
    source.WeaponSlot = Some(this)
}

abstract class NormalWeapon(override val Name : String,override val Weight : Int,override val ATKPoints : Int,override val Owner: Character) extends Weapon(Name, Weight, ATKPoints, Owner)

class Dagger(Name:String, Weight:Int, ATKPoints:Int, Owner: Character) extends NormalWeapon(Name, Weight, ATKPoints, Owner)
  
class Sword(Name:String, Weight:Int, ATKPoints:Int, Owner: Character) extends NormalWeapon(Name, Weight, ATKPoints, Owner)

class Bow(Name:String, Weight:Int, ATKPoints:Int, Owner: Character) extends NormalWeapon(Name, Weight, ATKPoints, Owner)

