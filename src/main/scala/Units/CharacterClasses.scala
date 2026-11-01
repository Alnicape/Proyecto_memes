package cl.uchile.dcc
package Units

import Actions.{Action, Heal, Meteorite, Purification, Thunder}
import Sourse_target.Target

import cl.uchile.dcc.Items.Weapon

//Normal ones
class Knight (Name:String, HP: Int, Defense: Int, Weight:Int) extends Character(Name, HP, Defense, Weight)


class Archer (Name:String, HP: Int, Defense: Int, Weight:Int) extends Character(Name, HP, Defense, Weight)


class Thief (Name:String, HP: Int, Defense: Int, Weight:Int) extends Character(Name, HP, Defense, Weight)



class BlackWizard (Name:String, HP: Int, Defense: Int, Weight:Int, ManaPoints:Int) extends MagicCharacter(Name, HP, Defense, Weight, ManaPoints) {
  override def AvailableActions: List[Action] = 
    new Meteorite()::new Thunder()::super.AvailableActions
}

class WhiteWizard (Name:String, HP: Int, Defense: Int, Weight:Int, ManaPoints:Int) extends MagicCharacter(Name, HP, Defense, Weight, ManaPoints) {
  override def AvailableActions: List[Action] =
    new Heal() :: new Purification() :: super.AvailableActions
}
