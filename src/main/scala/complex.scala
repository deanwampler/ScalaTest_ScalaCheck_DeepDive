// A class for Complex Numbers, which are two-dimensional numbers, representing
// the real and imaginary (complex) plain.
// Here are the rules for + and -, where c1 = (r1,i1) and c2 = (r2,i2):
//   c1 + c2    (r1 + r2, i1 + i2)
//   c1 - c2    (r1 - r2, i1 - i2)

case class Complex(real: Double, imaginary: Double) {
  def +(that: Complex) = 
    new Complex(real + that.real, imaginary + that.imaginary)
  def -(that: Complex) = 
    new Complex(real - that.real, imaginary - that.imaginary)
}
