def formatArgs(args:Array[String]) = args.mkString("\n")
println(formatArgs(args))

val res = formatArgs(Array("o","t","t"))
assert(res == "o\nt\nt")
