package scala.math;

object Subtractive {
}
trait Subtractive[T] extends Additive[T] {
  def minus(x: T, y: T): T
  def negate(x: T): T
  
  class Ops(lhs: T) {
    def -(rhs: T) = minus(lhs, rhs)
    def unary_-() = negate(lhs)
  }
  implicit def mkSubtractiveOps(lhs: T): Ops = new Ops(lhs)
}
