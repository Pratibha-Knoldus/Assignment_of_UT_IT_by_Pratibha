package com.knoldus.validator.integration_testing

import com.knoldus.validator.EmailValidator
import org.scalatest.funsuite.AnyFunSuite

class IT_Test_EmailValidator extends AnyFunSuite{
  val emailValidator = new EmailValidator

//Integration testing where EmailValidator function is tested by given values

  // Whereas I only use those 4 condition which are given in Group1's question 1 to validate the email ID.

  //Correct email "pratibhayadav@gmail.com"
  test("pratibhayadav@gmail.com valid"){
    assert(emailValidator.emailIdIsValid("pratibhayadav@gmail.com"))
  }

  //Wrong email "pratibhayadavgmail.com" because it does not contain "@"
  test("pratibhayadavgmail.com not valid"){
    assert(!emailValidator.emailIdIsValid("pratibhayadavgmail.com"))
  }

  //Wrong email "pratibhayadav@gmail.col" because it does not contain ".com/.net/.org"
  test("pratibhayadav@gmail.col not valid"){
    assert(!emailValidator.emailIdIsValid("pratibhayadav@gmail.col"))
  }

  //Wrong email "pratibha yadav@gmail.com" because it contains " "
  test("pratibha yadav@gmail.com not valid"){
    assert(!emailValidator.emailIdIsValid("pratibha yadav@gmail.com"))
  }

  //Right email "pratibha14yadav@gmail.com" because it contains "14"
  test("pratibha14yadav@gmail.com not valid"){
    assert(emailValidator.emailIdIsValid("pratibha14yadav@gmail.com"))
  }

}
