package scala.math;

object Multiplicative {
  trait BigIntIsDivisive extends Divisive[BigInt] {
    def times(x: BigInt, y: BigInt): BigInt = x * y
    def div(x: BigInt, y: BigInt): BigInt = x / y
    def one = BigInt(1)    
  }
  implicit object BigIntIsDivisive extends BigIntIsDivisive
  
  trait IntIsDivisive extends Divisive[Int] {
    def times(x: Int, y: Int): Int = x * y
    def div(x: Int, y: Int): Int = x / y
    def one = 1    
  }
  implicit object IntIsDivisive extends IntIsDivisive
  
  trait ShortIsDivisive extends Divisive[Short] {
    def times(x: Short, y: Short): Short = (x * y).toShort
    def div(x: Short, y: Short): Short = (x / y).toShort
    def one = 1.toShort    
  }
  implicit object ShortIsDivisive extends ShortIsDivisive
  
  trait ByteIsDivisive extends Divisive[Byte] {
    def times(x: Byte, y: Byte): Byte = (x * y).toByte
    def div(x: Byte, y: Byte): Byte = (x / y).toByte
    def one = 1.toByte    
  }
  implicit object ByteIsDivisive extends ByteIsDivisive
  
  trait CharIsDivisive extends Divisive[Char] {
    def times(x: Char, y: Char): Char = (x * y).toChar
    def div(x: Char, y: Char): Char = (x / y).toChar
    def one = 1.toChar    
  }
  implicit object CharIsDivisive extends CharIsDivisive
  
  trait LongIsDivisive extends Divisive[Long] {
    def times(x: Long, y: Long): Long = x * y
    def div(x: Long, y: Long): Long = x / y
    def one = 1L   
  }
  implicit object LongIsDivisive extends LongIsDivisive
  
  trait FloatIsDivisive extends Divisive[Float] {
    def times(x: Float, y: Float): Float = x * y
    def div(x: Float, y: Float): Float = x / y
    def one = 1f    
  }
  implicit object FloatIsDivisive extends FloatIsDivisive
  
  trait DoubleIsDivisive extends Divisive[Double] {
    def times(x: Double, y: Double): Double = x * y
    def div(x: Double, y: Double): Double = x / y
    def one = 1d    
  }
  implicit object DoubleIsDivisive extends DoubleIsDivisive
  
  trait BigDecimalIsDivisive extends Divisive[BigDecimal] {
    def times(x: BigDecimal, y: BigDecimal): BigDecimal = x * y
    def div(x: BigDecimal, y: BigDecimal): BigDecimal = x / y
    def one = java.math.BigDecimal.ONE    
  }
  implicit object BigDecimalIsDivisive extends BigDecimalIsDivisive
}

trait Multiplicative[T] {
  def times(x: T, y: T): T
  def one: T
  
  class Ops(lhs: T) {
    def *(rhs: T) = Multiplicative.this.times(lhs, rhs)
  }
  implicit def mkMultiplicativeOps(lhs: T): Ops = new Ops(lhs)
}
