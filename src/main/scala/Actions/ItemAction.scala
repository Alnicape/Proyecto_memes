package cl.uchile.dcc
package Actions

import Items.{Potion, Weapon}
import Items.Item

import cl.uchile.dcc.Sourse_target.{Source, Target}

import scala.collection.mutable.ListBuffer

abstract class ItemAction(val Name:String) extends Action[Source,Target]:
  def Allowed : ListBuffer[Item] = ListBuffer[Item]()

class EquipWeapon(Name:String, val weapon: Weapon) extends ItemAction(Name):
  def Act(source:Source,target:Target):Unit = ???

class ConsumePotion(Name:String, val potion: Potion) extends ItemAction(Name):
  def Act(source:Source,target:Target):Unit = ???