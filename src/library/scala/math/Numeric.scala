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
object Numeric {
  trait ExtraImplicits {
    /** These implicits create conversions from a value for which an implicit Numeric
     *  exists to the inner class which creates infix operations.  Once imported, you
     *  can write methods as follows:
     *  {{{
     *  def plus[T: Numeric](x: T, y: T) = x + y
     *  }}}
     */
    implicit def infixNumericOps[T](x: T)(implicit num: Numeric[T]): Numeric[T]#Ops = new num.Ops(x)    
    
    implicit def infixAdditiveOps[T](x: T)(implicit num: Additive[T]): Additive[T]#Ops = new num.Ops(x)
    implicit def infixSubtractiveOps[T](x: T)(implicit num: Subtractive[T]): Subtractive[T]#Ops = new num.Ops(x)
    implicit def infixMultiplicativeOps[T](x: T)(implicit num: Multiplicative[T]): Multiplicative[T]#Ops = new num.Ops(x)   
    implicit def infixDivisiveOps[T](x: T)(implicit num: Divisive[T]): Divisive[T]#Ops = new num.Ops(x)
  }
  object Implicits extends ExtraImplicits { }
  
  trait BigIntIsIntegral extends Additive.BigIntIsSubtractive with Multiplicative.BigIntIsDivisive with Integral[BigInt] {
    def rem(x: BigInt, y: BigInt): BigInt = x % y
    def fromInt(x: Int): BigInt = BigInt(x)
    def toInt(x: BigInt): Int = x.intValue
    def toLong(x: BigInt): Long = x.longValue
    def toFloat(x: BigInt): Float = x.longValue.toFloat
    def toDouble(x: BigInt): Double = x.longValue.toDouble
  }
  implicit object BigIntIsIntegral extends BigIntIsIntegral with Ordering.BigIntOrdering
  
  trait IntIsIntegral extends Additive.IntIsSubtractive with Multiplicative.IntIsDivisive with Integral[Int] {
    def rem(x: Int, y: Int): Int = x % y
    def fromInt(x: Int): Int = x
    def toInt(x: Int): Int = x
    def toLong(x: Int): Long = x
    def toFloat(x: Int): Float = x
    def toDouble(x: Int): Double = x
  }
  implicit object IntIsIntegral extends IntIsIntegral with Ordering.IntOrdering
  
  trait ShortIsIntegral extends Additive.ShortIsSubtractive with Multiplicative.ShortIsDivisive with Integral[Short] {
    def rem(x: Short, y: Short): Short = (x % y).toShort
    def fromInt(x: Int): Short = x.toShort
    def toInt(x: Short): Int = x.toInt
    def toLong(x: Short): Long = x.toLong
    def toFloat(x: Short): Float = x.toFloat
    def toDouble(x: Short): Double = x.toDouble
  }
  implicit object ShortIsIntegral extends ShortIsIntegral with Ordering.ShortOrdering
  
  trait ByteIsIntegral extends Additive.ByteIsSubtractive with Multiplicative.ByteIsDivisive with Integral[Byte] {
    def rem(x: Byte, y: Byte): Byte = (x % y).toByte
    def fromInt(x: Int): Byte = x.toByte
    def toInt(x: Byte): Int = x.toInt
    def toLong(x: Byte): Long = x.toLong
    def toFloat(x: Byte): Float = x.toFloat
    def toDouble(x: Byte): Double = x.toDouble
  }
  implicit object ByteIsIntegral extends ByteIsIntegral with Ordering.ByteOrdering
  
  trait CharIsIntegral extends Additive.CharIsSubtractive with Multiplicative.CharIsDivisive with Integral[Char] {
    def rem(x: Char, y: Char): Char = (x % y).toChar
    def fromInt(x: Int): Char = x.toChar
    def toInt(x: Char): Int = x.toInt
    def toLong(x: Char): Long = x.toLong
    def toFloat(x: Char): Float = x.toFloat
    def toDouble(x: Char): Double = x.toDouble
  }
  implicit object CharIsIntegral extends CharIsIntegral with Ordering.CharOrdering
  
  trait LongIsIntegral extends Additive.LongIsSubtractive with Multiplicative.LongIsDivisive with Integral[Long] {
    def rem(x: Long, y: Long): Long = x % y
    def fromInt(x: Int): Long = x
    def toInt(x: Long): Int = x.toInt
    def toLong(x: Long): Long = x
    def toFloat(x: Long): Float = x
    def toDouble(x: Long): Double = x
  }
  implicit object LongIsIntegral extends LongIsIntegral with Ordering.LongOrdering
  
