import java.io.File

// List7.5
val fileHere = new File(".").listFiles()
for(file <- fileHere if file.getName.endsWith(".scala"))
  println(file)

for(i <- 1 to 4)
  println("iterator" + i)

for(i <- 1 until 4)
  println("iterator" + i)

def fileLines(file :java.io.File)  =
  scala.io.Source.fromFile(file).getLines().toList

def grep(pattern:String) =
  for(
    file <- fileHere
    if file.getName.endsWith(".scala");
    line <- fileLines(file);
    trimmed = line.trim
    if trimmed.matches(pattern)
  ) println(file + ":" + trimmed)

grep(".*gcd.*")

def scalaFiles =
  for{
    file <-fileHere
    if file.getName.endsWith(".scala")
  } yield  file
