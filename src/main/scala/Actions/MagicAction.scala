package cl.uchile.dcc
package Actions

import Sourse_target.{Source, Target}

abstract class WhiteWizardAction(val Name: String) extends Action
abstract class BlackWizardAction(val Name: String) extends Action

class Meteorite(Name:String) extends BlackWizardAction(Name):
  def Act(source: Source, target:Target): Unit = ???
class Thunder(Name:String) extends BlackWizardAction(Name):
  def Act(source:Source, target:Target): Unit = ???
class Heal(Name:String) extends WhiteWizardAction(Name):
  def Act(source:Source, target:Target):Unit = ???
class Purification(Name:String) extends WhiteWizardAction(Name):
  def Act(source: Source, target: Target): Unit = ???