package cl.uchile.dcc
package Actions

import Sourse_target.{Source, Target}


trait Action[S<:Source,T<:Target]:
  def Name: String
  def Act(source:S,target:T):Unit



