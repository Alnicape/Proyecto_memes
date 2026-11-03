package cl.uchile.dcc
package Items

import Exceptions.InvalidInputException
import Source_target.{Source, Target}
import Units.{BlackWizard, Enemy, WhiteWizard}

trait Item extends Target

abstract class AbstractItem extends Item {
  override def isAlive: Boolean = throw InvalidInputException("An item neither can be alive nor dead")
  override def receiveAttackFromCharacter(source: Units.Character): Unit = throw InvalidInputException("An item cannot be attacked")
  override def receiveAttackFromEnemy(source: Enemy): Unit = throw InvalidInputException("An item cannot be attacked")
  override def receiveHeal(source: WhiteWizard): Unit = throw InvalidInputException("An item cannot be healed")
  override def receiveMeteorite(source: Source): Unit = throw InvalidInputException("An item cannot receive damage")
  override def receivePurification(source: WhiteWizard): Unit = throw InvalidInputException("An item cannot receive damage")
  override def receiveThunder(source: BlackWizard): Unit = throw InvalidInputException("An item cannot receive damage")
}
  
