package cl.uchile.dcc
package Units

import Actions.{Action, Attack, EquipWeapon, Move}

import cl.uchile.dcc.Exceptions.{InvalidInputException, InvalidSpellException, InvalidWeaponToSpellException, WeaponUnequippedException}
import cl.uchile.dcc.Items.{MagicWeapon, NormalWeapon}
import cl.uchile.dcc.Locations.Panel
import cl.uchile.dcc.Source_target.{Source, Target}

abstract class AbstractUnits(protected var _HP:Int,protected var _Defense:Int) extends Units {
  def HP:Int = _HP
  def HP_(value:Int):Unit = _HP = value

  val MaxHP : Int = _HP

  def Defense: Int = _Defense
  def Defense_(value: Int): Unit = _Defense = value
  
  var currentLocation: Option[Panel] = None

  def AvailableActions: List[Action] = List(new Move("North"), new Attack())

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

  override def receiveThunder(source: BlackWizard): Unit =
    source.WeaponSlot match {
      case Some(ownWeapon:MagicWeapon) =>
        _HP = _HP - ownWeapon.MagicATKPoints
      case Some(ownWeapon:NormalWeapon) =>
        throw InvalidWeaponToSpellException("Cannot receive Thunder from this weapon")
      case None =>
        throw WeaponUnequippedException("Cannot receive Thunder from an unequipped source")
    }

  override def receiveMeteorite(source: Source): Unit =
    throw InvalidInputException("Units cannot receive Meteorite directly")

  override def beSet(source: Character): Unit =
    throw InvalidInputException("Cannot set a Unit like a Weapon")

  override def beMovedTo(target: Target): Unit =
    target.setNewPosition(this)

  override def setNewPosition(source: AbstractUnits): Unit = throw InvalidInputException("Cannot move into a Unit")  
}