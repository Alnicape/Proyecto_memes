package cl.uchile.dcc
package Locations

import Exceptions.InvalidInputException
import Source_target.{Source, Target}
import Units.{AbstractUnits, BlackWizard, Enemy, Units, WhiteWizard}
class Panel(val x: Int, val y: Int) extends Target{
  def Name = "panel"
  var UnitsList : List[Units] = List.empty
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

  override def receiveMeteorite(source: Source): Unit = {
    source match{
      case s:BlackWizard =>
        for (units <- this.UnitsList) units.receiveThunder(s)
        this.North match{
          case Some(neighbour) =>
            for (units <- neighbour.UnitsList) units.receiveThunder(s)
          case None => 
        }
        this.South match{
          case Some(neighbour) =>
            for (units <- neighbour.UnitsList) units.receiveThunder(s)
          case None => 
        }
        this.East match{
          case Some(neighbour) =>
            for (units <- neighbour.UnitsList) units.receiveThunder(s)
          case None => 
        }
        this.West match{
          case Some(neighbour) =>
            for (units <- neighbour.UnitsList) units.receiveThunder(s)
          case None => 
        }
      case _ =>
        throw InvalidInputException("Cannot receive Meteorite from this Source")
    }
  }

  override def beSet(source: Units.Character): Unit =
    throw InvalidInputException("A panel cannot be a weapon")

  override def setNewPosition(source: AbstractUnits): Unit =
    source.currentLocation match {
      case Some(curr) =>
        curr.North match{
          case Some(n) =>
            if this == n then source.currentLocation = Some(this)
          case None =>   
        }
        curr.South match{
          case Some(s) =>
            if this == s then source.currentLocation = Some(this)
          case None =>
        }
        curr.East match{
          case Some(e) =>
            if this == e then source.currentLocation = Some(this)
          case None =>
        }
        curr.West match{
          case Some(w) =>
            if this == w then source.currentLocation = Some(this)
          case None =>
        }
    }
}