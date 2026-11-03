package cl.uchile.dcc
package Actions

import Source_target.{Source, Target}


class Attack(val Name:String="Name") extends Action(Name):
  def Act(source:Source,target:Target):Unit = source.doAttack(target)

class Move(val Name:String="Move") extends Action(Name):
  def Act(source:Source,target:Target):Unit =
    source.beMovedTo(target)
