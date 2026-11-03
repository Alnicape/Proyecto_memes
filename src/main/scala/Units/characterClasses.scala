package cl.uchile.dcc
package Units


import Actions.*
import Exceptions.{invalidInputException, invalidSpellException, invalidWeaponToSpellException, weaponUnequippedException}
import Items.{MagicWeapon, NormalWeapon}
import Source_target.target

//Normal ones
class Knight (override val Name:String, _HP: Int, _Defense: Int, override val Weight:Int) extends normalCharacter(Name, _HP, _Defense, Weight) {

  var AvailableWeapons: List[String] = List("Sword", "Dagger", "Bow")

}
class Archer (override val Name:String, _HP: Int, _Defense: Int,override val Weight:Int) extends normalCharacter(Name, _HP, _Defense, Weight) {

  var AvailableWeapons: List[String] = List("Sword", "Wand", "Bow")

}
class Thief (override val Name:String, _HP: Int, _Defense: Int,override val Weight:Int) extends normalCharacter(Name, _HP, _Defense, Weight) {

  var AvailableWeapons: List[String] = List("Sword", "Dagger")

}
class BlackWizard (override val Name:String, _HP: Int, _Defense: Int, override val Weight:Int, _ManaPoints:Int) extends magicCharacter(Name, _HP, _Defense, Weight, _ManaPoints) {

  override def AvailableActions: List[action] =
    new Meteorite() :: new Thunder() :: super.AvailableActions

  var AvailableWeapons: List[String] = List("Dagger", "Wand", "Staff")
  override def doHeal(target: target): Unit =
    throw invalidSpellException("This unit cannot cast doHeal")

  override def doPurification(target: target): Unit =
    throw invalidSpellException("This unit cannot cast doPurification")

  override def doThunder(target: target): Unit = {
    this.WeaponSlot match {
      case Some(ownWeapon:MagicWeapon) =>
        target.receiveThunder(this)
      case Some(ownWeapon:NormalWeapon) =>
        throw invalidWeaponToSpellException("Cannot use this weapon to cast doThunder")
      case None =>
        throw weaponUnequippedException("Cannot cast doThunder without a weapon")
      case _ => throw invalidInputException("Cannot cast doThunder")
    }
  }

  override def doMeteorite(target: target): Unit = {
    this.WeaponSlot match {
      case Some(ownWeapon: MagicWeapon) =>
        target.receiveMeteorite(this)
      case Some(ownWeapon: NormalWeapon) =>
        throw invalidWeaponToSpellException("Cannot use this weapon to cast doMeteorite")
      case None =>
        throw weaponUnequippedException("Cannot cast doMeteorite without a weapon")
      case _ => throw invalidInputException("Cannot cast doMeteorite")
    }
  }
}
class WhiteWizard(override val Name: String, _HP: Int, _Defense: Int, override val Weight: Int, _ManaPoints: Int) extends magicCharacter(Name, _HP, _Defense, Weight, _ManaPoints) {
  override def AvailableActions: List[action] =
    new Heal() :: new Purification() :: super.AvailableActions

  var AvailableWeapons: List[String] = List("Bow", "Wand", "Staff")
  override def doHeal(target: target): Unit =
    target.receiveHeal(this)

  override def doPurification(target: target): Unit =
    target.receivePurification(this)

  override def doThunder(target: target): Unit =
    throw invalidSpellException("this unit cannot cast doThunder")

  override def doMeteorite(target: target): Unit =
    throw invalidSpellException("this unit cannot cast doMeteorite")

}
