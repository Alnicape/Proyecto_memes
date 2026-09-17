package cl.uchile.dcc
package Characters

abstract class MagicCharacter(Name:String, HealthPoints:Int, Defense:Int, Weight:Int,var ManaPoints :Int) 
  extends NormalCharacter(Name,HealthPoints,Defense,Weight)

class BlackWizard (Name:String, HealthPoints: Int, Defense: Int, Weight:Int, ManaPoints:Int) extends MagicCharacter(Name, HealthPoints, Defense, Weight, ManaPoints)
class WhiteWizard (Name:String, HealthPoints: Int, Defense: Int, Weight:Int, ManaPoints:Int) extends MagicCharacter(Name, HealthPoints, Defense, Weight, ManaPoints)