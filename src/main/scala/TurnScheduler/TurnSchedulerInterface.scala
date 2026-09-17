package cl.uchile.dcc
package TurnScheduler


trait TurnSchedulerInterface:
  def getChar : Character
  def put(character:Character) : Unit
  def maxAction() : Int
  def register : List[Character]
  def resetBar(character:Character) : Unit
  def increaseBar(amount:Int): Unit
  def completedBar(character:Character): Boolean
  def completedBarList : List[Character]
  def turn : Character
  