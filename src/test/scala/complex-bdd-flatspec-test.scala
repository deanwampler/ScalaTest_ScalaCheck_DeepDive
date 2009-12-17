// code-examples/ToolsLibs/complex-test.scala

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

// FlatSpec promotes a "flatter" syntax (meaning less nesting) compared to
// the other BDD-oriented forms.
// See http://www.scalatest.org/getting_started_with_bdd

class ComplexBDDFlatSpecSuite extends FlatSpec with ShouldMatchers {

  val c0 = Complex(0.0, 0.0)
  val c1 = Complex(1.2, 3.4)
  val c2 = Complex(5.6, 7.8)

  "Addition of a Complex number with (0,0)" should 
      "return a new number with the original value" in {
    (c1 + c0) should equal (c1)
  }

  "Subtraction of (0,0) from a Complex number" should 
      "return a new number with the original value" in {
    (c1 - c0) should equal (c1)
  }

  // Helpful hint: DON'T forget the "in" before the opening "{"!
  it should "Add two Complex numbers together and return a new number" in {
    (c1 + c2).real      should equal (c1.real      + c2.real);
    (c1 + c2).imaginary should equal (c1.imaginary + c2.imaginary)
  }

  it should "Subtract two Complex numbers and return a new number" in {
    (c1 - c2).real      should equal (c1.real      - c2.real);
    (c1 - c2).imaginary should equal (c1.imaginary - c2.imaginary)
  }
}
