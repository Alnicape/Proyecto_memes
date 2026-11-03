package cl.uchile.dcc
package Items

import Units.character


abstract class MagicWeapon(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: character, val MagicATKPoints : Int) extends Weapon(Name, Weight, PhysicalATKPoints, Owner)

class Wand(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: character, MagicATKPoints: Int) extends MagicWeapon(Name, Weight, PhysicalATKPoints, Owner, MagicATKPoints)
  
class Staff(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: character, MagicATKPoints: Int) extends MagicWeapon(Name, Weight, PhysicalATKPoints, Owner, MagicATKPoints)
