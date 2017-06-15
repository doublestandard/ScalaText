val oneTwo = List(1,2)
val threeFour = List(3,4)
val oneTwoThreeFour = oneTwo ::: threeFour

println(oneTwo + " and " + threeFour + " wer not mutated.")
println("Thus," + oneTwoThreeFour + " is a new List")

println("---------------------")
val twoThree = List(2,3)
val oneTowThree = 1 :: twoThree
println(oneTowThree)

println("---------------------")
val oneTwoThree = 1 :: 2 :: 3:: Nil
println(oneTwoThree)
