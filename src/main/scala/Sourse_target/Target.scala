package cl.uchile.dcc
package Sourse_target

import Actions.Action
import Units.{Archer, BlackWizard, Enemy, Knight, MagicCharacter, Thief, Units, WhiteWizard}


trait Target

trait UnitsTarget extends Target :
  def isAlive : Boolean
  def receiveAttack(source: Units) : Unit
  def receiveThunder(source:BlackMagicSource) : Unit
  
trait EnemyTarget extends UnitsTarget:
  def receivePurification(source:WhiteMagicSource):Unit

trait CharacterTarget extends UnitsTarget:
  def receiveHeal(source:WhiteMagicSource):Unit

trait PanelTarget extends Target:
  def receiveMeteorite(source:BlackMagicSource):Unit
  
