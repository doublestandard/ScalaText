/**
  * Created by JP11507 on 2017/06/19.
  */

import Element.elem
abstract class Element {
  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length

  def above(that: Element): Element = {

    val this1 = this widen that.width
    val that1 = that widen  this.width
    assert(this1.width == that1.width)
    elem(this1.contents ++ that1.contents)
  }
  def beside(that:Element) :Element = {
    val this1 = this heighten  that.height
    val that1 = that heighten this.height
    assert(this1.height == that1.height)

    elem(
      for(
        (line1,line2) <- this1.contents zip that1.contents
      ) yield line1 + line2
    )
  }

  def widen(w:Int):Element = {
    if (w <= width)
      this
    else {
      val left = elem(' ', (w - width) / 2, height)
      val right = elem(' ', w - width - left.width, height)
      left beside this beside right
    }  ensuring (w <= _.width)
  }

  def heighten(h:Int):Element =
    if(h <= height) this
    else {
      val top = elem(' ' ,width,(h-height)/2)
      val bot = elem(' ',width,h-height-top.height)
      top above this above bot
    }

  override def toString = contents mkString "\n"
}

// private 化したExtendsのclass
private class ArrayElement(val contents:Array[String]) extends Element

private class LineElement(s:String) extends  ArrayElement(Array(s)){
  override def height: Int = 1
  override def width: Int = s.length
}

private class UniformElement(ch:Char,override val width:Int,override val height:Int) extends Element{
  if(width < 0 || height < 0)
    throw new IllegalArgumentException
  private val  line = ch.toString * width
  def contents = Array.fill(height)(line)
}

// 10.10 ファクトリーmethodを持つファクトリーオブジェクト
object Element {
  def elem(contents:Array[String]):Element =
    new ArrayElement(contents)

  def elem(chr :Char,width:Int,height:Int) :Element =
    new UniformElement(chr,width,height)

  def elem(line:String) :Element =
    new LineElement(line)
}
