/**
  * Created by JP11507 on 2017/06/19.
  */
abstract class Element {
  def demo = {
    println("Element's implementation invoked")
  }
}

class ArrayElements extends Element {
  override def demo ={
    println("ArrayElement's implementation invoked")
  }
}

class LineElement extends ArrayElements {
  override def demo ={
    println("LineElement's implementation invoked")
  }
}

class UniformElement extends  Element


def invokeDemo(e: Element) ={
  e.demo
}