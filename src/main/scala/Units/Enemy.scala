package cl.uchile.dcc
package Units

import Actions.Action
import Sourse_target.Target

import cl.uchile.dcc.Exceptions.{DeadException, WeaponUnequippedException}

class Enemy(val Name:String, protected var _HP: Int, val ATK: Int, protected var _Defense: Int, val Weight: Int) extends AbstractUnits{
  def HP:Int = _HP
  def HP_(value:Int):Unit = _HP = value

  def Defense: Int = _Defense
  def Defense_(value: Int): Unit = _Defense = value



  def doAction(target: Target, action: Action): Unit = {
    if (!target.isAlive) then throw DeadException("La unidad objetivo murió antes")
    if (!this.isAlive) then throw DeadException("La unidad origen murió antes")
    action.Act(this, target)
    this.ResetBar()
  }

  private var ActionBar: Int = 0
  def ResetBar():Unit = {
    ActionBar = 0
  }

  def AddBar(actionQuantity:Int):Unit = {
    ActionBar+=actionQuantity
  }

  def GetActionBar():Int = ActionBar

  def isAlive: Boolean = HP > 0

  override def doAttack(target: Target): Unit =
    target.receiveAttackFromEnemy(this)

  override def receiveAttackFromCharacter(source: Character): Unit = {
    source.WeaponSlot match {
      case Some(ownWeapon) =>
        _HP = _HP - ownWeapon.ATKPoints
      case None =>
        throw WeaponUnequippedException("Cannot receive an attack from this source")
    }
  }

  override def receiveAttackFromEnemy(source: Enemy): Unit = {
    _HP = _HP - source.ATK
  }
}