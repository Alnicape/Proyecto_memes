package cl.uchile.dcc
package Players

import cl.uchile.dcc.Units.Units

import scala.collection.mutable.ListBuffer
import scala.compiletime.uninitialized

class Player(val Name : String):
  var UnitsList = ListBuffer[Units]()
  var Defeated: Boolean = false