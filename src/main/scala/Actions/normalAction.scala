package cl.uchile.dcc
package Actions

import Source_target.{source, target}


class Attack(val Name:String="Name") extends action(Name):
  def Act(source:source, target:target):Unit = source.doAttack(target)

class Move(val Name:String="Move") extends action(Name):
  def Act(source:source, target:target):Unit =
    source.beMovedTo(target)
