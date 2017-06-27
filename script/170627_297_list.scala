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

