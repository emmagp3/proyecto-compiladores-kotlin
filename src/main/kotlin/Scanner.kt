import java.util.ArrayList

class Scanner(private val source: String) {
  private val tokens = ArrayList<Token>()
  private var line = 0
  private val keywords: MutableMap<String, TokenType>
  init {
    keywords = HashMap()
    keywords["else"]   = TokenType.ELSE
    keywords["class"]  = TokenType.CLASS
    keywords["for"]    = TokenType.FOR
    keywords["func"]   = TokenType.FUNCTION
    keywords["if"]     = TokenType.IF
    keywords["null"]   = TokenType.NULL
    keywords["print"]  = TokenType.PRINT
    keywords["return"] = TokenType.RETURN
    keywords["super"]  = TokenType.SUPER
    keywords["this"]   = TokenType.THIS
    keywords["true"]   = TokenType.TRUE
    keywords["false"]  = TokenType.FALSE
    keywords["while"]  = TokenType.WHILE
    keywords["var"]    = TokenType.VAR
  }

  fun scanTokens(): List<Token> {
    var state = 0

    for (i in 0..source.length) {
      val currentChar = getCurrentChar(i, source.length)
      line = incrementLineNumber(currentChar)

      when (state) {
        0 -> {
          if (currentChar != '\u0000') {
            println("Pasa: $currentChar")
          }
          else {
            println("No pasa: $currentChar")
          }
        }
      }
    }

    tokens.add(Token(TokenType.EOF, "", null, line))
    return tokens
  }

  private fun incrementLineNumber(current: Char) = if (current == '\n') line++ else line

  private fun getCurrentChar(index: Int, sourceLength: Int) = if (index >= sourceLength) '\u0000' else source[index]
}