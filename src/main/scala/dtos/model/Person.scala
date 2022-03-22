package dtos.model

import dtos.model.{Course, Person}

import scala.util.Random

case class Person(id: Int, firstName: String, lastName: String, age: Int, coursesEnrolled: List[Course])

object Person:
  def generateTenRandomPersons(): List[Person] =
    (1 to 10)
      .map(i => Person(i, Random.alphanumeric.take(5).toList.mkString, Random.alphanumeric.take(5).toList.mkString, Random.between(18, 99), Course.generateRandomCoursesList()))
      .toList
  end generateTenRandomPersons
end Person

