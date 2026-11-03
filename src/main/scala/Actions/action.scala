package cl.uchile.dcc
package Actions

import Source_target.{ source, target}


trait action(Name: String):
  def Act(source:source, target:target):Unit



