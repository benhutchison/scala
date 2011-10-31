package scala.math;

object Additive {
  trait BigIntIsSubtractive extends Subtractive[BigInt] {
    def plus(x: BigInt, y: BigInt): BigInt = x + y
    def minus(x: BigInt, y: BigInt): BigInt = x - y
    def negate(x: BigInt): BigInt = -x
    def zero = BigInt(0)    
  }
  implicit object BigIntIsSubtractive extends BigIntIsSubtractive with Ordering.BigIntOrdering 
  
  trait IntIsSubtractive extends Subtractive[Int] {
    def plus(x: Int, y: Int): Int = x + y
    def minus(x: Int, y: Int): Int = x - y
    def negate(x: Int): Int = -x
    def zero = 0  
  }
  implicit object IntIsSubtractive extends IntIsSubtractive with Ordering.IntOrdering 
  
  trait ShortIsSubtractive extends Subtractive[Short] {
    def plus(x: Short, y: Short): Short = (x + y).toShort
    def minus(x: Short, y: Short): Short = (x - y).toShort
    def negate(x: Short): Short = (-x).toShort
    def zero = 0.toShort  
  }
  implicit object ShortIsSubtractive extends ShortIsSubtractive with Ordering.ShortOrdering

  trait ByteIsSubtractive extends Subtractive[Byte] {
    def plus(x: Byte, y: Byte): Byte = (x + y).toByte
    def minus(x: Byte, y: Byte): Byte = (x - y).toByte
    def negate(x: Byte): Byte = (-x).toByte  
    def zero = 0.toByte  
  }
  implicit object ByteIsSubtractive extends ByteIsSubtractive with Ordering.ByteOrdering
  
  trait CharIsSubtractive extends Subtractive[Char] {
    def plus(x: Char, y: Char): Char = (x + y).toChar
    def minus(x: Char, y: Char): Char = (x - y).toChar
     def negate(x: Char): Char = (-x).toChar  
    def zero = 0.toChar  
  }
  implicit object CharIsSubtractive extends CharIsSubtractive with Ordering.CharOrdering
  
  trait LongIsSubtractive extends Subtractive[Long] {
    def plus(x: Long, y: Long): Long = x + y
    def minus(x: Long, y: Long): Long = x - y
    def negate(x: Long): Long = -x
    def zero = 0L  
  }
  implicit object LongIsSubtractive extends LongIsSubtractive with Ordering.LongOrdering
  
  trait FloatIsSubtractive extends Subtractive[Float] {
    def plus(x: Float, y: Float): Float = x + y
    def minus(x: Float, y: Float): Float = x - y
    def negate(x: Float): Float = -x
    def zero = 0f  
  }
  implicit object FloatIsSubtractive extends FloatIsSubtractive with Ordering.FloatOrdering
  
  trait DoubleIsSubtractive extends Subtractive[Double] {
    def plus(x: Double, y: Double): Double = x + y
    def minus(x: Double, y: Double): Double = x - y
    def negate(x: Double): Double = -x
    def zero = 0d  
  }
  implicit object DoubleIsSubtractive extends DoubleIsSubtractive with Ordering.DoubleOrdering 
  
  trait BigDecimalIsSubtractive extends Subtractive[BigDecimal] {
    def plus(x: BigDecimal, y: BigDecimal): BigDecimal = x + y
    def minus(x: BigDecimal, y: BigDecimal): BigDecimal = x - y
    def negate(x: BigDecimal): BigDecimal = -x
    def zero = java.math.BigDecimal.ZERO
  }
  implicit object BigDecimalIsSubtractive extends BigDecimalIsSubtractive  with Ordering.BigDecimalOrdering
}
trait Additive[T] {
  def plus(x: T, y: T): T
  def zero: T
  
  class Ops(lhs: T) {
    def +(rhs: T) = Additive.this.plus(lhs, rhs)
  }
  implicit def mkAdditiveOps(lhs: T): Ops = new Ops(lhs)
}
