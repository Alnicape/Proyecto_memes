package cl.uchile.dcc
package Units

import Items.{Item, Weapon}
import Sourse_target.{Source, Target}

import cl.uchile.dcc.Actions.{Action, Attack, ConsumePotion, EquipWeapon, Move}
import cl.uchile.dcc.Exceptions.DeadException
import cl.uchile.dcc.Map.Panel

import scala.collection.mutable.ListBuffer
import scala.compiletime.uninitialized

abstract class Character(val Name:String, private var _HP:Int, private var _Defense:Int, val Weight:Int) extends AbstractUnits{
  def HP:Int = _HP
  def HP_(value:Int):Unit = _HP = value

  def Defense: Int = _Defense
  def Defense_(value: Int): Unit = _Defense = value


  var Inventory: ListBuffer[Item] = ListBuffer.empty[Item]
  var WeaponSlot: Option[Weapon] = None
  private var ActionBar: Int = 0

  def ResetBar(): Unit =
    ActionBar = 0

  def AddBar(actionQuantity: Int): Unit =
    ActionBar += actionQuantity

  def GetActionBar(): Int = ActionBar

  def isAlive: Boolean = HP > 0

  def doAction(target: Target, action: Action): Unit = {
    if (!target.isAlive) then throw new DeadException("La unidad objetivo murió antes")
    if (!this.isAlive) then throw new DeadException("La unidad origen murió antes")
    action.Act(this, target)
    this.ResetBar()
  }
  def currentPosition : Option[Panel] = None

  override def AvailableActions: List[Action] = 
    new EquipWeapon() :: new ConsumePotion()::super.AvailableActions

}
