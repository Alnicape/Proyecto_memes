package cl.uchile.dcc
package Units

import Actions.Action
import Exceptions.{DeadException, InvalidInputException, InvalidSpellException, WeaponUnequippedException}
import Items.{MagicWeapon, NormalWeapon}
import Source_target.{Source, Target}

class Enemy(val Name:String, _HP: Int, val ATK: Int, _Defense: Int, val Weight: Int) extends AbstractUnits(_HP,_Defense){

  def doAction(target: Target, action: Action): Unit = {
    if !target.isAlive then throw DeadException("La unidad objetivo murió antes")
    if !this.isAlive then throw DeadException("La unidad origen murió antes")
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



  override def receiveHeal(source: WhiteWizard): Unit = 
    throw InvalidSpellException("This unit cannot be cured")

  override def receivePurification(source: WhiteWizard): Unit = {
    source.WeaponSlot match{
      case Some(ownWeapon:MagicWeapon) =>
        this._HP = math.round(this._HP*0.85).toInt - ownWeapon.MagicATKPoints
      case Some(ownWeapon:NormalWeapon) =>
        this._HP = math.round(this._HP*0.85).toInt
      case None =>
        this._HP = math.round(this._HP*0.85).toInt
    }
  }

  override def doHeal(target: Target): Unit =
    throw InvalidSpellException("This unit cannot cast doHeal")

  override def doPurification(target: Target): Unit =
    throw InvalidSpellException("This unit cannot cast doPurification")

  override def doThunder(target: Target): Unit =
    throw InvalidSpellException("this unit cannot cast doThunder")

  override def doMeteorite(target: Target): Unit =
    throw InvalidSpellException("this unit cannot cast doMeteorite")

  override def setWeapon(target: Target): Unit =
    throw InvalidInputException("A enemy cannot have a weapon")  
}