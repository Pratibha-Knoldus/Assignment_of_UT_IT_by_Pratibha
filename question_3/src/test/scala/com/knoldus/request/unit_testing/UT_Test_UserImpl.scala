package com.knoldus.request.unit_testing

import com.knoldus.models.User
import com.knoldus.request.UserImpl
import com.knoldus.validator.UserValidator
import org.mockito.Mockito.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

class UT_Test_UserImpl extends AsyncFlatSpec{
  val MockedUserValidator:UserValidator = mock(classOf[UserValidator])
  val userImpl = new UserImpl(MockedUserValidator)

  "User Suresh" should "not be Created due to used UserName" in {
    val user = User("Suresh","Kumar",23,50000,"Engineer","Knoldus","sureshkumar@gmail.com")
    when(MockedUserValidator.isUserValid(user)) thenReturn false
    val isUserCreated = userImpl.createUser(user)
    println()
    assert(!isUserCreated.contains(user.emailId))
  }

  "User Pratibha" should "be Valid due all correct fields" in {
    val user = User("Pratibha","Yadav",23,50000,"Engineer","Knoldus","pratibhayadav@gmail.com")
    when(MockedUserValidator.isUserValid(user)) thenReturn true
    val isUserCreated = userImpl.createUser(user)
    println()
    assert(isUserCreated.contains(user.emailId))
  }

  "User Kannu" should "be Valid due to all correct fields" in {
    val user = User("Kannu","Yadav",23,50000,"Engineer","Knoldus","kannuyadav@gmail.com")
    when(MockedUserValidator.isUserValid(user)) thenReturn true
    val isUserCreated = userImpl.createUser(user)
    println()
    assert(isUserCreated.contains(user.emailId))
  }

  "User Shubham" should "not be Valid due to wrong Company name" in {
    val user = User("Shubham","Yadav",21,50000,"Engineer","Google","Pratibhayadav@gmail.com")
    when(MockedUserValidator.isUserValid(user)) thenReturn false
    val isUserCreated = userImpl.createUser(user)
    println()
    assert(!isUserCreated.contains(user.emailId))
  }

  "User Rahul" should "not be Valid wrong pattern of emailId" in {
    val user = User("Rahul","Yadav",21,50000,"Engineer","Knoldus","rahul yadav@gmail.com")
    when(MockedUserValidator.isUserValid(user)) thenReturn false
    val isUserCreated = userImpl.createUser(user)
    println()
    assert(!isUserCreated.contains(user.emailId))
  }


}
