package range.testing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.api.Test

class RangeTest {
  @ParameterizedTest()
  @ValueSource(strings = arrayOf("[1, 7];1;7", "(0, 8);1;7"))
  fun constructorTest(query: String) {
    val parts: Array<String> = query.split(";").toTypedArray()

    val stringRange: String = parts[0]
    val expectedStart: Int = parts[1].toInt()
    val expectedEnd: Int = parts[2].toInt()

    val range = Range(stringRange)

    assertEquals(
      expectedStart,
      range.start,
      "expect the start point of the range equals $expectedStart"
    )

    assertEquals(
      expectedEnd,
      range.end,
      "expect the end point of the range equals $expectedEnd"
    )
  }
}
