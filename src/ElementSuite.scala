/**
  * Created by JP11507 on 2017/06/22.
  */
import org.scalatest.FunSuite
import Element.elem
class ElementSuite  extends FunSuite{
  test("elem result should have passes width"){
    val elm = elem('x',2,3)
    assert(elm.width == 2)
  }
}
