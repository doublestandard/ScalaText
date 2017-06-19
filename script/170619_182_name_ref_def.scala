/**
  * Created by JP11507 on 2017/06/19.
  */
var assersionsEnabled = true

def myAssert(predicate: => Boolean) =
  if(assersionsEnabled && !predicate)
    throw new AssertionError
myAssert(3<5)

assersionsEnabled = false
def boolAssert(predicate :Boolean) =
  if(assersionsEnabled && !predicate)
    throw new AssertionError

val x = 5
// エラーになる（ゼロ割出来ない）
//boolAssert(x / 0 == 0)

// エラーにならない（先にassersionEnableを評価して、その後に、割り算するから）
myAssert(x / 0 == 0)
