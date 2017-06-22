/**
  * Created by JP11507 on 2017/06/22.
  */
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import Element.elem
class ElementSpec extends FlatSpec with Matchers{
  "A UniformElement" should "have a width equal to the passed value" in {
    val elm = elem('x',2,3)
    elm.width should be (2)
  }

  it should "have a height equal to the passed value" in {
    val elm = elem('x',2,3)
    elm.height should be (3)
  }

  it should "throw an IAE if passed anegative width" in {
    an[IllegalArgumentException] should be thrownBy{
      elem('x',-2,3)
    }
  }
}
