package classExtensions

import ObjectExtensions._

object classExtensionsPlayground extends App :
  val camelCaseString = "scalaIsAwesome"
  println(camelCaseString.toSnakeCase)

  val numberString = "164565443"
  println(numberString.isNumber)

  val secondPowerFunction: Int => Int = x => x * x
  println(secondPowerFunction.derivative(5)(10))
end classExtensionsPlayground
