var jetSet = Set("Boeing","Airbus")
jetSet += "Lear"
println(jetSet.contains("Cessna"))

import scala.collection.mutable
val movieSet= mutable.Set("Hitch","Poltergeist")
movieSet += "Sherk"
println(movieSet)


import scala.collection.immutable.HashSet
val hashSet = HashSet("Tomates","Chilies")
println(hashSet + "Coriander")