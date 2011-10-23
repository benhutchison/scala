package scala.math;

object Subtractive {
}
trait Subtractive[T] extends Additive[T] with Ordering[T] {
  def minus(x: T, y: T): T
  def negate(x: T): T
  
  def abs(x: T): T = if (lt(x, zero)) negate(x) else x
  def signum(x: T): Int =
    if (lt(x, zero)) -1
    else if (gt(x, zero)) 1
    else 0
  
  class Ops(lhs: T) {
    def -(rhs: T) = minus(lhs, rhs)
    def unary_-() = negate(lhs)
    def abs(): T = Subtractive.this.abs(lhs)
    def signum(): Int = Subtractive.this.signum(lhs)
  }
  implicit def mkSubtractiveOps(lhs: T): Ops = new Ops(lhs)
}
