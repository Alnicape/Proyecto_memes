package cl.uchile.dcc
package TurnScheduler

import Units.Units

import scala.collection.mutable.ListBuffer
import scala.compiletime.uninitialized


class TurnScheduler:
  //Attributes
  private def UnitsList : ListBuffer[Units] = ListBuffer[Units]()
  private def ActionBars: ListBuffer[Int] = ListBuffer[Int]()
  //Methods
  private def PutUnit(puttedUnit:Units) : Unit = {
    UnitsList += puttedUnit
  }
  private def GetUnit(index:Int): Units = {
    UnitsList(index)    
  }
  private def ResetBar(unit:Units): Unit = {
    unit.ResetBar()
  }
  private def AddAllBars(ActionPoints:Int): Unit = {
    for (x <- UnitsList) {x.AddBar(ActionPoints)} 
  }
  private def MaxBar(unit:Units) : Int = {
    unit.Weight //Still don´t know how to implement because the difference between character and enemy maxBar 
  }
  private def CompletedBar(unit:Units): Boolean = {
    unit.GetActionBar()>=unit.Weight
  }
  private def CompletedUnits(): ListBuffer[Units] = {
    val completed = ListBuffer[Units]()
    for (x<-UnitsList){if CompletedBar(x) then {completed += x}}
    completed
  }
  private def turn():Units = {
    CompletedUnits().head
  }