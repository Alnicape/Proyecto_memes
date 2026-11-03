package cl.uchile.dcc
package Items

import Exceptions.invalidInputException
import Source_target.{source, target}
import Units.{abstractUnits, BlackWizard, enemy, WhiteWizard}

trait Item extends target

abstract class AbstractItem extends Item {
  override def isAlive: Boolean = throw invalidInputException("An item neither can be alive nor dead")
  override def receiveAttackFromCharacter(source: Units.character): Unit = throw invalidInputException("An item cannot be attacked")
  override def receiveAttackFromEnemy(source: enemy): Unit = throw invalidInputException("An item cannot be attacked")
  override def receiveHeal(source: WhiteWizard): Unit = throw invalidInputException("An item cannot be healed")
  override def receiveMeteorite(source: source): Unit = throw invalidInputException("An item cannot receive damage")
  override def receivePurification(source: WhiteWizard): Unit = throw invalidInputException("An item cannot receive damage")
  override def receiveThunder(source: BlackWizard): Unit = throw invalidInputException("An item cannot receive damage")
  override def setNewPosition(source: abstractUnits): Unit = throw invalidInputException("An item cannot be a new position")
}
  
