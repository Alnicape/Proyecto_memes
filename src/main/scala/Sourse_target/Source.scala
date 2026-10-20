package cl.uchile.dcc
package Sourse_target

import Actions.Action


trait Source: 
  def doAction(target:Target,action:Action):Unit
  def isAlive: Boolean
  def doAttack(target:Target):Unit

trait BlackMagicSource extends Source:
  def doThunder(target: Target): Unit
  def doMeteorite(target: Target): Unit

trait WhiteMagicSource extends Source:
  def doHeal(target: Target): Unit
  def doPurification(target: Target): Unit