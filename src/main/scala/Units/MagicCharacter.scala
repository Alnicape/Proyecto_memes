package cl.uchile.dcc
package Units

import Actions.Action

abstract class MagicCharacter(Name:String, HP:Int, Defense:Int, Weight:Int,var ManaPoints :Int) 
  extends Character(Name,HP,Defense,Weight)

