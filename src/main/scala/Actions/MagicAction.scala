package cl.uchile.dcc
package Actions

import Sourse_target.{BlackMagicSource, CharacterTarget, EnemyTarget, PanelTarget, Source, Target, UnitsTarget, WhiteMagicSource}

abstract class WhiteWizardAction(Name: String) extends Action(Name)
abstract class BlackWizardAction(Name: String) extends Action(Name)

class Meteorite(val Name:String="Meteorite") extends BlackWizardAction(Name):
  def Act(source:BlackMagicSource,target:PanelTarget):Unit =
    target.receiveMeteorite(source)

class Thunder(val Name:String="Thunder") extends BlackWizardAction(Name):
  def Act(source: BlackMagicSource, target: UnitsTarget): Unit =
      target.receiveThunder(source)

class Heal(val Name:String="Heal") extends WhiteWizardAction(Name):
  def Act(source: WhiteMagicSource, target: CharacterTarget): Unit =
      target.receiveHeal(source)

class Purification(val Name:String="Purification") extends WhiteWizardAction(Name):
  def Act(source: WhiteMagicSource, target: EnemyTarget): Unit =
    target.receivePurification(source)
