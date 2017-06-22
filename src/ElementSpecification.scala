/**
  * Created by JP11507 on 2017/06/22.
  */

import org.specs2.mutable.Specification
import org.specs2.matcher
import Element.elem
object ElementSpecification extends Specification {
  "A UniformElement" should  {
    "have a width equal to the passed value" in {
      val ele = elem('x',2,3)
      ele.width must be_== (2)
    }
  }
}
