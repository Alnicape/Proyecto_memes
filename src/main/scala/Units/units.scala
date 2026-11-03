package cl.uchile.dcc
package Units

import Source_target.{source, target}


trait units extends source with target:
  def Name:String
  def HP: Int
  def Defense: Int
  def Weight: Int
  def ResetBar(): Unit
  def AddBar(actionQuantity:Int):Unit
  def GetActionBar(): Int