package cl.uchile.dcc
package Units

import Items.{Item, Weapon}
import Sourse_target.{Source, Target}

import cl.uchile.dcc.Actions.{Action, Attack, ConsumePotion, EquipWeapon, Move}
import cl.uchile.dcc.Exceptions.{DeadException, WeaponUnequippedException}
import cl.uchile.dcc.Map.Panel

import scala.collection.mutable.ListBuffer
import scala.compiletime.uninitialized

abstract class Character(val Name:String, protected var _HP:Int, protected var _Defense:Int, val Weight:Int) extends AbstractUnits{
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


  override def receiveAttackFromCharacter(source: Character): Unit = {
    source.WeaponSlot match {
      case Some(ownWeapon) =>
        _HP = _HP - ownWeapon.ATKPoints
      case None =>
        throw WeaponUnequippedException("Cannot receive an attack from this source")  
    }
  }
  
}
