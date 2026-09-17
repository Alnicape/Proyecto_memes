package cl.uchile.dcc
package Actions

import Items.{Potion, Weapon}

trait ActionInterface:
  def Name: String
  def Attack(): Unit
  def Move(): Unit
  def EquipWeapon(weapon : Weapon): Unit
  def ConsumePotion(potion : Potion): Unit



