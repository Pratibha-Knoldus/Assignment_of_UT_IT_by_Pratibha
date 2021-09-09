package interface

import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

class Test_Traits_class extends AsyncFlatSpec{
  val MockedTraits: Traits_method = mock[Traits_method]
  val trait_Impl = new Traits_impl()

  // Unit Test Cases to check given number is palindrome or not

  "Number = 162261 " should "palindrome " in {
    when(MockedTraits.palindrome(162261)) thenReturn true
    val result = trait_Impl.CheckPalindrome(162261)
    assert(result == "yes")
  }

  "Number = 12721 " should "palindrome " in {
    when(MockedTraits.palindrome(12721)) thenReturn true
    val result = trait_Impl.CheckPalindrome(12721)
    assert(result == "yes")
  }

  "Number = 16336 " should "not a palindrome " in {
    when(MockedTraits.palindrome(16336)) thenReturn false
    val result = trait_Impl.CheckPalindrome(16336)
    assert(result == "no")
  }

  "Number = 693353 " should "not a palindrome " in {
    when(MockedTraits.palindrome(693353)) thenReturn false
    val result = trait_Impl.CheckPalindrome(693353)
    assert(result == "no")
  }

  // Unit Test Cases to get the factorial of given number

  "Factorial of 5" should " be 120 " in {
    when(MockedTraits.factorial(5)) thenReturn 120
    val result = trait_Impl.getFactorial(5)
    assert(result == 120)
  }

  "Factorial of 8" should " be 40320 " in {
    when(MockedTraits.factorial(8)) thenReturn 40320
    val result = trait_Impl.getFactorial(8)
    assert(result == 40320)
  }



}
