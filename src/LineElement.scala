/**
  * Created by JP11507 on 2017/06/19.
  */
class LineElement(s:String) extends  ArrayElement(Array(s)){
  override def height: Int = 1

  override def width: Int = s.length
}
