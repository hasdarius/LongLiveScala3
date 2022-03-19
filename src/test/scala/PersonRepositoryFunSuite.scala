import dtos.Person
import optionals.PersonRepository
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.*
import org.scalatest.matchers.should.Matchers

class PersonRepositoryFunSuite extends AnyFunSuite with Matchers with BeforeAndAfter :
  val personRepository = PersonRepository
  var testPerson: Person = _

  before {
    testPerson = Person(1, "Darius", "Has", 21, List.empty)
    personRepository.addNewPerson(testPerson)
  }

  after {
    personRepository.deleteById(testPerson.id)
  }
  test("It should already have one Person inserted") {
    personRepository.getPersons.size shouldBe 1
    assert(personRepository.getPersons.contains(testPerson))
  }

  test("It should not add the same person if it already exists") {
    personRepository.addNewPerson(testPerson)
    personRepository.addNewPerson(testPerson)
    personRepository.addNewPerson(testPerson)
    personRepository.getPersons.size shouldBe 1
  }
end PersonRepositoryFunSuite
