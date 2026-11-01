package cl.uchile.dcc
package Units

import Actions.Action

import cl.uchile.dcc.Sourse_target.Target

abstract class MagicCharacter(Name:String, HP:Int, Defense:Int, Weight:Int,private var _ManaPoints :Int) 
  extends Character(Name,HP,Defense,Weight){
  def ManaPoints: Int = _ManaPoints
  def ManaPoints_(value: Int): Unit = _ManaPoints = value

}

