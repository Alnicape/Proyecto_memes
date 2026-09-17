package cl.uchile.dcc
package Items

import Characters.CharacterInterface

abstract class MagicWeapon(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: CharacterInterface, val MagicATKPoints : Int) extends Weapon(Name, Weight, PhysicalATKPoints, Owner)

class Wand(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: CharacterInterface, MagicATKPoints: Int) extends MagicWeapon(Name, Weight, PhysicalATKPoints, Owner, MagicATKPoints)
class Staff(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: CharacterInterface, MagicATKPoints: Int) extends MagicWeapon(Name, Weight, PhysicalATKPoints, Owner, MagicATKPoints)
