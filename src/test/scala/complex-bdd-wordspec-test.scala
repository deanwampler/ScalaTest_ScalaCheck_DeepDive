// code-examples/ToolsLibs/complex-test.scala

import org.scalatest.WordSpec
import org.scalatest.matchers.ShouldMatchers

// The WordSpec style is inspired by the "specs" syntax, a BDD-specific
// Scala testing tools.
// See http://www.scalatest.org/getting_started_with_bdd

class ComplexBDDWordSuite extends WordSpec with ShouldMatchers {

  val c0 = Complex(0.0, 0.0)
  val c1 = Complex(1.2, 3.4)
  val c2 = Complex(5.6, 7.8)

  "Complex Numbers" when {
    "added to Complex(0,0)" should {
      "return a new number with the original value" in {
        (c1 + c0) should equal (c1)
      }
    }
    "Complex(0,0) is subtracted from them" should {
      "return a new number with the original value" in {
        (c1 - c0) should equal (c1)
      }
    }
    "added with another Complex number" should {
      "should return a new number that sums the real and imag. parts" in {
        (c1 + c2).real      should equal (c1.real      + c2.real);
        (c1 + c2).imaginary should equal (c1.imaginary + c2.imaginary)
      }
    }
    "subtracted with another Complex number" should {
      "should return a new number that sums the real and imag. parts" in {
        (c1 + c2).real      should equal (c1.real      + c2.real);
        (c1 + c2).imaginary should equal (c1.imaginary + c2.imaginary)
      }
    }
  }
}
