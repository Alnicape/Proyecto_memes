package cl.uchile.dcc
package Actions

abstract class MagicAction(name : String) extends NormalAction(name):   //mismo concepto, al implementar cambiar a class
  def Thunder(): Unit
  def Meteor(): Unit
  def Heal(): Unit
  def Purification(): Unit

