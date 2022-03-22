import dtos.model.Person
import optionals.PersonRepository
import org.scalatest.wordspec.AnyWordSpec

class PersonRepositoryWordSpec extends AnyWordSpec:
  "A PersonRepository" should{
    "insert person if it does not exist" in {
      val testPerson = Person(2, "Marius", "Has", 23, List.empty)
      if(!PersonRepository.getPersons.contains(testPerson))
        assert(PersonRepository.addNewPerson(testPerson) == Some(testPerson.id))
        assert(PersonRepository.getPersonById(testPerson.id) == Some(testPerson))

    }
    "not insert already existing person" in {
      val testPerson = Person(1, "Darius", "Has", 21, List.empty)
      PersonRepository.addNewPerson(testPerson)
      assert(PersonRepository.addNewPerson(testPerson) == None)
      assert(PersonRepository.getPersons.filter(_ == testPerson).size == 1)
      assert(PersonRepository.getPersonById(testPerson.id) == Some(testPerson))
    }
  }
