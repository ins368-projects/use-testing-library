package range.testing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.api.Test

class RangeTest {
  // Crear test.
  var range: Range? = null

  @ParameterizedTest()
  @ValueSource(strings = arrayOf("[1, 7]", "(0, 8)"))
  fun testConstructor(range: String) {
    println("range: $range")
    this.range = Range(range)

    assertEquals(1, this.range?.start, "expect range.start equals 1")
    assertEquals(7, this.range?.end, "expect range.end equals 7")
  }
}
