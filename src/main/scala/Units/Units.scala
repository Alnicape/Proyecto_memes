package cl.uchile.dcc
package Units

import Source_target.{Source, Target}


trait Units extends Source with Target:
  def Name:String
  def HP: Int
  def Defense: Int
  def Weight: Int
  def ResetBar(): Unit
  def AddBar(actionQuantity:Int):Unit
  def GetActionBar(): Int