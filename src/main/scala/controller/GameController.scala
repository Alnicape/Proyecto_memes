package cl.uchile.dcc
package controller

import Actions.action
import Source_target.{source, target}
import TurnScheduler.turnScheduler

import cl.uchile.dcc.Units.units

/**
  * Controlador principal del juego.
  * En esta clase debes implementar la lógica que conecta las distintas
  * entidades de tu modelo, maneja los turnos, y ejecuta las acciones.
  */
class GameController {
  private var scheduler: turnScheduler = new turnScheduler
  private var currentUnit: Option[units] = None
  private var nextUnit: Option[units] = None

  def putUnit(unit:units):Unit =
    scheduler.PutUnit(unit)

  def getCurrentUnit: Option[units] = currentUnit

  def NextTurn(): Unit = {
    if nextUnit.isEmpty then{
      while (scheduler.turn().isEmpty) {
        scheduler.AddAllBars(1)
      }
      currentUnit = scheduler.turn()
    }else {
      currentUnit = nextUnit
      while (scheduler.turn().isEmpty) {
        scheduler.AddAllBars(1)
      }
      nextUnit = scheduler.turn()
    }
  }
  def getNextTurn: Option[units] = nextUnit
  
  def AvailableActions(source:units):List[action] =
    source.AvailableActions //To implement later
    
  def Resolve(source:source, target:target, action:action):Unit = {
    try source.doAction(target,action)
    catch
      case e=>
        println(e.getMessage)
  }

  def resetAll():Unit = {
    scheduler = new turnScheduler()
    currentUnit = None
    nextUnit = None
  }
}
