// code-examples/ToolsLibs/complex-test.scala

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

// The Spec trait syntax is inspired by Ruby's RSpec.
// See http://www.scalatest.org/getting_started_with_bdd

class ComplexBDDSpecSuite extends Spec with ShouldMatchers {

  val c0 = Complex(0.0, 0.0)
  val c1 = Complex(1.2, 3.4)
  val c2 = Complex(5.6, 7.8)

  describe("Complex Number") {
    describe("addition") {
      describe("with Complex(0,0)") {
        it("return a new number with the original value") {
          (c1 + c0) should equal (c1)
        }
      }
      describe("with another Complex number") {
        it("should return a new number that sums the real and imag. parts") {
          (c1 + c2).real      should equal (c1.real      + c2.real);
          (c1 + c2).imaginary should equal (c1.imaginary + c2.imaginary)
        }
      }
    }

    describe("subtraction") {
      describe("with Complex(0,0)") {
        it("return a new number with the original value") {
          (c1 - c0) should equal (c1)
        }
      }
      describe("with another Complex number") {
        it("should return a new number with the difference of the real and imag. parts") {
          (c1 - c2).real      should equal (c1.real      - c2.real);
          (c1 - c2).imaginary should equal (c1.imaginary - c2.imaginary)
        }
      }
    }
  }
}
