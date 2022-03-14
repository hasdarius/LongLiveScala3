package interfaces

// what is a trait?
// traits vs interfaces in Java?
// traits vs abstract classes in Scala
trait Animal(name: String, creatureType: String):
  def speak: Unit
  def eat: Unit /*=
    println(s"The $creatureType named $name is eating")
    Thread.sleep(1000)
    println(s"The $creatureType named $name has finished eating")
  end eat*/
  def run: Unit
end Animal
