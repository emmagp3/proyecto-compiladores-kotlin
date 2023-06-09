class Token(
  private val type: TokenType,
  private val lexeme: String,
  private val literal: Any?,
  private val line: Int
) {
  override fun toString(): String {
    return "Line $line: $type $lexeme $literal"
  }
}