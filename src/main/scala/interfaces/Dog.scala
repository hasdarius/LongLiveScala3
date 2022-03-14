package interfaces

abstract class Dog(name: String) extends Animal(name, "Dog") :
  val breed: String
  override def speak: Unit = println(s"$name is barking")
end Dog

final case class HuntingDog(name: String, override val breed: String, speedValue: Double) extends Dog(name) :
  override def eat: Unit = println(s"$name eats only pride captured by it.")
  override def run: Unit = println(s"$name runs at an average of $speedValue after its pride")
end HuntingDog

final case class FightingDog(name: String, override val breed: String) extends Dog(name) :
  override def eat: Unit = println(s"$name does not eat two hours prior to his fight.")
  override def run: Unit = println(s"$name is not running, he is fighting.")
end FightingDog






