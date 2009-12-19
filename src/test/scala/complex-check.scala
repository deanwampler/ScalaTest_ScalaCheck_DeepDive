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

  val zero = Complex(0.0, 0.0)

  // Call out the special case of + and - with (0,0), effectively the
  // identity operation.
  property("addition with (0,0)")    = Prop.forAll { (a: Complex) => 
    (a + zero).real.equals(a.real) &&
    (a + zero).imaginary.equals(a.imaginary)
  }
  property("subtraction with (0,0)") = Prop.forAll { (a: Complex) =>
    (a - zero).real.equals(a.real) &&
    (a - zero).imaginary.equals(a.imaginary)
  }

  property("addition")    = Prop.forAll { (a: Complex, b: Complex) => 
    (a + b).real.equals(a.real + b.real) &&
    (a + b).imaginary.equals(a.imaginary + b.imaginary)
  }
  property("subtraction") = Prop.forAll { (a: Complex, b: Complex) => 
    (a - b).real.equals(a.real - b.real) &&
    (a - b).imaginary.equals(a.imaginary - b.imaginary)
  }
}
