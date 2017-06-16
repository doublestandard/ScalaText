/**
  * Created by JP11507 on 2017/06/16.
  */

// 一段分をsequenceで返す
def makeRowSeq(row :Int) =
  for(col <- 1 to 10) yield {
    val prod = (row * col).toString
    val padding = " " * (4 - prod.length)
    padding + prod
  }

// 1段分を文字列で返す
def makeRow(row:Int) = makeRowSeq(row).mkString

// 1行に1段分の文字列を収めた表を返す
def multiTable() = {
  val tableseq =
    for(row <- 1 to 10)
      yield makeRow(row)

  tableseq.mkString("\n")
}

println(multiTable())