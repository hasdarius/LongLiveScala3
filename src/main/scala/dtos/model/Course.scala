package dtos.model

import dtos.model.Course

import scala.util.Random

case class Course(val id: Int, val name: String, val duration: Int, val content: String)

object Course:
  def generateRandomCoursesList(): List[Course] =
    val numberOfCourses: Int = Random.between(2, 5)
    (1 to numberOfCourses)
      .map(i => Course(i, Random.alphanumeric.take(5).toList.mkString, Random.between(100, 5000), ""))
      .toList
  end generateRandomCoursesList
end Course
