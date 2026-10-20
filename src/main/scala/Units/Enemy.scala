package cl.uchile.dcc
package Units

import Actions.Action
import Sourse_target.{EnemyTarget, Target, UnitsTarget}

import cl.uchile.dcc.Exceptions.DeadException

class Enemy(val Name:String, var HP: Int, val ATK: Int, var Defense: Int, val Weight: Int) extends Units with EnemyTarget{
  def doAction(target: UnitsTarget, action: Action): Unit = {
    if (!target.isAlive) then throw DeadException("La unidad objetivo murió antes")
    if (!this.isAlive) then throw DeadException("La unidad origen murió antes")
    action.Act(this, target)
  }

  private var ActionBar: Int = 0
  def ResetBar():Unit = {
    ActionBar = 0
  }
  def AddBar(actionQuantity:Int):Unit = {
    ActionBar+=actionQuantity
  }
  def GetActionBar():Int = ActionBar

  protected var isAlive: Boolean = HP > 0
}