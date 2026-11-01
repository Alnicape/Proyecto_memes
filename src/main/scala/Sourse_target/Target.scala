package cl.uchile.dcc
package Sourse_target

import Actions.Action
import Units.{Archer, BlackWizard, Enemy, Knight, MagicCharacter, Thief, Units, WhiteWizard,Character}


trait Target:

  def isAlive : Boolean
  def receiveAttackFromCharacter(source : Character) : Unit
  def receiveAttackFromEnemy(source: Enemy):Unit


  def receivePurification(source:Source):Unit
  def receiveHeal(source:WhiteWizard):Unit

  def receiveMeteorite(source:Source):Unit
  def receiveThunder(source: Source): Unit
