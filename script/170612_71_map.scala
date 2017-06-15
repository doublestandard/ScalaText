import scala.collection.mutable
val treasureMap = mutable.Map[Int,String]()
treasureMap += (1 -> "Go to island.")
treasureMap += (2 -> "Find big X on ground.")
treasureMap += (3 -> "Dig.")
println(treasureMap(2))

val romanNumeral = Map( 1->"Ⅰ", 2-> "Ⅱ" ,3 -> "Ⅲ")
println(romanNumeral(3))