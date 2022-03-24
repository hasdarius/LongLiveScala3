package favouriteFeatures.typeClasses.comparable

import dtos.model.Person
import interfaces.model.File

trait MyComparable[A] :
  def compareElements(firstElement: A, secondElement: A) : Int
end MyComparable


implicit object PersonAgeComparable extends MyComparable[Person]:
  def compareElements(firstElement: Person, secondElement: Person) : Int = firstElement.age.compareTo(secondElement.age)

implicit object StringLengthComparable extends MyComparable[String]:
  def compareElements(firstString: String, secondString: String) : Int = firstString.length.compareTo(secondString.length)

implicit object StringAlphanumericComparable extends MyComparable[String]:
  def compareElements(firstString: String, secondString: String) : Int = firstString.compareTo(secondString)

implicit object FileLengthComparable extends MyComparable[File]:
  def compareElements(firstFile: File, secondFile: File) : Int = firstFile.content.length.compareTo(secondFile.content.length)