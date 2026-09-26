package cl.uchile.dcc
package TurnScheduler

import Units.Units

import scala.collection.mutable.ListBuffer
import scala.compiletime.uninitialized


class TurnScheduler:
  //Attributes
  def UnitsList : ListBuffer[Units] = ListBuffer[Units]()
  def ActionBars: ListBuffer[Int] = ListBuffer[Int]()
  def Turn: Units = uninitialized
  //Methods
  def PutUnit(puttedUnit:Units) : Unit = {
    UnitsList += puttedUnit
  }
  def GetUnit(index:Int): Units = {
    UnitsList(index)    
  }
  def ResetBar(unit:Units): Unit = {
    unit.ActionBar = 0
  }
  def AddAllBars(ActionPoints:Int): Unit
  def MaxBar(unit:Units) : Int
  def CompletedBar(unit:Units): Boolean
  def CompletedUnits(): ListBuffer[Units]