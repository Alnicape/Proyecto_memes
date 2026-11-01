package cl.uchile.dcc
package Units

import Actions.{Action, Attack, EquipWeapon, Move}

import cl.uchile.dcc.Exceptions.InvalidSpellException
import cl.uchile.dcc.Sourse_target.Target

abstract class AbstractUnits(protected var _HP:Int,protected var _Defense:Int) extends Units {
  def HP:Int = _HP
  def HP_(value:Int):Unit = _HP = value

  val MaxHP : Int = _HP

  def Defense: Int = _Defense
  def Defense_(value: Int): Unit = _Defense = value

  def AvailableActions: List[Action] = List(new Move("North"), new Move("South"), new Move("East"), new Move("West"),
    new Attack())

  


}