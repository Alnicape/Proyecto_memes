package cl.uchile.dcc
package Source_target

import Actions.Action
import Units.{AbstractUnits, Archer, BlackWizard, Character, Enemy, Knight, MagicCharacter, Thief, Units, WhiteWizard}


trait Target:

  def Name: String
  def isAlive : Boolean
  def receiveAttackFromCharacter(source : Character) : Unit
  def receiveAttackFromEnemy(source: Enemy):Unit


  def receivePurification(source:WhiteWizard):Unit
  def receiveHeal(source:WhiteWizard):Unit

  def receiveMeteorite(source:Source):Unit
  def receiveThunder(source: BlackWizard): Unit
  def beSet(source: Character): Unit
  def setNewPosition(source:AbstractUnits): Unit