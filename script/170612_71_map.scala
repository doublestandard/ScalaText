import scala.collection.mutable
val treasureMap = mutable.Map[Int,String]()
treasureMap += (1 -> "Go to island.")
treasureMap += (2 -> "Find big X on ground.")
treasureMap += (3 -> "Dig.")
println(treasureMap(2))

val romanNumeral = Map( 1->"one", 2-> "two" ,3 -> "three")
println(romanNumeral(3))