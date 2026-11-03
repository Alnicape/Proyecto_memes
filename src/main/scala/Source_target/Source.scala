package cl.uchile.dcc
package Source_target

import Actions.Action
import Locations.Panel


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
  def beMovedTo(target:Target) : Unit
  
  var currentLocation : Option[Panel]