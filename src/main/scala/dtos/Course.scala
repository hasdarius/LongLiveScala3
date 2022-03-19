package dtos

import scala.util.Random

case class Course(id: Int, name: String, duration: Int, content: String)

object Course:
  def generateRandomCoursesList(): List[Course] =
    val numberOfCourses: Int = Random.between(2, 5)
    (1 to numberOfCourses)
      .map(i => Course(i, Random.alphanumeric.take(5).toList.mkString, Random.between(100, 5000), ""))
      .toList
  end generateRandomCoursesList
end Course
