/**
  * Created by JP11507 on 2017/06/14.
  */
class Rational(n: Int,d: Int) {
  require( d != 0 )
  val number : Int = n
  val denom :Int = d
  override def toString =  n + "/" + d

  def add(that:Rational) :Rational =
    new Rational(
      number * that.denom + that.number * denom,
      denom * that.denom
    )
}
