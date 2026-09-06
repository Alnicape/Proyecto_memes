package cl.uchile.dcc
package Mapa

import scala.collection.mutable.ListBuffer
class Panel(val x: Int, val y: Int, val MaxX: Int, val MaxY: Int):
  var UnitsList : ListBuffer[Character] = ListBuffer.empty[Character]
  val Neighbourhood : ListBuffer[Panel] = {
    val PanelList:ListBuffer[Panel] = ListBuffer.empty[Panel]
    if x==MaxX then PanelList += Panel(x-1,y,MaxX,MaxY)
    if x==1 then PanelList += Panel(x+1,y,MaxX,MaxY)
    if y==MaxY then PanelList += Panel(x,y-1,MaxX,MaxY)
    if y==1 then PanelList += Panel(x,y+1,MaxX,MaxY)
    PanelList
  }