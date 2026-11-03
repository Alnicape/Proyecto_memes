package cl.uchile.dcc
package TurnScheduler

import Units.units

import scala.collection.mutable.ListBuffer



class turnScheduler:
  //Attributes
  private def UnitsList : ListBuffer[units] = ListBuffer[units]()
  //Methods
  def PutUnit(puttedUnit:units) : Unit = {
    UnitsList += puttedUnit
  }
  def GetUnit(index:Int): units = {
    UnitsList(index)
  }
  def ResetBar(unit:units): Unit = {
    unit.ResetBar()
  }
  def AddAllBars(ActionPoints:Int): Unit = {
    for (x <- UnitsList) {x.AddBar(ActionPoints)}
  }
  def MaxBar(unit:units) : Int = {
    unit.Weight //Still don't know how to implement because the difference between character and enemy maxBar
  }
  private def CompletedBar(unit:units): Boolean = {
    unit.GetActionBar()>=unit.Weight
  }
  private def CompletedUnits(): ListBuffer[units] = { //Neither I know how to sort them nor how to manage ties
    val completed = ListBuffer[units]()
    for (x<-UnitsList){if CompletedBar(x) then {completed += x}}
    completed
  }
  def turn():Option[units] = {
    CompletedUnits().headOption
  }