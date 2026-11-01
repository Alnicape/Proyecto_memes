package cl.uchile.dcc
package Units


import Actions.{Action, Heal, Meteorite, Purification, Thunder}
import Sourse_target.{Source, Target}

import cl.uchile.dcc.Exceptions.{InvalidSpellException, WeaponUnequippedException}
import cl.uchile.dcc.Items.Weapon

//Normal ones
class Knight (override val Name:String, _HP: Int, _Defense: Int, override val Weight:Int) extends Character(Name, _HP, _Defense, Weight) {
  override def doAttack(target: Target): Unit = {
    this.WeaponSlot match{
      case Some(ownWeapon) =>
        target.receiveAttackFromCharacter(this)
      case None =>
        throw WeaponUnequippedException("Knight doesn't have a weapon equipped")
    }
  }

  override def doHeal(target: Target): Unit =
    throw InvalidSpellException("This unit cannot cast doHeal")

  override def doPurification(target: Target): Unit =
    throw InvalidSpellException("This unit cannot cast doPurification")

  override def doThunder(target: Target): Unit =
    throw InvalidSpellException("this unit cannot cast doThunder")  
}


class Archer (override val Name:String, _HP: Int, _Defense: Int,override val Weight:Int) extends Character(Name, _HP, _Defense, Weight) {
  override def doAttack(target: Target): Unit = {
    this.WeaponSlot match {
      case Some(ownWeapon) =>
        target.receiveAttackFromCharacter(this)
      case None =>
        throw WeaponUnequippedException("Archer doesn't have a weapon equipped")
    }
  }

  override def doHeal(target: Target): Unit =
    throw InvalidSpellException("This unit cannot cast doHeal")
  
  override def doPurification(target: Target): Unit =
    throw InvalidSpellException("This unit cannot cast doPurification")

  override def doThunder(target: Target): Unit =
    throw InvalidSpellException("this unit cannot cast doThunder")  
}

class Thief (override val Name:String, _HP: Int, _Defense: Int,override val Weight:Int) extends Character(Name, _HP, _Defense, Weight) {
  override def doAttack(target: Target): Unit = {
    this.WeaponSlot match {
      case Some(ownWeapon) =>
        target.receiveAttackFromCharacter(this)
      case None =>
        throw WeaponUnequippedException("Thief doesn't have a weapon equipped")
    }
  }

  override def doHeal(target: Target): Unit =
    throw InvalidSpellException("This unit cannot cast doHeal")

  override def doPurification(target: Target): Unit =
    throw InvalidSpellException("This unit cannot cast doPurification")

  override def doThunder(target: Target): Unit =
    throw InvalidSpellException("this unit cannot cast doThunder")
}


class BlackWizard (override val Name:String, _HP: Int, _Defense: Int, override val Weight:Int, _ManaPoints:Int) extends MagicCharacter(Name, _HP, _Defense, Weight, _ManaPoints) {
  override def AvailableActions: List[Action] =
    new Meteorite()::new Thunder()::super.AvailableActions

  override def doAttack(target: Target): Unit = {
    this.WeaponSlot match {
      case Some(ownWeapon) =>
        target.receiveAttackFromCharacter(this)
      case None =>
        throw WeaponUnequippedException("BlackWizard doesn't have a weapon equipped")
    }
  }

  override def doHeal(target: Target): Unit =
    throw InvalidSpellException("This unit cannot cast doHeal")

  override def doPurification(target: Target): Unit =
    throw InvalidSpellException("This unit cannot cast doPurification")

  override def doThunder(target: Target): Unit = {
    this.WeaponSlot match{
      case Some(ownWeapon) =>
        target.receiveThunder(this)
      case None =>
        throw WeaponUnequippedException("Cannot cast doThunder without a weapon")
    }
  }  
}

class WhiteWizard (override val Name:String, _HP: Int, _Defense: Int, override val Weight:Int, _ManaPoints:Int) extends MagicCharacter(Name, _HP, _Defense, Weight, _ManaPoints) {
  override def AvailableActions: List[Action] =
    new Heal() :: new Purification() :: super.AvailableActions

  override def doAttack(target: Target): Unit = {
    this.WeaponSlot match {
      case Some(ownWeapon) =>
        target.receiveAttackFromCharacter(this)
      case None =>
        throw WeaponUnequippedException("WhiteWizard doesn't have a weapon equipped")
    }  
  }

  override def doHeal(target: Target): Unit =
    target.receiveHeal(this)

  override def doPurification(target: Target): Unit =
    target.receivePurification(this)

  override def doThunder(target: Target): Unit =
    throw InvalidSpellException("this unit cannot cast doThunder")
}
