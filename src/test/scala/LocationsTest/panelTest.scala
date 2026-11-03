package cl.uchile.dcc
package LocationsTest

import Locations.panel

import munit.FunSuite

import scala.collection.mutable.ListBuffer

class panelTest extends FunSuite{
  test("Panel init works"){
    val PanelTest = new panel(2,2,3,3)
    val expected  = ListBuffer((1,2),(3,2),(2,1),(2,3))
    assertEquals(PanelTest.Neighbourhood,expected)
    assertEquals(PanelTest.unitsList,ListBuffer[Character]())
  }

}
