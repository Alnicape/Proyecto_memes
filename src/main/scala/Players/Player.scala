package cl.uchile.dcc
package Players

import Characters.CharacterInterface

import scala.collection.mutable.ListBuffer
import scala.compiletime.uninitialized

class Player(val Name : String):
  var Units = ListBuffer[CharacterInterface]()
  var Defeated: Boolean = false