package cl.uchile.dcc
package Characters

import Items.{Item, Weapon}

import scala.collection.mutable.ListBuffer
import scala.compiletime.uninitialized

abstract class NormalCharacter(val Name:String, var HealthPoints : Int, var Defense:Int, val Weight:Int) extends CharacterInterface:
  var Inventory : ListBuffer[Item]  = ListBuffer.empty[Item]
  var WeaponSlot : Weapon = uninitialized //Me marcaba error si usaba = _


class Knight (Name:String, HealthPoints: Int, Defense: Int, Weight:Int) extends NormalCharacter(Name, HealthPoints, Defense, Weight)
class Archer (Name:String, HealthPoints: Int, Defense: Int, Weight:Int) extends NormalCharacter(Name, HealthPoints, Defense, Weight)
class Thief (Name:String, HealthPoints: Int, Defense: Int, Weight:Int) extends NormalCharacter(Name, HealthPoints, Defense, Weight)

