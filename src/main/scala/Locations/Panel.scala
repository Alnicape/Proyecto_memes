package cl.uchile.dcc
package Locations

import Sourse_target.{Source, Target}

import cl.uchile.dcc.Exceptions.InvalidInputException
import cl.uchile.dcc.Units.{BlackWizard, Enemy, WhiteWizard}

import scala.collection.mutable.ListBuffer
class Panel(val x: Int, val y: Int) extends Target{
  var UnitsList : List[Character] = List.empty
  var North: Option[Panel] = None
  var South: Option[Panel] = None
  var East: Option[Panel] = None
  var West: Option[Panel] = None
    
  override def isAlive:Boolean =
    throw InvalidInputException("A panel neither can be Alive nor Dead")

  override def receiveAttackFromCharacter(source: Units.Character): Unit =
    throw InvalidInputException("A panel cannot be attacked")

  override def receiveAttackFromEnemy(source: Enemy): Unit =
    throw InvalidInputException("A panel cannot be attacked")

  override def receiveHeal(source: WhiteWizard): Unit =
    throw InvalidInputException("A panel cannot be healed")

  override def receivePurification(source: WhiteWizard): Unit =
    throw InvalidInputException("A panel cannot be Purified")

  override def receiveThunder(source: BlackWizard): Unit =
    throw InvalidInputException("A panel cannot receive Thunder")

  override def receiveMeteorite(source: Source): Unit = ???
}