package dtos

object DtoPlayground extends App {


  // tour of case classes
  val person = Person(1, "Darius", "Has", List(Course(1, "Scala Basics", 30l, "")))
  val normalPerson = NormalPerson(1, "Darius", "Has", List.empty)
  // Why?
  // case classes have an apply method for instantiation:
  // def apply(id: UUID, firstName: String, lastName: String, properties: List[Course]): Person = new Person(id: UUID, firstName: String, lastName: String, properties: List[Course])
  // toString()
  println(s"Case class person: $person")
  println(s"Normal class person: $normalPerson")

  //copy() and equals()
  val samePerson = person.copy()
  println(samePerson)
  println(samePerson == person) // == vs .equals


  // DTO conversion
  val personDTO: PersonDTO = person
  println(personDTO)


}