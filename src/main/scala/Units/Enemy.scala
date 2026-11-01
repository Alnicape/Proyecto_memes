package cl.uchile.dcc
package Units

import Actions.Action
import Sourse_target.Target

import cl.uchile.dcc.Exceptions.DeadException

class Enemy(val Name:String, var HP: Int, val ATK: Int, var Defense: Int, val Weight: Int) extends AbstractUnits{
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
}