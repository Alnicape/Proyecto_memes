package cl.uchile.dcc
package Units

import Actions.action

import cl.uchile.dcc.Exceptions.notEnoughManaException
import cl.uchile.dcc.Items.magicPotion
import cl.uchile.dcc.Source_target.target

abstract class magicCharacter(Name:String, HP:Int, Defense:Int, Weight:Int, private var _ManaPoints :Int)
  extends character(Name,HP,Defense,Weight){
  def ManaPoints: Int = _ManaPoints
  def ManaPoints_(value: Int): Unit = {
    if value<0 then throw notEnoughManaException("Cannot cast a spell without mana")
    _ManaPoints = value
  }
  
  val MaxMana:Int = _ManaPoints

  override def consumePotion(target: target): Unit = {
    target.beConsumed(this)
  }
}

