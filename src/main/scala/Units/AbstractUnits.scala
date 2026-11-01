package cl.uchile.dcc
package Units

import Actions.{Action, Attack, EquipWeapon, Move}

abstract class AbstractUnits extends Units:

  def AvailableActions : List[Action] = List(new Move("North"),new Move("South"),new Move("East"),new Move("West"),
    new Attack() )
  