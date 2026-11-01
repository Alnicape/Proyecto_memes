package cl.uchile.dcc
package Actions

import Sourse_target.{Source, Target}

import cl.uchile.dcc.Units.WhiteWizard

abstract class WhiteWizardAction(Name: String) extends Action(Name)
abstract class BlackWizardAction(Name: String) extends Action(Name)

class Meteorite(val Name:String="Meteorite") extends BlackWizardAction(Name):
  def Act(source:Source,target:Target):Unit =
    source.doMeteorite(target)

class Thunder(val Name:String="Thunder") extends BlackWizardAction(Name):
  def Act(source: Source, target: Target): Unit =
    source.doThunder(target)

class Heal(val Name:String="Heal") extends WhiteWizardAction(Name):
  def Act(source: Source, target: Target): Unit =
    source.doHeal(target)

class Purification(val Name:String="Purification") extends WhiteWizardAction(Name):
  def Act(source: Source, target: Target): Unit =
    source.doPurification(target)
