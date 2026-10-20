package cl.uchile.dcc
package Actions

import Items.{Potion, Weapon}
import Items.Item

import cl.uchile.dcc.Sourse_target.{ Source, Target}

import scala.collection.mutable.ListBuffer

abstract class ItemAction(Name:String) extends Action(Name):
  def Allowed : ListBuffer[Item] = ListBuffer[Item]()

class EquipWeapon(val Name:String ="EquipWeapon", val weapon: Weapon) extends ItemAction(Name):
  def Act(source:Source,target:Target):Unit = ???
  
class ConsumePotion(val Name:String="ConsumePotion", val potion: Potion) extends ItemAction(Name):
  def Act(source:Source,target:Target):Unit = ???