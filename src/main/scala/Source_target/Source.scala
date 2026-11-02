package cl.uchile.dcc
package Source_target

import Actions.Action

import cl.uchile.dcc.Items.Weapon


trait Source:
  def doAction(target:Target,action:Action):Unit
  
  def AvailableActions:List[Action]
  
  protected def isAlive: Boolean
  def doAttack(target:Target):Unit

  def doThunder(target: Target): Unit
  def doMeteorite(target: Target): Unit

  def doHeal(target: Target): Unit
  def doPurification(target: Target): Unit
  def setWeapon(target:Target) : Unit