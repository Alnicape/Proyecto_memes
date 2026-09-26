package cl.uchile.dcc
package TurnScheduler

import Units.Units

import scala.collection.mutable.ListBuffer


trait TurnSchedulerInterface:
  //Attributes
  def UnitsList : ListBuffer[Units]
  def ActionBars: ListBuffer[Int]
  def Turn: Units
  //Methods
  def PutUnit(unit:Units) : Unit
  def GetUnit(): Units
  def ResetBar(unit:Units) : Unit
  def AddAllBars(ActionPoints:Int): Unit
  def MaxBar(unit:Units) : Int
  def CompletedBar(unit:Units): Boolean
  def CompletedUnits(): ListBuffer[Units]