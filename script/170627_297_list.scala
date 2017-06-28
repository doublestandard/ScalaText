

/**
  * Created by JP11507 on 2017/06/27.
  */
//16.1
val fruit = List("apples", "oranges", "pears")
val nums = List(1, 2, 3, 4)
val diag3 =
  List(List(1, 2, 3),
    List(0, 1, 0),
    List(0, 0, 1)
  )
val empty = List()

// 16.5
//val List(a,b,c) = fruit

val a :: b :: rest = fruit

// 基本methodを使わずに、パターンでリストを分解
def isort(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case x :: xs1 => insert(x, isort(xs1))
}
def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case List() => List(x)
  case y :: ys => if (x <= y) x :: xs
  else y :: insert(x, ys)
}

//16.6.2 分割統治原則
def append[T](xs: List[T], ys: List[T]): List[T] =
  xs match {
    case List() => ys
    case x :: xs1 => x :: append(xs1, ys)
  }

// 16.6.12 サンプル：マージソート
// リスト16.1
def msort[T](less: (T, T) => Boolean)
            (xs: List[T]): List[T] = {
  def merge(xs: List[T], ys: List[T]): List[T] =
    (xs, ys) match {
      case (Nil, _) => ys
      case (_, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (less(x, y)) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }

  val n = xs.length / 2
  if (n == 0) xs
  else {
    val (ys, zs) = xs splitAt n
    merge(msort(less)(ys), msort(less)(zs))
  }
}
// フォーマット：ctr + alt + l
msort((x: Int, y: Int) => x < y)(List(5, 7, 1, 3))

// カリー化
// 小さい順にソート
val intSort = msort((x: Int, y: Int) => x < y) _
// 大きい順にソート
val reverseSort = msort((x: Int, y: Int) => x > y) _
val mixedInt = List(7, 4, 7, 3, 5, 6, 4, 1, 9)

intSort(mixedInt)
reverseSort(mixedInt)

// 16.7.1 リストの各要素のマッピング
List(1, 2, 3) map (_ + 1)
// res3: List[Int] = List(2, 3, 4)

val words = List("the", "quick", "brown", "fox")
words map (_.length)
//res4: List[Int] = List(3, 5, 5, 3)

words map (_.toList.reverse.mkString)
//res5: List[String] = List(eht, kciuq, nworb, xof)

// floatMapとmapの違い
words map (_.toList)
// res6: List[List[Char]] = List(List(t, h, e), List(q, u, i, c, k), List(b, r, o, w,n), List(f, o, x))

words flatMap (_.toList)
// res7: List[Char] = List(t, h, e, q, u, i, c, k, b, r, o, w, n, f, o, x)

// 1<=j<i<5になるすべての(i,j)のリストを作成する
List.range(1, 5) flatMap (
  i => List.range(1, i) map (j => (i, j))
  )
// 上と同じ意味
for (i <- List.range(1, 5); j <- List.range(1, i)) yield (i, j)

// foreachを使った場合
var sum = 0
List(1, 2, 3, 4, 5) foreach (sum += _)
sum
//res11: Int = 15

//16.7.2 リストのフィルタリング
List(1, 2, 3, 4, 5) filter (_ % 2 == 0)
// res12: List[Int] = List(2, 4)

words filter (_.length == 3)
//res13: List[String] = List(the, fox)

// partition methodはfalseになった要素を別のListで返す
List(1, 2, 3, 4, 5) partition (_ % 2 == 0)
//res14: (List[Int], List[Int]) = (List(2, 4),List(1, 3, 5))


// findは条件にあう要素のindexを返す
List(1,2,3,4,5) find (_ % 2 == 0)
// res15: Option[Int] = Some(2)

List(1,2,3,4,5) find (_ < 0)
//res16: Option[Int] = None



