package cl.uchile.dcc
package controller

import Actions.action
import Source_target.{source, target}
import TurnScheduler.turnScheduler

/**
  * Controlador principal del juego.
  * En esta clase debes implementar la lógica que conecta las distintas
  * entidades de tu modelo, maneja los turnos, y ejecuta las acciones.
  */
class GameController {
  private var scheduler: turnScheduler = new turnScheduler
  private var currentUnit: Option[source] = None
  def getCurrentUnit: Option[source] = currentUnit
  private var nextUnit: Option[source] = None
  def NextTurn(): Unit = {
    currentUnit = nextUnit
    while(scheduler.turn().isEmpty){
      scheduler.AddAllBars(1)
    }
    nextUnit = scheduler.turn()
  }
  def getNextTurn: Option[source] = nextUnit
  
  def AvailableActions(source:source):List[action] =
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
