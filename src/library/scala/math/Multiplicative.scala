package scala.math;

object Multiplicative {
  trait BigIntMultiplicative extends Multiplicative[BigInt] {
    def times(x: BigInt, y: BigInt): BigInt = x * y
    def one = BigInt(1)    
  }
  implicit object BigIntIsMultiplicative extends BigIntMultiplicative
  
  trait IntMultiplicative extends Multiplicative[Int] {
    def times(x: Int, y: Int): Int = x * y
    def one = 1    
  }
  implicit object IntIsMultiplicative extends IntMultiplicative
  
  trait ShortMultiplicative extends Multiplicative[Short] {
    def times(x: Short, y: Short): Short = (x * y).toShort
    def one = 1.toShort    
  }
  implicit object ShortIsMultiplicative extends ShortMultiplicative
  
  trait ByteMultiplicative extends Multiplicative[Byte] {
    def times(x: Byte, y: Byte): Byte = (x * y).toByte
    def one = 1.toByte    
  }
  implicit object ByteIsMultiplicative extends ByteMultiplicative
  
  trait CharMultiplicative extends Multiplicative[Char] {
    def times(x: Char, y: Char): Char = (x * y).toChar
    def one = 1.toChar    
  }
  implicit object CharIsMultiplicative extends CharMultiplicative
  
  trait LongMultiplicative extends Multiplicative[Long] {
    def times(x: Long, y: Long): Long = x * y
    def one = 1L   
  }
  implicit object LongIsMultiplicative extends LongMultiplicative
  
  trait FloatMultiplicative extends Multiplicative[Float] {
    def times(x: Float, y: Float): Float = x * y
    def one = 1f    
  }
  implicit object FloatIsMultiplicative extends FloatMultiplicative
  
  trait DoubleMultiplicative extends Multiplicative[Double] {
    def times(x: Double, y: Double): Double = x * y
    def one = 1d    
  }
  implicit object DoubleIsMultiplicative extends DoubleMultiplicative
  
  trait BigDecimalMultiplicative extends Multiplicative[BigDecimal] {
    def times(x: BigDecimal, y: BigDecimal): BigDecimal = x * y
    def one = java.math.BigDecimal.ONE    
  }
  implicit object BigDecimalIsMultiplicative extends BigDecimalMultiplicative
}

trait Multiplicative[T] {
  def times(x: T, y: T): T
  def one: T
  
  class Ops(lhs: T) {
    def *(rhs: T) = Multiplicative.this.times(lhs, rhs)
  }
  implicit def mkMultiplicativeOps(lhs: T): Ops = new Ops(lhs)
}
