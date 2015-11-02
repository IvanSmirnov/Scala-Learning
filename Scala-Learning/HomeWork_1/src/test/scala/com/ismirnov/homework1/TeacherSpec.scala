package com.ismirnov.homework1

import org.scalatest._

class TeacherSpec extends UnitSpec {
    "A Teacher" should "be able to set academic degree" in {
	    val teacher = new Teacher("Julia Roberts", 48)
	    teacher.setNewAcademicDegree("PhD")
	    teacher.academicDegree should be ("PhD")
  	}

     "A Teacher" should "give correct info about himself" in {
	    val teacher = new Teacher("Julia Roberts", 48)
	    teacher.setNewAcademicDegree("PhD")
	    teacher.getInfo() should be ("My name is Julia Roberts, I'm 48 years old. And I'm a teacher with PhD degree.")
  	}

    "A Teacher" should "teach the student if he is not druk" in {
	    val teacher = new Teacher("Julia Roberts", 48)
	    teacher.teach(Condition("student is not drunk")) should be ("I will teach this student")
  	}

    "A Teacher" should "not teach the student if he is druk" in {
	    val teacher = new Teacher("Julia Roberts", 48)
	    teacher.teach(Condition("student is drunk")) should be ("I will not teach this student")
  	}
}