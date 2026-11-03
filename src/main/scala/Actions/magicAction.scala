package cl.uchile.dcc
package Actions

import Source_target.{source, target}

abstract class WhiteWizardAction(Name: String) extends action(Name)
abstract class BlackWizardAction(Name: String) extends action(Name)

class Meteorite(val Name:String="Meteorite") extends BlackWizardAction(Name):
  def Act(source:source, target:target):Unit =
    source.doMeteorite(target)

class Thunder(val Name:String="Thunder") extends BlackWizardAction(Name):
  def Act(source: source, target: target): Unit =
    source.doThunder(target)

class Heal(val Name:String="Heal") extends WhiteWizardAction(Name):
  def Act(source: source, target: target): Unit =
    source.doHeal(target)

class Purification(val Name:String="Purification") extends WhiteWizardAction(Name):
  def Act(source: source, target: target): Unit =
    source.doPurification(target)
