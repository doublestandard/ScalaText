/**
  * Created by JP11507 on 2017/06/16.
  */
object FindLongLines {
  def main(args: Array[String]): Unit = {
    val width = args(0).toInt
    for(arg <- args.drop(1))
      LongLines.processFile(arg,width)
  }
}
