package cl.uchile.dcc
package Units

import Actions.Action

import cl.uchile.dcc.Source_target.Target

abstract class magicCharacter(Name:String, HP:Int, Defense:Int, Weight:Int, private var _ManaPoints :Int) 
  extends Character(Name,HP,Defense,Weight){
  def ManaPoints: Int = _ManaPoints
  def ManaPoints_(value: Int): Unit = _ManaPoints = value

}

