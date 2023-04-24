package interpreter

import java.util.ArrayList

class Scanner(val source: String) {
  private val tokens = ArrayList<Token>()
  private val line = 0
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
    tokens.add(Token(TokenType.EOF, "", null, line))
    return tokens
  }
}