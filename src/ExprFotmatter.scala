/**
  * Created by JP11507 on 2017/06/27.
  */
import Element.elem
abstract class Expr
case class Var(name:String) extends  Expr
case class Number(num:Double) extends  Expr
case class UnOp(operator:String, arg:Expr)  extends  Expr
case class BinOp(operator:String, left:Expr,right:Expr) extends  Expr

class ExprFotmatter {
  // 優先順位の昇順でグループにまとめた演算子
  private val opGroups =
    Array(
      Set("|","||"),
      Set("&","&&"),
      Set("^"),
      Set("==","!="),
      Set("<","<=",">",">="),
      Set("+","-"),
      Set("*","%")
    )

  // 演算子ら優先順位を導き出すMap
  private val precedence = {
    val assocs =
    for{
      i <- 0 until opGroups.length
      op <- opGroups(i)
    } yield op -> i
    assocs.toMap
  }

  private val unaryPrecendence = opGroups.length
  private val fractionnPrecendence = -1

  private def format (e:Expr,encPrec:Int) :Element =
    e match {
      case Var(name) =>
        elem(name)
      case Number(num) =>
        def srtirpDot(s:String) =
          if(s endsWith ".0") s.substring(0,s.length -2)
          else s
        elem(srtirpDot(num.toString))
      case UnOp(op,arg) =>
        elem(op) beside format(arg,unaryPrecendence)
      case BinOp("/" ,left,right) =>
        val top = format(left,fractionnPrecendence)
        val bot = format(right,fractionnPrecendence)
        val line =elem('-',top.width max bot.width,1)
        val frac = top above line above bot
        if(encPrec != fractionnPrecendence) frac
        else elem(" ") beside frac beside elem(" ")
      case BinOp(op,left,right) =>
        val opPrec =precedence(op)
        val l = format(left,opPrec)
        val r = format(right,opPrec + 1)
        val oper = l beside elem(" " + op + " " ) beside r
        if(encPrec <= opPrec) oper
        else elem("(") beside oper beside elem(")")
    }

  // 公開method
  def format(e:Expr):Element = format(e,0)
}
