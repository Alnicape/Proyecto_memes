package cl.uchile.dcc
package Items

import Units.{Archer, BlackWizard, Character, Enemy, Knight, Thief, WhiteWizard}
import Items.Item

import cl.uchile.dcc.Actions.Action

abstract class Weapon(val Name : String, val Weight : Int, val ATKPoints : Int, val Owner: Character) extends Item


class Dagger(Name:String, Weight:Int, ATKPoints:Int, Owner: Character) extends Weapon(Name, Weight, ATKPoints, Owner)
  
class Sword(Name:String, Weight:Int, ATKPoints:Int, Owner: Character) extends Weapon(Name, Weight, ATKPoints, Owner)

class Bow(Name:String, Weight:Int, ATKPoints:Int, Owner: Character) extends Weapon(Name, Weight, ATKPoints, Owner)

