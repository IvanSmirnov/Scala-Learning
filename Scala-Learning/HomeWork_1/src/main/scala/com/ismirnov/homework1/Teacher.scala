package com.ismirnov.homework1

class Teacher(name: String, age: Integer) extends Person (name, age) with ScienceWork{
	var academicDegree = ""

	def setNewAcademicDegree(degree: String): String = {
		academicDegree = degree
		this.academicDegree
	}

	def teach(condition: Condition): String = {
		condition match {
			case Condition("student is drunk") => "I will not teach this student" 
			case Condition("student is not drunk") => "I will teach this student"
			case _ => "Condition is not specified"
		}
	}

	def getInfo() : String = {
		"My name is "+name+", I'm "+age+" years old. And I'm a teacher with "+academicDegree+" degree.";
	}
}