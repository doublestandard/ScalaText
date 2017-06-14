/**
  * Created by JP11507 on 2017/06/14.
  */
import CheckSumAccumulator.calculate
object Summer {
  def main(args: Array[String]): Unit = {
    for(arg <- args)
      println(arg + " " + calculate(arg))
  }
}
