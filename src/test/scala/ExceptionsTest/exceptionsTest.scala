package cl.uchile.dcc
package ExceptionsTest

import cl.uchile.dcc.Actions.attack
import cl.uchile.dcc.Exceptions.deadException
import cl.uchile.dcc.Units.Knight
import munit.FunSuite

class exceptionsTest extends FunSuite{

  test("deadException works"){
    val DeadKnight : Knight = new Knight(-10,10,10)
    val AliveKnight : Knight = new Knight(10,10,10)
    val Attack: attack = new attack()
    val exception1 = intercept[deadException]{
      DeadKnight.doAction(AliveKnight,Attack)
    }
    val exception2 = intercept[deadException]{
      AliveKnight.doAction(DeadKnight,Attack)
    }
    assertEquals(exception1.getMessage,"Source unit died before")
    assertEquals(exception2.getMessage,"Target unit died before")
  }

}
