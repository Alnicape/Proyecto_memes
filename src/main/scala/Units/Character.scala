package cl.uchile.dcc
package Units

import Items.{Item, Weapon}
import Sourse_target.{CharacterTarget, Source, Target}

import scala.collection.mutable.ListBuffer
import scala.compiletime.uninitialized

abstract class Character(val Name:String, private var _HP:Int, var Defense:Int, val Weight:Int) extends Units with CharacterTarget{
  def HP:Int = _HP
  def HP_(value:Int):Unit = _HP = value
  var Inventory: ListBuffer[Item] = ListBuffer.empty[Item]
  var WeaponSlot: Option[Weapon] = None 
  private var ActionBar: Int = 0

  def ResetBar(): Unit =
    ActionBar = 0

  def AddBar(actionQuantity: Int): Unit =
    ActionBar += actionQuantity

  def GetActionBar(): Int = ActionBar

  var isAlive: Boolean = HP > 0

  def doAction(target: Target, action: Action): Unit = {
    if (!target.isAlive) then throw DeadException("La unidad objetivo murió antes")
    if (!this.isAlive) then throw DeadException("La unidad origen murió antes")
    action.Act(this, target)
  }


}
