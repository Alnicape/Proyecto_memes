package cl.uchile.dcc
package Players

import Units.units

import scala.collection.mutable.ListBuffer

class player(val Name : String):
  private var UnitsList : List[units] = List.empty
  private var Defeated: Boolean = false
  
  def getUnitsList: List[units] = UnitsList
  def isDefeated: Boolean = Defeated