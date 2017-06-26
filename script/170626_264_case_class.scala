

/**
  * Created by JP11507 on 2017/06/26.
  */
abstract class Expr
case class Var(name:String) extends  Expr
case class Number(num:Double) extends  Expr
case class UnOp(operator:String, arg:Expr)  extends  Expr
case class BinOp(operator:String, left:Expr,right:Expr) extends  Expr

def SimplifyTop(expr:Expr) = expr match {
  case UnOp("-",UnOp("-",e)) => e
  case BinOp("+",e,Number(0)) => e
  case BinOp("*",e,Number(1)) => e
  case _ => expr
}

// List 15.5
def describe(x:Any) = x match{
  case 5=> "five"
  case true => "truth"
  case "hello" => "Hi!"
  case Nil => "the empty list"
  case  List(0,_,_) => "found it"
  case List(0,_*) => "found it zero List"
  case (a,b,c) => "match " + a + b + c
  case s: String  => s.length
  case  m:Map[_,_] => m.size
  case _ => "something else"
}

// 15.2.7.1 型消去
// 以下の関数は、正しく動作しない
def isIntIntMap(x:Any) = x match {
  case m:Map[Int,Int] => true
  case _ => false
}
// Mapのオブジェクトの引数の型を区別できないので、どんなMapでもtrueを返す。

// Listは型判定をしてくれる
def isStringArray(x:Any) = x match {
  case a:Array[String] => "yes"
  case _ => "no"
}

// 15．14　パターンガードを持つマッチ式
def simplifyAdd(e:Expr) = e match {
  case BinOp("+" ,x,y) if x== y =>
    BinOp("*",x,Number(2))
  case _ => e
}

// 15.15 ケースの順序が意味を持つマッチ式
def simplifyAll(expr:Expr) :Expr = expr match {
  case UnOp("-",UnOp("-",e)) =>
    simplifyAll(e)  // '-'は元の数の逆数
  case BinOp("+",e,Number(0)) =>
    simplifyAll(e) // '0'は’＋’の単位元
  case BinOp("*",e,Number(1)) =>
    simplifyAll(e)
  case UnOp(op,e) =>
    UnOp(op,simplifyAll(e))
  case BinOp(op,l,r) =>
    BinOp(op,simplifyAll(l),simplifyAll(r))
  case _ => expr

  case _ => expr
}

// 15.6 option型
val capital = Map("France" -> "Paris","Japan" -> "Tokyo")
def show(x: Option[String]) = x match {
  case Some(s) => s
  case None => "?"
}

show(capital get "France")

show(capital get "North")

// 15.7.1 変数定義におけるパターン
// 1つの代入で複数の変数を定義する
val myTuple = (123,"abc")
val(number,string) = myTuple

// ケースclassの要素にパターンで分解する
val exp = new BinOp("*",Number(5),Number(1))
val BinOp(op,left,right) = exp