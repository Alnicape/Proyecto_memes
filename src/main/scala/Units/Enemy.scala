package cl.uchile.dcc
package Units

import Exceptions.{InvalidInputException, InvalidSpellException, InvalidWeaponToSpellException}
import Items.MagicWeapon
import Source_target.Target

class Enemy(val Name:String, _HP: Int, val ATK: Int, _Defense: Int, val Weight: Int) extends AbstractUnits(_HP,_Defense){
  
  override def doAttack(target: Target): Unit =
    target.receiveAttackFromEnemy(this)
  
  override def receiveHeal(source: WhiteWizard): Unit = 
    throw InvalidSpellException("This unit cannot be cured")

  override def receivePurification(source: WhiteWizard): Unit = {
    source.WeaponSlot match{
      case Some(ownWeapon:MagicWeapon) =>
        this._HP = math.round(this._HP*0.85).toInt - ownWeapon.MagicATKPoints
      case _ =>
        throw InvalidWeaponToSpellException("Cannot cast purification without a magic weapon")
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