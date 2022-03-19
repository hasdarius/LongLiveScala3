package optionals

import classExtensions.ObjectExtensions.*
import dtos.{Person, PersonDto}

import java.util.NoSuchElementException
import scala.util.Random

object OptionPlayground extends App :

  val someInt: Option[Int] = Some(17)
  val noInt: Option[Int] = None

  val stringList = List("0", "1", "12", "7", "42", "number", "2o1")

  val intList = stringList.map(_.protectedToInt)
  println(intList)
  println(intList.flatten)

  val newPerson = Person(1, "New", "Person", 18, List.empty)
  var result = PersonRepository.getPersonById(newPerson.id).orElse(PersonRepository.addNewPerson(newPerson)) // chained calls using Option

  result match {
    case Some(number: Int) => println(s"Person with id ${number} has been created.")
    case Some(person: Person) => println(s"Person ${person} has been retrieved from repository.")
    case _ => println(s"Person does not exist, but was unable to create it.")
  }

  result = PersonRepository.getPersonById(newPerson.id).orElse(PersonRepository.addNewPerson(newPerson)) // chained calls using Option
  result match {
    case Some(number: Int) => println(s"Person with id ${number} has been created.")
    case Some(person: Person) => println(s"Person ${person} has been retrieved from repository.")
    case _ => println(s"Person does not exist, but was unable to create it.")
  }
  println(PersonRepository.getPersons)

  // Either from Option
  println("------------EITHER-----------")
  val anotherPerson = Person(17, "New", "Person", 21, List.empty)
  var optionPerson = PersonRepository.getPersonById(anotherPerson.id)
  var eitherPersonExistsOrMethodToAddPerson = Either.cond(optionPerson.isDefined, optionPerson.get, PersonRepository.addNewPerson) // hold reference to save method
  eitherPersonExistsOrMethodToAddPerson match {
    case Left(value) => println(s"Adding a new person: ${value(anotherPerson)}")
    case Right(value) => println(s"Printing existing person: ${value}")
  }

  // what if we want to do this one more time at a later time
  optionPerson = PersonRepository.getPersonById(anotherPerson.id)
  eitherPersonExistsOrMethodToAddPerson = Either.cond(optionPerson.isDefined, optionPerson.get, PersonRepository.addNewPerson)
  eitherPersonExistsOrMethodToAddPerson match {
    case Left(value) => println(s"Adding a new person: ${value(anotherPerson)}")
    case Right(value) => println(s"Printing existing person: ${value}")
  }
end OptionPlayground