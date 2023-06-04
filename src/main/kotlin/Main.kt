import java.io.File
import java.nio.charset.Charset
import kotlin.system.exitProcess

var errors = false

fun main(args: Array<String>) {
  if (args.size > 1) {
    exitProcess(64)
  }
  else if (args.size == 1) {
    runFile(args[0])
  }
  else runPrompt()
}


// TODO: Implementar
fun run(source: String) {
  val scanner = Scanner(source)
  val tokens = scanner.scanTokens()

  for (token in tokens) println(token)
}

fun runPrompt() {
  while (true) {
    print("> ")
    readlnOrNull()?.let {
      run(it)
    }
  }
}

fun runFile(path: String) {
  val file = File(path)
  val source = file.readText(charset=Charset.defaultCharset())
  run(source)
}

fun error(line: Int, message: String) {
  report(line, message=message)
}

fun report(line: Int, where: String = "", message: String) {
  println("Line $line: Error $message $where")
}