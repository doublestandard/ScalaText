/**
  * Created by JP11507 on 2017/06/16.
  */
import scala.io.Source
object LongLines {
  def processFile(filename:String,width:Int) = {
    def processLine(line:String) ={
      if(line.length > width)
        println(filename + ":" + line.trim)
    }
    val source = Source.fromFile(filename)
    for(line <- source.getLines())
      processLine(line)
  }
}
