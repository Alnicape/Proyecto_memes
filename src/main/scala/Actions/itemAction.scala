package cl.uchile.dcc
package Actions

import Items.Item
import Source_target.{source, target}

abstract class ItemAction(Name:String) extends action(Name):
  var Allowed : List[Item] = List.empty

class EquipWeapon(val Name:String ="EquipWeapon") extends ItemAction(Name):
  def Act(source:source, target:target):Unit =
    source.setWeapon(target)
class ConsumePotion(val Name:String="ConsumePotion") extends ItemAction(Name):
  def Act(source:source, target:target):Unit =
    source.consumePotion(target)