  trait FloatIsConflicted extends Additive.FloatIsSubtractive with Multiplicative.FloatIsDivisive with Numeric[Float] {
    def fromInt(x: Int): Float = x
    def toInt(x: Float): Int = x.toInt
    def toLong(x: Float): Long = x.toLong
    def toFloat(x: Float): Float = x
    def toDouble(x: Float): Double = x
  }
  trait FloatIsFractional extends FloatIsConflicted with Fractional[Float] {
  }
  trait FloatAsIfIntegral extends FloatIsConflicted with Integral[Float] {
    override def div(x: Float, y: Float): Float = (BigDecimal(x) / BigDecimal(y)).floatValue
    def rem(x: Float, y: Float): Float = (BigDecimal(x) remainder BigDecimal(y)).floatValue
  }
  implicit object FloatIsFractional extends FloatIsFractional with Ordering.FloatOrdering
  object FloatAsIfIntegral extends FloatAsIfIntegral with Ordering.FloatOrdering {
  }
  
  trait DoubleIsConflicted extends Additive.DoubleIsSubtractive with Multiplicative.DoubleIsDivisive with Numeric[Double] {
    def fromInt(x: Int): Double = x
    def toInt(x: Double): Int = x.toInt
    def toLong(x: Double): Long = x.toLong
    def toFloat(x: Double): Float = x.toFloat
    def toDouble(x: Double): Double = x
  }
  trait DoubleIsFractional extends DoubleIsConflicted with Fractional[Double] {
  }
  trait DoubleAsIfIntegral extends DoubleIsConflicted with Integral[Double] {
    override def div(x: Double, y: Double): Double = (BigDecimal(x) / BigDecimal(y)).doubleValue
    def rem(x: Double, y: Double): Double = (BigDecimal(x) remainder BigDecimal(y)).doubleValue
  }
  
  trait BigDecimalIsConflicted extends Additive.BigDecimalIsSubtractive with Multiplicative.BigDecimalIsDivisive with Numeric[BigDecimal] {
    def fromInt(x: Int): BigDecimal = BigDecimal(x)
    def toInt(x: BigDecimal): Int = x.intValue
    def toLong(x: BigDecimal): Long = x.longValue
    def toFloat(x: BigDecimal): Float = x.floatValue
    def toDouble(x: BigDecimal): Double = x.doubleValue
  }
  
  trait BigDecimalIsFractional extends BigDecimalIsConflicted with Fractional[BigDecimal] {
  }
  trait BigDecimalAsIfIntegral extends BigDecimalIsConflicted with Integral[BigDecimal] {
    def rem(x: BigDecimal, y: BigDecimal): BigDecimal = x remainder y
  }

  // For Double and BigDecimal we offer implicit Fractional objects, but also one
  // which acts like an Integral type, which is useful in NumericRange.
  implicit object BigDecimalIsFractional extends BigDecimalIsFractional with Ordering.BigDecimalOrdering  
  object BigDecimalAsIfIntegral extends BigDecimalAsIfIntegral with Ordering.BigDecimalOrdering
  
  implicit object DoubleIsFractional extends DoubleIsFractional with Ordering.DoubleOrdering
  object DoubleAsIfIntegral extends DoubleAsIfIntegral with Ordering.DoubleOrdering
}

trait Numeric[T] extends Subtractive[T] with Divisive[T] with Ordering[T] {
  
  def abs(x: T): T = if (lt(x, zero)) negate(x) else x
  def signum(x: T): Int =
    if (lt(x, zero)) -1
    else if (gt(x, zero)) 1
    else 0

  def fromInt(x: Int): T
  def toInt(x: T): Int
  def toLong(x: T): Long
  def toFloat(x: T): Float
  def toDouble(x: T): Double
  
  class Ops(lhs: T) {
    def abs(): T = Numeric.this.abs(lhs)
    def signum(): Int = Numeric.this.signum(lhs)
    def toInt(): Int = Numeric.this.toInt(lhs)
    def toLong(): Long = Numeric.this.toLong(lhs)
    def toFloat(): Float = Numeric.this.toFloat(lhs)
    def toDouble(): Double = Numeric.this.toDouble(lhs)    
  }
  implicit def mkNumericOps(lhs: T): Ops = new Ops(lhs)
}
