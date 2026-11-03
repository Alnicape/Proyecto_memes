package cl.uchile.dcc
package Items

import Units.character


abstract class MagicWeapon(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: character, val MagicATKPoints : Int) extends Weapon(Name,Weight, PhysicalATKPoints, Owner)

class Wand(Weight:Int, PhysicalATKPoints:Int, Owner: character, MagicATKPoints: Int,Name:String = "Wand") extends MagicWeapon(Name, Weight, PhysicalATKPoints, Owner, MagicATKPoints)
  
class Staff(Weight:Int, PhysicalATKPoints:Int, Owner: character, MagicATKPoints: Int, Name:String = "Staff") extends MagicWeapon(Name, Weight, PhysicalATKPoints, Owner, MagicATKPoints)
