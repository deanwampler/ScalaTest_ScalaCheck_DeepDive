import org.scalacheck._
import org.scalacheck.Prop._

// ScalaCheck emphasizes defining the properties of types and verifying that
// those properties are true over a representative range of values.
// ScalaCheck is a port of Haskell's QuickCheck.

object ComplexSpecification extends Properties("Complex") {
  def toD(i: Int) = i * .1

  implicit def arbitraryComplex: Arbitrary[Complex] = Arbitrary {
    Gen.sized {s => 
      for {
        r <- Gen.choose(-toD(s), toD(s))
        i <- Gen.choose(-toD(s), toD(s))
      } yield Complex(r, i)
    }
  }

  def additionTest(a: Complex, b: Complex) = 
    (a + b).real.equals(a.real + b.real) &&
    (a + b).imaginary.equals(a.imaginary + b.imaginary)

  def subtractionTest(a: Complex, b: Complex) = 
    (a - b).real.equals(a.real - b.real) &&
    (a - b).imaginary.equals(a.imaginary - b.imaginary)

  val zero = Complex(0.0, 0.0)
  
  specify("addition with (0,0)", (a: Complex)  => additionTest(a, zero))
  specify("subtraction with (0,0)", (a: Complex)  => subtractionTest(a, zero))

  specify("addition", (a: Complex, b: Complex) => additionTest(a,b))
  specify("subtraction", (a: Complex, b: Complex) => subtractionTest(a,b))
}
//ComplexSpecification.check