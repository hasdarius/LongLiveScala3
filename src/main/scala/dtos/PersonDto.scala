package dtos

import java.sql.Timestamp
import java.util.UUID
import scala.language.implicitConversions

case class PersonDto(id: Int, firstName: String, lastName: String, age: Int, courseIds: List[Long])

object PersonDto {
  implicit def fromPerson(person: Person): PersonDto = PersonDto(
    person.id,
    person.firstName,
    person.lastName,
    person.age,
    person.coursesEnrolled.map(_.id)
  )

  implicit def toPerson(personDTO: PersonDto): Person = Person(
    personDTO.id,
    personDTO.firstName,
    personDTO.lastName,
    personDTO.age,
    List.empty
  )

  implicit def fromPersonList(persons: List[Person]): List[PersonDto] = persons.map(person => fromPerson(person))

}
