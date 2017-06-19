/**
  * Created by JP11507 on 2017/06/19.
  */
class UniformElement(ch:Char,override val width:Int,override val height:Int) extends Element{
  private val  line = ch.toString
  def contents = Array.fill(height)(line)

}
