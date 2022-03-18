package optionals

import dtos.{Person, PersonDto}

import scala.util.Random

protected case object PersonRepository:

  private var personList: List[Person] = List.empty

  def getPersonById(id: Int): Option[Person] = personList.filter(_.id == id).headOption

  def addNewPerson(person: Person): Option[Int] =
    if personList contains person then
      None
    else
      personList = person :: personList
      Some(person.id)
  end addNewPerson

  def deleteById(id: Int): Unit = personList = personList.filter(_.id != id)

  def updatePerson(person: Person, oldPerson: Person): Option[Int] =
    if personList contains oldPerson then
      val id = person.id
      val newPerson = Person(id, person.firstName, person.lastName, person.coursesEnrolled)
      personList = newPerson :: personList.filter(_.id != newPerson.id)
      Some(id)
    else
      None
  end updatePerson
  
  def getPersons = personList
  

end PersonRepository
