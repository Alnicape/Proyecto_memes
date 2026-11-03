package cl.uchile.dcc
package Units

import Actions.action

import cl.uchile.dcc.Source_target.target

abstract class magicCharacter(Name:String, HP:Int, Defense:Int, Weight:Int, private var _ManaPoints :Int)
  extends character(Name,HP,Defense,Weight){
  def ManaPoints: Int = _ManaPoints
  def ManaPoints_(value: Int): Unit = _ManaPoints = value
  def discountMana(value: Int): Unit = _ManaPoints -= value

}

