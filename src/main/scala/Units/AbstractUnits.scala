package cl.uchile.dcc
package Units

import Actions.{Action, Attack, Move}
import Exceptions.{DeadException, InvalidInputException, InvalidWeaponToSpellException, WeaponUnequippedException}
import Items.{MagicWeapon, NormalWeapon}
import Locations.Panel
import Source_target.{Source, Target}

abstract class AbstractUnits(protected var _HP:Int,protected var _Defense:Int) extends Units {
  def HP:Int = _HP
  def HP_(value:Int):Unit = _HP = value

  val MaxHP : Int = _HP

  def Defense: Int = _Defense
  def Defense_(value: Int): Unit = _Defense = value
  
  var currentLocation: Option[Panel] = None

  def AvailableActions: List[Action] = List(new Move("North"), new Attack())

  def doAction(target: Target, action: Action): Unit = {
    if !target.isAlive then throw new DeadException("Target unit died before")
    if !this.isAlive then throw new DeadException("Source unit died before")
    action.Act(this, target)
    this.ResetBar()
  }

  private var ActionBar: Int = 0

  def ResetBar(): Unit =
    ActionBar = 0

  def AddBar(actionQuantity: Int): Unit =
    ActionBar += actionQuantity

  def GetActionBar(): Int = ActionBar

  def isAlive: Boolean = HP > 0
  
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
      case _ => throw InvalidInputException("Cannot receive Thunder from this source")  
    }

  override def receiveMeteorite(source: Source): Unit =
    throw InvalidInputException("Units cannot receive Meteorite directly")

  override def beSet(source: Character): Unit =
    throw InvalidInputException("Cannot set a Unit like a Weapon")

  override def beMovedTo(target: Target): Unit =
    target.setNewPosition(this)

  override def setNewPosition(source: AbstractUnits): Unit = throw InvalidInputException("Cannot move into a Unit")  
}