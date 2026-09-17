package cl.uchile.dcc
package Actions

import Items.{Potion, Weapon}

abstract class NormalAction(Name:String) extends ActionInterface:      //estará en abstract hasta que pueda definir que es lo que hará cada función
  def Attack(): Unit
  def Move(): Unit
  def EquipWeapon(weapon: Weapon): Unit
  def ConsumePotion(potion: Potion): Unit
