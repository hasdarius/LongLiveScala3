import dtos.Person
import optionals.PersonRepository
import org.scalatest.wordspec.AnyWordSpec

class PersonRepositoryWordSpec extends AnyWordSpec:
  val personRepository = PersonRepository
  "A personRepository" should{
    "insert person if it does not exist" in {
      val testPerson = Person(2, "Marius", "Has", 23, List.empty)
      if(!personRepository.getPersons.contains(testPerson))
        assert(personRepository.addNewPerson(testPerson) == Some(testPerson.id))
        assert(personRepository.getPersonById(testPerson.id) == Some(testPerson))

    }
    "not insert already existing person" in {
      val testPerson = Person(1, "Darius", "Has", 21, List.empty)
      personRepository.addNewPerson(testPerson)
      assert(personRepository.addNewPerson(testPerson) == None)
      assert(personRepository.getPersons.filter(_ == testPerson).size == 1)
      assert(personRepository.getPersonById(testPerson.id) == Some(testPerson))
    }
  }
