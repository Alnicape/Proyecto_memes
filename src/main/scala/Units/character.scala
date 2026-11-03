package cl.uchile.dcc
package Units

import Actions.{ConsumePotion, EquipWeapon, action}
import Exceptions.{invalidSpellException, invalidWeaponException, invalidWeaponToSpellException, weaponUnequippedException}
import Items.{Item, MagicWeapon, Weapon}
import Source_target.target

import scala.collection.mutable.ListBuffer

abstract class character(val Name:String, _HP:Int, _Defense:Int, val Weight:Int) extends abstractUnits(_HP,_Defense){

  var Inventory: ListBuffer[Item] = ListBuffer.empty[Item]
  var WeaponSlot: Option[Weapon] = None
  var AvailableWeapons: List[String]

  override def AvailableActions: List[action] =
    new EquipWeapon() :: new ConsumePotion()::super.AvailableActions

  override def doAttack(target: target): Unit = {
    this.WeaponSlot match {
      case Some(ownWeapon) =>
        target.receiveAttackFromCharacter(this)
      case None =>
        throw weaponUnequippedException("This character doesn't have a weapon equipped")
    }
  }

  override def receiveHeal(source: WhiteWizard): Unit = {
    source.WeaponSlot match {
      case Some(ownWeapon) =>
        ownWeapon match{
          case oW:MagicWeapon =>
            this._HP = math.min(this._HP + math.round(this.MaxHP * 0.2).toInt + math.round(ownWeapon.ATKPoints / 4.0).toInt, this.MaxHP)
          case _ =>
            throw invalidWeaponToSpellException("Cannot cast a spell without a magic weapon")
        }
      case None =>
        throw weaponUnequippedException("Cannot cast a spell without a weapon")
    }
  }

  override def receivePurification(source: WhiteWizard): Unit =
    throw invalidSpellException("Cannot receive Purification")
    
  override def setWeapon(target:target):Unit = {
    for (weapon <- AvailableWeapons) if weapon == target.Name then target.beSet(this)
    else throw invalidWeaponException("Cannot use this weapon in this character")
 
  }
}
