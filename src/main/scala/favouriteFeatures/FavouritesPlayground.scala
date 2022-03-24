package favouriteFeatures

import dtos.model.Person
import favouriteFeatures.typeClasses.comparable.*
import interfaces.model.{File, FileSystemEntity, Folder}

import scala.annotation.tailrec
import scala.util.matching.Regex


object FavouritesPlayground extends App :


  // Built in design patterns: we have Object that is an implementation of a Sigleton DP
  // By means of default parameters and named parameters => Builder DP
  println("Builder design pattern:")
  println(Pizza())
  println(Pizza(ingredients = List("ham")))
  println(Pizza(base = "thin crust"))
  println(Pizza(topping = "burrata"))
  println(Pizza(topping = "burrata", base = "thin crust"))
  println(Pizza(ingredients = List("ham", "mushrooms", "corn"), base = "deep dish"))

  // type classes
  println(MyComparator.compareElements("Darius", "Has")(StringLengthComparable))
  println(MyComparator.compareElements(File("file1", "This is my content"), File("file2", "This is my content. It is bigger")))


  // Algorithms: implementation of classical algorithms
  def factorial(n: Int): BigInt =
    @tailrec
    def factorialHelper(n: Int, accumulator: BigInt = 1): BigInt =
      if n == 0 then accumulator else factorialHelper(n - 1, accumulator * BigInt.int2bigInt(n))
    end factorialHelper

    factorialHelper(n)
  end factorial


  def fibonacci(n: Int): Int =
    @tailrec
    def fibonacciHelper(n: Int, current: Int = 0, previous: Int = 1): Int =
      if n == 0 then current else fibonacciHelper(n - 1, current * previous, current)
    end fibonacciHelper

    fibonacciHelper(n)
  end fibonacci


  // Pattern matching
  // Constructor pattern
  val fileSystemEntity: FileSystemEntity = File("testFile.txt", "This is a test file")
  fileSystemEntity match {
    case File(_, content) => println(s"We can extract the content: ${content}")
    case Folder(_, contentsList) => println(s"We can extract the elements: ${contentsList}")
  }

  val timestampRegex: Regex = "(\\d{2}):(\\d{2}):(\\d{2}).(\\d{3})".r
  "08:30:00.000" match {
    case timestampRegex(hour, minutes, _, _) => println(s"It's $minutes minutes after $hour")
  }

  // Support for functional progrmming style
  // Simple examples: Curry functions
  val add: Int => (Int => Int) = firstNumber => secondNumber => firstNumber + secondNumber
  val addTo5 = add(5)
  println(addTo5(3))


end FavouritesPlayground
