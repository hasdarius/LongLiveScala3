package dtos

import java.util.UUID
import scala.language.implicitConversions

case class PersonDTO(id: Int, firstName: String, lastName: String, courseIds: List[Long])

object PersonDTO{
  implicit def fromPerson(person: Person): PersonDTO = PersonDTO(
    person.id,
    person.firstName,
    person.lastName,
    person.coursesEnrolled.map(_.id)
  )

  implicit def toPerson(personDTO: PersonDTO): Person = Person(
    personDTO.id,
    personDTO.firstName,
    personDTO.lastName,
    List.empty
  )

  implicit def fromPersonList(persons: List[Person]): List[PersonDTO] = persons.map(person => fromPerson(person))

}
