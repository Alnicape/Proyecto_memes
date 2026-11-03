package cl.uchile.dcc
package Locations

class MapPanels(val MaxX:Int, val MaxY:Int) {
  def Panels:Map[(Int,Int),Panel] = {
    val elements = for{x<-0 until MaxX
        y<-0 until MaxY} yield (x,y) -> new Panel(x,y)
    elements.toMap
  }
  private def attachNeighbours():Unit = {
    for (((x,y),panel)<-Panels) {
      if y>0 then panel.North = Panels.get((x,y-1))
      if y < MaxY - 1 then panel.South = Panels.get((x, y + 1))
      if x > 0 then panel.West = Panels.get((x - 1, y))
      if x < MaxX - 1 then panel.East = Panels.get((x + 1, y))
    }
  }
  attachNeighbours()
  def GetPanel(x:Int,y:Int) : Option[Panel] = Panels.get((x,y))
}
