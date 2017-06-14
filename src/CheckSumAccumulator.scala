/**
  * Created by JP11507 on 2017/06/13.
  */
class CheckSumAccumulator {
  private var sum = 0
  def add(b: Byte): Unit = {sum += b}
  def checksum() :Int = ~(sum & 0xFF) + 1
}

import scala.collection.mutable
object CheckSumAccumulator {
  private val cache = mutable.Map.empty[String,Int]
  def calculate(s: String) : Int =
    if(cache.contains(s)){
      cache(s)
    } else{
      val acc = new CheckSumAccumulator
      for(c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }


}