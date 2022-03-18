package classExtensions

import dtos.Person

object ObjectExtensions:
  extension (string: String) {
    def toSnakeCase = string.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase
    def isEmail = string.matches("""^[a-zA-Z0-9\.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$""".r.toString)
    def isNumber = string.matches("([1-9])([0-9]*)")
    def protectedToInt = if string.isNumber then Some(string.toInt) else None
  }

  extension (person: Person) {
    def isScalaSpecialist = person.coursesEnrolled.filter(_.name.toLowerCase.contains("scala")).length > 5
  }

  extension (f: Int => Int) {
    def derivative(dx: Int): Int => Int =
      ((x: Int) => (f(x + dx) - f(x)) / dx)
  }

  // Scala2 syntax equivalent
  /* 
  implicit class StringExtension(string: String){
    def toSnakeCase = string.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase
  } */
end ObjectExtensions
