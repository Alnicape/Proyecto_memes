package cl.uchile.dcc
package PlayersTest

import Players.player

import munit.FunSuite



class playerTest extends FunSuite{
  test("Player init works"){
    val PlayerTest = new player("Faker")
    assertEquals(PlayerTest.Name,"Faker") //Implementations will have access to attributes like defeated or UnitsList to avoid showing too much to the client

  }
}
