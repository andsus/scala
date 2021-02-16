object MatchingBrackets {
  //  def isPaired(s: String): Boolean = {
  //   val terminals = Array("()", "[]", "{}")
  //   s.foldLeft(List[Char]()){(a,v) => a match {
  //     case x :: xs if (terminals.contains("" + x + v)) => xs
  //     case _ => v +: a
  //   }}.isEmpty
  //  }


   private val findPairMap = Map(
    '[' -> ']',
    '{' -> '}',
    '(' -> ')'
  )

  val left = findPairMap.keySet
  val right = findPairMap.values.toSet
  val brackets = left ++ right

  def isPaired(input : String) : Boolean = {
    def _isPaired(chars: List[Char], stack : List[Char]): Boolean = {
      (chars, stack) match {
        case (Nil, Nil) => true
        case (ch :: ct, s) if !brackets.contains(ch) => _isPaired(ct, s)
        case (ch::ct, s) if left.contains(ch) => _isPaired(ct, ch::s)
        case (ch::ct, sh::st) if (right.contains(ch) && findPairMap(sh) == ch) => _isPaired(ct, st)
        case _ => false
      }
    }
    _isPaired(input.toList, List())

  }
}
