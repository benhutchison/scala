/*                     __                                               *\
**     ________ ___   / /  ___     Scala API                            **
**    / __/ __// _ | / /  / _ |    (c) 2003-2011, LAMP/EPFL             **
**  __\ \/ /__/ __ |/ /__/ __ |    http://scala-lang.org/               **
** /____/\___/_/ |_/____/_/ | |                                         **
**                          |/                                          **
\*                                                                      */

package scala.math

/**
 * @since 2.8
 */
trait Fractional[T] extends Numeric[T] {
}

object Fractional {
  trait ExtraImplicits {
    implicit def infixNumericOps[T](x: T)(implicit num: Numeric[T]): Numeric[T]#Ops = new num.Ops(x) 
    
    implicit def infixAdditiveOps[T](x: T)(implicit num: Additive[T]): Additive[T]#Ops = new num.Ops(x)
    implicit def infixSubtractiveOps[T](x: T)(implicit num: Subtractive[T]): Subtractive[T]#Ops = new num.Ops(x)
    implicit def infixMultiplicativeOps[T](x: T)(implicit num: Multiplicative[T]): Multiplicative[T]#Ops = new num.Ops(x)   
    implicit def infixDivisiveOps[T](x: T)(implicit num: Divisive[T]): Divisive[T]#Ops = new num.Ops(x)
  }
  object Implicits extends ExtraImplicits
}