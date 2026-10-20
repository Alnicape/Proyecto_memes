package cl.uchile.dcc
package Actions

import Sourse_target.{Source, Target}

abstract class WhiteWizardAction(val Name: String) extends Action
abstract class BlackWizardAction(val Name: String) extends Action

class Meteorite(Name:String) extends BlackWizardAction(Name)

class Thunder(Name:String) extends BlackWizardAction(Name)

class Heal(Name:String) extends WhiteWizardAction(Name)

class Purification(Name:String) extends WhiteWizardAction(Name)
