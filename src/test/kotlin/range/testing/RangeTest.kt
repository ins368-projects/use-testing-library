package range.testing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RangeTest {
  @DisplayName("Constructor positive results test")
  @ParameterizedTest
  @CsvSource(
    "'[1, 7]', 1, 7",
    "'(0, 8)', 1, 7"
  )
  fun constructorTest(givenRange: String, expectedStart: Int, expectedEnd: Int) {
    val range = Range(givenRange)

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

  @DisplayName("Constructor negative results test")
  @ParameterizedTest(name = "''{0}'' results in error message: {1}")
  @CsvSource(
    "'[8, 15', El rango especificado no tiene el formato adecuado. Debe usar los síbolos '[]' o '()' para denotarlo.",
    "[978 923), El rango especificado no tiene el formato adecuado. Debe separarse sus elementos usando comas."
  )
  fun constructorTestFailure(givenRange: String, expectedError: String) {
    try {
      Range(givenRange)
    } catch(e: IllegalArgumentException) {
      assertEquals(expectedError, e.message)
    }
  }

  @DisplayName("Contains test")
  @ParameterizedTest(name = "{0} contains '{'{1}'}' is {2}")
  @CsvSource(
    "'[3, 6]', '4,5', true",
    "'(10, 22)', '18,19,20,21', true",
    "'(5, 10)', '8,9,10', false",
    "'[321, 400]', '401,402,320', false"
  )
  fun containsTest(givenRange: String, stringArray: String, expectedResult: Boolean) {
    val range = Range(givenRange)
    val points: Array<Int> = numberStringListToIntArray(stringArray)

    assertEquals(
      expectedResult,
      range.contains(points),
      "range contains given array"
    )
  }

  @DisplayName("doesNotContains test")
  @ParameterizedTest(name = "{0} does not contains '{'{1}'}' is {2}")
  @CsvSource(
    "'(5, 10)', '8,9,10', true",
    "'[321, 400]', '401,402,320', true",
    "'[3, 6]', '4,5', false",
    "'(10, 22)', '18,19,20,21', false"
  )
  fun doesNotContainsTest(givenRange: String, array: String, expectedResult: Boolean) {
    val range = Range(givenRange)
    val points: Array<Int> = numberStringListToIntArray(array)

    assertEquals(expectedResult, range.doesNotContains(points))
  }

  private fun numberStringListToIntArray(stringArray: String): Array<Int> {
    return (stringArray.split(",").map { it.toInt() }).toTypedArray()
  }
}
