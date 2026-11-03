package cl.uchile.dcc
package Actions

import Source_target.{source, target}


class attack(val Name:String="Attack") extends action(Name):
  def Act(source:source, target:target):Unit = source.doAttack(target)

class move(val Name:String="Move") extends action(Name):
  def Act(source:source, target:target):Unit =
    source.beMovedTo(target)
