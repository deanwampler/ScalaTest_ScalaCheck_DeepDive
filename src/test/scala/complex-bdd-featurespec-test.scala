// code-examples/ToolsLibs/complex-test.scala

import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers

// FeatureSpec promotes acceptance/feature style testing that has also been
// popularized by BDD as the level of testing above unit tests. The 
// "given/when/then" style is designed to real like a structured form of feature
// requirements that a non-programmer stakeholder could read and understand.
// See the ScalaTest page on FeatureSpec for a nice example of incrementally
// building up such a test, with "pending" steps, etc.
//   http://www.scalatest.org/getting_started_with_feature_spec
// Cucumber and FitNesse are other tools that promote feature/acceptance testing.
 
class ComplexBDDFeatureSpecSuite extends FeatureSpec with GivenWhenThen with ShouldMatchers {

  val c0 = Complex(0.0, 0.0)
  val c1 = Complex(1.2, 3.4)
  val c2 = Complex(5.6, 7.8)

  feature("Complex Numbers") {
    info("As a mathematician")
    info("I want to manipulate Complex numbers algebraically")
    
    scenario("Adding a Complex number with Complex(0,0)") {
      given("An arbitrary Complex number")
      when("I add Complex(0,0) to it")
      then("I should get a new number with same value as the original number")
      // pending  // When you haven't implemented the scenario yet.
      (c1 + c0) should equal (c1)      
    }

    scenario("Subtracting Complex(0,0) from a Complex number") {
      given("An arbitrary Complex number")
      when("I subtract Complex(0,0) from it")
      then("I should get a new number with same value as the original number")
      (c1 - c0) should equal (c1)      
    }

    scenario("Adding two Complex numbers") {
      given("An arbitrary Complex number")
      when("I add another arbitrary Complex number to it")
      then("I should get a new number with real and imag. parts added")
      (c1 + c2).real      should equal (c1.real      + c2.real);
      (c1 + c2).imaginary should equal (c1.imaginary + c2.imaginary)
    }

    scenario("Subtracting two Complex numbers") {
      given("An arbitrary Complex number")
      when("I subtract another arbitrary Complex number from it")
      then("I should get a new number with real and imag. parts subtracted")
      (c1 - c2).real      should equal (c1.real      - c2.real);
      (c1 - c2).imaginary should equal (c1.imaginary - c2.imaginary)
    }
  }
}
