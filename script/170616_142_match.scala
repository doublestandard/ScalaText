/**
  * Created by JP11507 on 2017/06/16.
  */
val firstArg = if(!args.isEmpty) args(0) else ""
val friend =
  firstArg match {
    case "salt" => "pepper"
    case "chips" => "salsa"
    case "eggs" => "bacon"
    case _ => "huh?"
  }

println(friend)

//continue & break
def searchFrom(i:Int):Int =
  if (i >= args.length) -1
  else if(args(i).startsWith("-")) searchFrom(i+1)
  else if(args(i).endsWith(".scala")) i
  else searchFrom(i + 1)

val i = searchFrom(0)
