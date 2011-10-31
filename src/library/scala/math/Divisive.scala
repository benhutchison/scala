package scala.math;

object Divisive {
}

trait Divisive[T] extends Multiplicative[T] {
  def div(x: T, y: T): T
  
  class Ops(lhs: T) {
    def /(rhs: T) = Divisive.this.div(lhs, rhs)
  }
  implicit def mkDivisiveOps(lhs: T): Ops = new Ops(lhs)
}
