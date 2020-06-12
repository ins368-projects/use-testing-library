package range.testing

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.api.Assertions.assertEquals

class RangeTest {
  @DisplayName("Constructor positive result tests")
  @ParameterizedTest(name = "''{0}'' has start: {1} and end: {2}")
  @CsvSource(
    "'[1, 7]', 1, 7",
    "'(1, 10)', 2, 9"
  )
  fun constructorTest(givenRange: String, expectedStart: Int, expectedEnd: Int) {
    val range = Range(givenRange)

    assertEquals(expectedStart, range.start)
    assertEquals(expectedEnd, range.end)
  }

  @DisplayName("Constructor positive result tests")
  @ParameterizedTest(name = "''{0}'' has start: {1} and end: {2}")
  @CsvSource(
    "'[8, 15', El rango especificado no tiene el formato adecuado. Debe usar los síbolos '[]' o '()' para denotarlo.",
    "'[978 923)', El rango especificado no tiene el formato adecuado. Debe separarse sus elementos usando comas."
  )
  fun constructorTest(givenRange: String, expectedError: String) {
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
  fun containsTest(givenRange: String, pointsInArray: String, expectedResult: Boolean) {
    val range = Range(givenRange)
    val points: Array<Int> = numberStringListToIntArray(pointsInArray)

      assertEquals(expectedResult, range.contains(points))
  }

  @DisplayName("doesNotContains test")
  @ParameterizedTest(name = "{0} does not contains '{'{1}'}' is {2}")
  @CsvSource(
    "'(5, 10)', '8,9,10', true",
    "'[321, 400]', '401,402,320', true",
    "'[3, 6]', '4,5', false",
    "'(10, 22)', '18,19,20,21', false"
  )
  fun doesNotContainsTest(givenRange: String, pointsInArray: String, expectedResult: Boolean) {
    val range = Range(givenRange)
    val points: Array<Int> = numberStringListToIntArray(pointsInArray)

    assertEquals(expectedResult, range.doesNotContains(points))
  }

  @DisplayName("containsRange test")
  @ParameterizedTest(name = "{0} contains range '{'{1}'}' is {2}")
  @CsvSource(
    "'[1729, 2000)', '(1728, 1999)', true",
    "'(3, 8)', '[4, 7]', true",
    "'(15, 30)', '[5, 15]', false",
    "'(4, 10)', '[4, 10]', false"
  )
  fun containsRangeTest(givenRange: String, anotherRange: String, expectedResult: Boolean) {
    val range = Range(givenRange)

    assertEquals(expectedResult, range.containsRange(anotherRange))
  }

  @DisplayName("doesNotContains test")
  @ParameterizedTest(name = "{0} does not contains range '{'{1}'}' is {2}")
  @CsvSource(
    "'(15, 30)', '[5, 15]', true",
    "'(4, 10)', '[4, 10]', true",
    "'[1729, 2000)', '(1728, 1999)', false",
    "'(3, 8)', '[4, 7]', false"
  )
  fun doesNotContainsRangeTest(givenRange: String, anotherRange: String, expectedResult: Boolean) {
    val range = Range(givenRange)

    assertEquals(expectedResult, range.doesNotContainsRange(anotherRange))
  }

  @DisplayName("getAllPoints test")
  @ParameterizedTest(name = "''{0}'' includes points: '{'{1}'}'")
  @CsvSource(
    "'[1, 5]', '1,2,3,4,5'",
    "'(-6, 3)', '-5,-4,-3,-2,-1,0,1,2'",
    "'[3, 3]', '3'",
    "'(3, 3)', ''"
  )
  fun getAllPointsTest(givenRange: String, pointsInString: String) {
    val range = Range(givenRange)
    val expectedPoints: Array<Int> = numberStringListToIntArray(pointsInString)

    assertEquals(true, range.getAllPoints() contentEquals expectedPoints)
  }

  @DisplayName("endPoints test")
  @ParameterizedTest(name = "''{0}'' has endpoints: '{'{1}'}'")
  @CsvSource(
    "'[1, 5]', '1,5'",
    "'(4, 8)', '5,7'",
    "'[10, 3]', '10,3'",
    "'(3, 10)', '4,9'"
  )
  fun endPointsTest(givenRange: String, endPointsInString: String) {
    val range = Range(givenRange)
    val expectedEndPoints: Array<Int> = numberStringListToIntArray(endPointsInString)

    assertEquals(true, range.endPoints() contentEquals expectedEndPoints)
  }

  @DisplayName("overlapsRange test")
  @ParameterizedTest(name = "{0} overlaps {1} is {2}")
  @CsvSource(
    "'[3, 8]', '[3, 8]', true",
    "'(5, 10)', '[3, 10]', true",
    "'[1, 4]', '[5, 8]', false",
    "'(2, 7)', '(7, 15)', false"
  )
  fun overlapsRangeTest(givenRange: String, anotherRange: String, expectedResult: Boolean)  {
    val range = Range(givenRange)

    assertEquals(expectedResult, range.overlapsRange(anotherRange))
  }

  @DisplayName("equals test")
  @ParameterizedTest(name = "{0} equals {1} is {2}")
  @CsvSource(
    "'[5, 16]', '[5, 16]', true",
    "'(3, 9)', '[4, 8]', true",
    "'[1, 5]', '(1, 5)', false",
    "'[2, 7]', '(3, 8)', false"
  )
  fun equalsTest(givenRange: String, anotherRange: String, expectedResult: Boolean) {
    val range = Range(givenRange) 

    assertEquals(expectedResult, range.equals(anotherRange))
  }

  @DisplayName("equals test")
  @ParameterizedTest(name = "{0} not equals {1} is {2}")
  @CsvSource(
    "'[1, 5]', '(1, 5)', true",
    "'[2, 7]', '(3, 8)', true",
    "'[5, 16]', '[5, 16]', false",
    "'(3, 9)', '[4, 8]', false"
  )
  fun notEqualsTest(givenRange: String, anotherRange: String, expectedResult: Boolean) {
    val range = Range(givenRange)

    assertEquals(expectedResult, range.notEquals(anotherRange))
  }

  private fun numberStringListToIntArray(stringArray: String): Array<Int> {
    if(stringArray.length > 0)
      return (stringArray.split(",").map { it.toInt() }).toTypedArray()
    else
      return Array<Int>(0) { it }
  }
}
