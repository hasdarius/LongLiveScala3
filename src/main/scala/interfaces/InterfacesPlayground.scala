package interfaces

import scala.collection.mutable

object InterfacesPlayground extends App :

  var dog: Animal = HuntingDog("Max The Hunter", "ogar", 3.14)
  dog.speak
  dog.eat
  dog.run
  dog = FightingDog("Max The Fighter", "Pitbull")
  dog.eat
  dog.run
end InterfacesPlayground
