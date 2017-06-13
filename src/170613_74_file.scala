import scala.io.Source

if(args.length > 0) {
  val lines = Source.fromFile(args(0)).getLines().toList
  def widthOfLength(s: String) = s.length.toString.length
  var maxWidth = 0
  for(lins <-lines)
    maxWidth = maxWidth.max(widthOfLength(lins))

  for(line <- lines){
    val numSpace = maxWidth - widthOfLength(line)
    val padding = " " * numSpace
    println(padding + line.length + " | " + line)
  }

} else {
  Console.err.println("Please enter filename.")
}
