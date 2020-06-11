package range.testing

class Range(range: String) {
  val start: Int;
  val end: Int;
  val range: String;
  
  init {
    this.range = range
    val parts: List<String> = this.range.split(",");
    val filterNumbersRegex = Regex("[^-?0-9]+");

    if(parts.size == 2) {
      val firstPart: String = parts[0];
      val secondPart: String = parts[1];

      // Evluate if privedad range contains valid icnlusive and exclusive range characters.
      val firstCharacterIsRangeCharacter = firstPart[0] == '[' || firstPart[0] == '(';
      val secondCharacterIsRangeCharacter = secondPart[secondPart.length - 1] == ']' || secondPart[secondPart.length - 1] ==')';

      val thereAreValidRangeCharacters = firstCharacterIsRangeCharacter && secondCharacterIsRangeCharacter;
      if(!thereAreValidRangeCharacters) {
        throw IllegalArgumentException("El rango especificado no tiene el formato adecuado. Debe usar los síbolos '[]' o '()' para denotarlo");
      } else {
        try {
          val first = filterNumbersRegex.replace(firstPart, "").toInt();
          val firstPointIsInclusive = firstPart[0] == '[';

          this.start = if(firstPointIsInclusive) first else first + 1;
        } catch(e: Exception) {
          throw IllegalArgumentException("El rango especificado no tiene el formato adecuado. No se especificóun número en la primera parte del rango.");
        }

        try {
          val end: Int = filterNumbersRegex.replace(secondPart, "").toInt();
          val secondPointIsInclusive = secondPart[secondPart.length - 1] == ']';

          this.end = if(secondPointIsInclusive) end else end - 1;
        } catch(e: Exception) {
          throw IllegalArgumentException("El rango especificado no tiene el formato adecuado. No se especificóun número en la segunda parte del rango.");
        }
      }
    } else {
      throw IllegalArgumentException("El rango especificado no tiene el formato adecuado. Debe separarse sus elementos usando ','.")
    }
  }
}
