import dtos.Person
import optionals.PersonRepository
import org.scalatest.BeforeAndAfter
import org.scalatest.funspec.AnyFunSpec

class PersonRepositoryFunSpec extends AnyFunSpec with BeforeAndAfter :
  var testPerson: Person = _
  val personRepository = PersonRepository

  describe("Person repository") {
    describe("insert") {
      it("should add person if it does not exist"){
        testPerson = Person(2, "Marius", "Has", 23, List.empty)
        if(!personRepository.getPersons.contains(testPerson))
          assert(personRepository.addNewPerson(testPerson) == Some(testPerson.id))
          assert(personRepository.getPersonById(testPerson.id) == Some(testPerson))

      }
      it("should not add another existing person") {
        testPerson = Person(1, "Darius", "Has", 21, List.empty)
        personRepository.addNewPerson(testPerson)
        assert(personRepository.addNewPerson(testPerson) == None)
        assert(personRepository.getPersons.filter(_ == testPerson).size == 1)
        assert(personRepository.getPersonById(testPerson.id) == Some(testPerson))
      }
    }


  }
end PersonRepositoryFunSpec
