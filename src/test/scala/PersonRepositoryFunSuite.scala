import dtos.model.Person
import optionals.PersonRepository
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.*
import org.scalatest.matchers.should.Matchers

class PersonRepositoryFunSuite extends AnyFunSuite with Matchers with BeforeAndAfter :
  var testPerson: Person = _

  before {
    testPerson = Person(1, "Darius", "Has", 21, List.empty)
    PersonRepository.addNewPerson(testPerson)
  }

  after {
    PersonRepository.deleteById(testPerson.id)
  }
  
  test("It should already have one Person inserted") {
    PersonRepository.getPersons.size shouldBe 1
    assert(PersonRepository.getPersons.contains(testPerson))
  }

  test("It should not add the same person if it already exists") {
    PersonRepository.addNewPerson(testPerson)
    PersonRepository.addNewPerson(testPerson)
    PersonRepository.addNewPerson(testPerson)
    PersonRepository.getPersons.size shouldBe 1
  }
end PersonRepositoryFunSuite
