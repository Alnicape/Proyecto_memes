package cl.uchile.dcc
package Actions

import Source_target.{source, target}

abstract class ItemAction(Name:String) extends action(Name):
  var Allowed : List[String] = List.empty

class equipWeapon(val Name:String ="EquipWeapon") extends ItemAction(Name):
  def Act(source:source, target:target):Unit =
    source.setWeapon(target)
class consumePotion(val Name:String="ConsumePotion") extends ItemAction(Name):
  def Act(source:source, target:target):Unit =
    source.consumePotion(target)