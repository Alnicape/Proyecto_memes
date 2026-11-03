package cl.uchile.dcc
package Players

import Units.units

import scala.collection.mutable.ListBuffer

class Player(val Name : String):
  private var UnitsList = ListBuffer[units]()
  private var Defeated: Boolean = false