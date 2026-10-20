package cl.uchile.dcc
package Units

import Sourse_target.{Source, Target, UnitsTarget}


trait Units extends Source with UnitsTarget:
  def Name: String
  def HP: Int
  def Defense: Int
  def Weight: Int
  def ResetBar(): Unit
  def AddBar(actionQuantity:Int):Unit
  def GetActionBar(): Int