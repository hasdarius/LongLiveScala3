package dtos

import dtos.dto.PersonDto
import dtos.model.{Course, Person, NormalPerson}

object DtoPlayground extends App {


  // tour of case classes
  val person = Person(1, "Darius", "Has", 21, List(Course(1, "Scala Basics", 30, "")))
  val normalPerson = NormalPerson(1, "Darius", "Has", 21, List.empty)
  // Why?
  // case classes (and starting from Scala 3, simple classes also) have an apply method for instantiation:
  // def apply(id: Int, firstName: String, lastName: String, properties: List[Course]): Person = new Person(id: UUID, firstName: String, lastName: String, properties: List[Course])
  // toString()
  println(s"Case class person: $person")
  println(s"Normal class person: $normalPerson")

  //copy() and equals()
  val samePerson = person.copy()
  println(samePerson)
  println(samePerson == person) // == vs .equals


  // DTO conversion
  val personDTO: PersonDto = person
  println(personDTO)


}