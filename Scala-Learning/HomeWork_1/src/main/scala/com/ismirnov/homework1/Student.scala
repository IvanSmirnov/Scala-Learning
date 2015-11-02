package com.ismirnov.homework1

class Student(name: String, age: Integer) extends Person (name, age){
	var course: Integer = 0
	var isRecovered: Boolean = false

	def getInfo() : String = {
		var info = "My name is "+name+", I'm "+age+" years old. And I'm a student of "+course+" course."
		if(isRecovered) {
			info = info + " I'm recovered."
		}
		info
	}

	def study(mood: Boolean): String = {
		if(mood) "My boss has increased my salary, I'm in good mood. I will learn Scala."
			else "My girlfriend has left me. I'm upset, I'll not learn Scala."
	}
}

object Student {
	def apply(name: String, age: Integer)= new Student(name, age)
	def apply(name: String, age: Integer, course: Integer) = {
		val student = new Student(name, age)
		student.course = course
		student
	}
	def apply(name: String, age: Integer, isRecovered: Boolean)= {
		val student = new Student(name, age)
		student.isRecovered = isRecovered
		student
	}
}