package favouriteFeatures

import dtos.Person
import interfaces.{File, FileSystemEntity, Folder}

import scala.annotation.tailrec
import scala.util.matching.Regex


object FavouritesPlayground extends App :


  // implementation of classical algorithms
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

  val timestampRegex: Regex = "([0-9]{2}):([0-9]{2}):([0-9]{2}).([0-9]{3})".r
  "17:21:59.411" match {
    case timestampRegex(hour, minutes, _, _) => println(s"It's $minutes minutes after $hour")
  }

  // Support for functional progrmming style
  // Simple examples: Curry functions
  val add: Int => (Int => Int) = firstNumber => secondNumber => firstNumber + secondNumber
  val addTo5 = add(5)
  println(addTo5(3))
  
end FavouritesPlayground
