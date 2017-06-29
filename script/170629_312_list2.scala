import org.scalatest.Fact.Binary_&

/**
  * Created by JP11507 on 2017/06/29.
  */
val diag3 =
  List(List(1, 2, 3),
    List(0, 1, 0),
    List(0, 0, 1)
  )
val words = List("the", "quick", "brown", "fox")

// takewhile dropwhile
List(1, 2, 3, -4, 5) takeWhile (_ > 0)
//res0: List[Int] = List(1, 2, 3)

words dropWhile (_ startsWith "T")
//es2: List[String] = List(the, quick, brown, fox)

// span takeとdropをあわせたような
List(1, 2, 3, -4, 5) span (_ > 0)
// res3: (List[Int], List[Int]) = (List(1, 2, 3),List(-4, 5))

// forall p :全ての要素が条件pを満足している場合true
// exists p :条件pを満足する要素が1個でも存在する場合true
// 以下、ネストしたリストの中に0の要素のみで構成されるリストが存在するかをチェック
def hasZeroRow(m: List[List[Int]]) =
m exists (row => row forall (_ == 0))
hasZeroRow(diag3)
//res4: Boolean = false

val diag5 =
  List(List(1, 2, 3),
    List(0, 1, 0),
    List(0, 0, 0)
  )
hasZeroRow(diag5)
//res6: Boolean = true

// 16.7.4 リストの畳み込み
// sum(List(a,b,c)) eqals 0 + a + b+ c こんな感じの操作を畳み込みで行う
def sum(xs: List[Int]): Int = (0 /: xs) (_ + _)

// product(List(a,b,c)) equals 1 * a * b * c
def product(xs: List[Int]): Int = (1 /: xs) (_ * _)

// リストに含まれる全ての単語に対して、先頭と間にspaceを入れて連結
("" /: words) (_ + " " +_)
//res7: String = " the quick brown fox"

// 先頭のspaceを削除したい
(words.head /: words.tail)(_ + " " +_)
// res8: String = the quick brown fox

// foldを使ったリストの反転
def reverseLeft[T](xs:List[T]) =
  (List[T]() /:xs) {(ys,y) => y :: ys}
reverseLeft(words)

// sソート
List(1, -3, 8, 0, 33, -3) sortWith (_ < _)
//res10: List[Int] = List(-3, -3, 0, 1, 8, 33)

words sortWith(_.length > _.length)
//res11: List[String] = List(quick, brown, the, fox)

// 16.8.4 関数実行結果による表の作成
var squares = List.tabulate(5)(n => n * n)
// squares: List[Int] = List(0, 1, 4, 9, 16)
var multiplication = List.tabulate(5, 5)(_ * _)
//multiplication: List[List[Int]] = List(List(0, 0, 0, 0, 0), List(0, 1, 2, 3, 4),
// List(0, 2, 4, 6, 8), List(0, 3, 6, 9, 12), List(0, 4, 8, 12, 16))

// 16.9 複数のリストをまとめて処理する
(List(10, 20), List(3, 2, 5)).zipped.map(_ * _)
//res12: List[Int] = List(30, 40)
(List("abc", "de"), List(3, 2)).zipped.forall(_.length == _)
//res13: Boolean = true
(List("abc", "de"), List(3, 2)).zipped.exists(_.length != _)
//res15: Boolean = false


