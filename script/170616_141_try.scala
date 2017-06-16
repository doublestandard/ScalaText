import java.net.{MalformedURLException, URL}

/**
  * Created by JP11507 on 2017/06/16.
  */

def urlFor(path:String) =
  try{
    new URL(path)
  } catch {
    case e: MalformedURLException =>
      new URL("http://www.google.com")
  }

def f():Int = try return 1 finally return 2
println("f:" + f())

def g():Int = try 1 finally  2
println("g:" + g())