import dtos.model.Person
import optionals.PersonRepository
import org.scalatest.BeforeAndAfter
import org.scalatest.funspec.AnyFunSpec

class PersonRepositoryFunSpec extends AnyFunSpec with BeforeAndAfter :
  var testPerson: Person = _

  describe("Person repository") {
    describe("insert") {
      it("should add person if it does not exist"){
        testPerson = Person(2, "Marius", "Has", 23, List.empty)
        if(!PersonRepository.getPersons.contains(testPerson))
          assert(PersonRepository.addNewPerson(testPerson) == Some(testPerson.id))
          assert(PersonRepository.getPersonById(testPerson.id) == Some(testPerson))

      }
      it("should not add another existing person") {
        testPerson = Person(1, "Darius", "Has", 21, List.empty)
        PersonRepository.addNewPerson(testPerson)
        assert(PersonRepository.addNewPerson(testPerson) == None)
        assert(PersonRepository.getPersons.filter(_ == testPerson).size == 1)
        assert(PersonRepository.getPersonById(testPerson.id) == Some(testPerson))
      }
    }


  }
end PersonRepositoryFunSpec
