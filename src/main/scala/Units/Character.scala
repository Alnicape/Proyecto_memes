package cl.uchile.dcc
package Units

import Actions.{Action, ConsumePotion, EquipWeapon}
import Exceptions.{DeadException, InvalidSpellException, InvalidWeaponException}
import Items.{Item, Weapon}
import Source_target.Target

import scala.collection.mutable.ListBuffer

abstract class Character(val Name:String, _HP:Int, _Defense:Int, val Weight:Int) extends AbstractUnits(_HP,_Defense){

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
    if !target.isAlive then throw new DeadException("La unidad objetivo murió antes")
    if !this.isAlive then throw new DeadException("La unidad origen murió antes")
    action.Act(this, target)
    this.ResetBar()
  }
  
  var AvailableWeapons: List[String]

  override def AvailableActions: List[Action] =
    new EquipWeapon() :: new ConsumePotion()::super.AvailableActions
  

  override def receiveHeal(source: WhiteWizard): Unit = {
    source.WeaponSlot match {
      case Some(ownWeapon) =>
        this._HP = math.min(this._HP + math.round(this.MaxHP * 0.2).toInt + math.round(ownWeapon.ATKPoints / 4.0).toInt, this.MaxHP)
      case None =>
        this._HP = math.min(this._HP + math.round(this.MaxHP * 0.2).toInt, this.MaxHP)
    }
  }

  override def receivePurification(source: WhiteWizard): Unit =
    throw InvalidSpellException("Cannot receive Purification")
    
  override def setWeapon(target:Target):Unit = {
    for (weapon <- AvailableWeapons) if weapon == target.Name then target.beSet(this)
    else throw InvalidWeaponException("Cannot use this weapon in this character")
 
  }
}
