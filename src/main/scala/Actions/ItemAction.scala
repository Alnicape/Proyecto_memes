package cl.uchile.dcc
package Actions

import Items.Item
import Source_target.{Source, Target}

abstract class ItemAction(Name:String) extends Action(Name):
  var Allowed : List[Item] = List[Item]()

class EquipWeapon(val Name:String ="EquipWeapon") extends ItemAction(Name):
  def Act(source:Source,target:Target):Unit =
    source.setWeapon(target)
class ConsumePotion(val Name:String="ConsumePotion") extends ItemAction(Name):
  def Act(source:Source,target:Target):Unit = ???