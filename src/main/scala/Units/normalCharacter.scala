package cl.uchile.dcc
package Units

import Source_target.Target

import cl.uchile.dcc.Exceptions.InvalidSpellException

abstract class normalCharacter(override val Name:String, _HP:Int, _Defense:Int,override val Weight:Int) extends Character(Name,_HP,_Defense,Weight){
  override def doHeal(target: Target): Unit =
    throw InvalidSpellException("This unit cannot cast doHeal")

  override def doPurification(target: Target): Unit =
    throw InvalidSpellException("This unit cannot cast doPurification")

  override def doThunder(target: Target): Unit =
    throw InvalidSpellException("this unit cannot cast doThunder")

  override def doMeteorite(target: Target): Unit =
    throw InvalidSpellException("This unit cannot cast doMeteorite")
}
