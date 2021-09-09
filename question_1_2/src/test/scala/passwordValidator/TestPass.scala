package passwordValidator
import passwordValidation.{PassValidator,CheckPassword}
import org.mockito.Mockito.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

class TestPass extends AsyncFlatSpec{
  val MockedValidation: PassValidator = mock(classOf[PassValidator])
  val password = new CheckPassword(MockedValidation)

  // Unit Test Cases for Password Validation

  "Password with every condition" should "be Valid" in {
    when(MockedValidation.isValid("P@ar1234")) thenReturn true
    val result = password.getPass("Y@P@ar1234")
    assert(result == "yes")
  }

  "Password with blank space" should "be invalid" in {
    when(MockedValidation.isValid("P@rt 1234")) thenReturn false
    val result = password.getPass("P@rt 1234")
    assert(result == "no")
  }

  "Password without special symbol" should "be invalid" in {
    when(MockedValidation.isValid("prati1234")) thenReturn false
    val result = password.getPass("prati1234")
    assert(result == "no")
  }

  "Password without a single small letter" should "be invalid" in {
    when(MockedValidation.isValid("P@RT1234")) thenReturn false
    val result1 = password.getPass("Y@P@RT1234")
    assert(result1 == "no")
  }

  "Password without Capital letter" should "be invalid" in {
    when(MockedValidation.isValid("p@rt1234")) thenReturn false
    val result1 = password.getPass("p@rt1234")
    assert(result1 == "no")
  }

  "Password length less then 8 letters" should "be invalid" in {
    when(MockedValidation.isValid("P@rt123")) thenReturn false
    val result1 = password.getPass("P@rt123")
    assert(result1 == "no")
  }

  "Password length more then 15 letters" should "be invalid" in {
    when(MockedValidation.isValid("P@rtttibhaaa1234569874")) thenReturn false
    val result1 = password.getPass("P@rtttibhaaa1234569874")
    assert(result1 == "no")
  }
  "Password" should "be Valid" in {
    when(MockedValidation.isValid("P@rt12345")) thenReturn true
    val result = password.getPass("P@rt12345")
    assert(result == "yes")
  }
}
