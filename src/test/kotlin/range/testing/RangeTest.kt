package range.testing

import kotlin.test.Test
import kotlin.test.assertEquals

class RangeTest {
  @Test fun testEndPoints() {
    val range = Range("[2, 5]")
    assertEquals(
      message = "e.e?",
      expected = 2,
      actual = range.endPoints().size
    )
  }
}
