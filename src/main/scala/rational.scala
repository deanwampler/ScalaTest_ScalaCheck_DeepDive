// A class for Rational Numbers, which represent division of one integer
// by another symbolically, rather than computing the actual floating point 
// value, with the potential loss of precision.
// For example, 22/7 would be the value "new Rational(22,7)", rather than
// 3.142857142857143. (I picked this example because 22/7 is famously close to
// the value of Pi.) Here, 22 is the numerator and 7 is the denominator.
// Here are the rules for +, -, *, /, where r1 = n1/d1 and r2 = n2/d2:
//   r1 + r2    (n1*d2 + n2*d1)/(d1*d2)
//   r1 - r2    (n1*d2 - n2*d1)/(d1*d2)
//   r1 * r2    (n1*n2)/(d1*d2)
//   r1 / r2    (n1*d2)/(d1*n2)

case class Rational(val numerator: Int, val denominator: Int) {
  def + (r2: Rational) = 
    new Rational(numerator * r2.denominator + r2.numerator * denominator, 
                 denominator * r2.denominator)

  def - (r2: Rational) = 
    new Rational(numerator * r2.denominator - r2.numerator * denominator, 
                 denominator * r2.denominator)

  def * (r2: Rational) = 
    new Rational(numerator * r2.numerator, denominator * r2.denominator)

  def / (r2: Rational) = 
    new Rational(numerator * r2.denominator, denominator * r2.numerator)
                 
  override def toString = numerator + "/" + denominator
}
