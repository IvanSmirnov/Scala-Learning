package com.ismirnov.homework1

object HomeWork1App
{
	def main(args : Array[String])=
	{
		val teacher = new Teacher("Julia Roberts", 48)
		teacher.setNewAcademicDegree("PhD")
		println(teacher.getInfo())
		println(teacher.teach(Condition("student is not drunk")))

		val student = Student("Dmitry", 26, 2)
		println(student.getInfo())
		println(student.study(true))
	}

}