package com.ismirnov.homework1

import org.scalatest._

class StudentSpec extends UnitSpec {
     "A Student" should "give correct info about himself" in {
	    val student = Student("Vladislav Zaharovich Skorobogatko", 100500, 2)
	    student.getInfo() should be ("My name is Vladislav Zaharovich Skorobogatko, I'm 100500 years old. And I'm a student of 2 course.")
  	}

    "A Student" should "study Scala if he is in a good mood" in {
	    val student = Student("Vladislav Zaharovich Skorobogatko", 100500)
	    student.study(mood=true) should be ("My boss has increased my salary, I'm in good mood. I will learn Scala.")
  	}

    "A Student" should "not study Scala if he is in a bad mood" in {
	    val student = Student("Vladislav Zaharovich Skorobogatko", 100500)
	    student.study(false) should be ("My girlfriend has left me. I'm upset, I'll not learn Scala.")
  	}
}