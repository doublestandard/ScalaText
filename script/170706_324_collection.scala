/**
  * Created by JP11507 on 2017/07/06.
  */
//リストバッファ
import scala.collection.mutable.ListBuffer
val buf = new ListBuffer[Int]
buf += 1
buf += 2
println(buf.toString())

3 +=: buf
println(buf.toString())

buf.toList


// 配列バッファー
import scala.collection.mutable.ArrayBuffer
val buf2 = new ArrayBuffer[Int]()
buf2 += 12
buf2 += 15
buf2

buf2.length
buf2(0)

// 文字列（StringOps）
def hasUpperCase(s:String) = s.exists(_.isUpper)
// 大文字が入っていればtrue
//String自体にはexistsというmethodはない。
// 暗黙でsをStringOpsに変換する
hasUpperCase("Rebert Frost")
hasUpperCase("ee aerert")

// 集合の使い方
val text = "See Spot run. Run, Spot.Run!"
val wordsArray = text.split("[ !,.]+")
val words = scala.collection.mutable.Set.empty[String]
for(word <- wordsArray) words += word.toLowerCase
words
// res1: scala.collection.mutable.Set[String] = Set(see, run, spot)

//17.2.2 Mapの使い方
// 文字内に単語がいくつ含まれているかを数える
def countWords(text: String) = {
  val counts = scala.collection.mutable.Map.empty[String, Int]
  for (rawWord <- text.split("[ ,!.]+")) {
    val word = rawWord.toLowerCase
    val oldCount = if (counts.contains(word)) counts(word) else 0
    counts += (word -> (oldCount + 1))
  }
  counts
}
countWords("See Spot run. Run, Spot.Run!")
//res0: scala.collection.mutable.Map[String,Int] = Map(spot -> 2, see -> 1, run ->3)

// タプルを使った例
def longestWord(words: Array[String]) = {
  var word = words(0)
  var idx = 0
  for (i <- 1 until words.length)
    if (words(i).length > word.length) {
      word = words(i)
      idx = i
    }
  (word, idx)
}

val longets = longestWord("The quick brown fox".split(" "))



