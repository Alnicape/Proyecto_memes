package cl.uchile.dcc
package Items

import Characters.CharacterInterface
import Items.Item

abstract class Weapon(val Name : String, val Weight : Int, val PhysicalATKPoints : Int, val Owner: CharacterInterface) extends Item


class Dagger(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: CharacterInterface) extends Weapon(Name, Weight, PhysicalATKPoints, Owner)
class Sword(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: CharacterInterface) extends Weapon(Name, Weight, PhysicalATKPoints, Owner)
class Bow(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: CharacterInterface) extends Weapon(Name, Weight, PhysicalATKPoints, Owner)
