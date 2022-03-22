package streamProcessing

import classExtensions.ObjectExtensions.*
import dtos.model.Person

import java.util.stream.Collector

object StreamsPlayground extends App :


  // Scala's Stream is a lazily intialized List
  // Stream is deprecated since Scala 2.13, use LazyList instead
  def badFibonacci(firstElement: Int = 0, secondElement: Int = 1): Stream[Int] =
    secondElement #:: badFibonacci(secondElement, firstElement + secondElement)
  end badFibonacci

  var fibonacciStream = badFibonacci()
  println(fibonacciStream)
  val firstTenFiboNumbers = fibonacciStream.take(10).force.toList
  println(fibonacciStream)
  println(fibonacciStream.tail)

  // println(fibonacciStream.reverse) this will crash our code
  // Stream is just a LazyList with a LazyVal as tail

  val personList = Person.generateTenRandomPersons()
  println("Generating 10 random people...\n")
  personList.foreach(println)
  println("\nNow let's calculate average learning time...")


  // map, flatMap, filter vs Scala Stream API
  // Scala Views (which compare to java Stream)

  // Scala Stream vs View :
  // Stream -> a list (lazy) that evaluates elements only when needed. They are not reevaluated once fetched.
  // View -> wrapper of a collection. Used for executing transformer operations on a collection lazily.
  // Reevaluated everytime the view is demanded/forced.
  // Construct only a proxy for the resulted collection.
  // Construct result only when we have eager operations -> toList, toSeq, reduce, maxBy, sum...
  val elderPeopleWatchingTime = personList
    .view
    .filter(_.age > 50)
    .map(_.coursesEnrolled)
    .flatMap(list => list.map(_.duration))
    .reduce(_ + _) / personList.length
  println(s"Average learning time for elder people: ${elderPeopleWatchingTime} minutes")

  val mostActiveElderPerson = personList
    .view
    .filter(_.age > 50)
    .maxBy(person => (person.coursesEnrolled.map(_.duration).sum, person.coursesEnrolled.size))

  println(s"Most active elder person was: ${mostActiveElderPerson} ")



  val primeFibonacciNumbers = fibonacciStream
    .view
    .take(20)
    .filter(_.isPrime)
    .toList

  println(s"Fibonacci Prime map: ${primeFibonacciNumbers}")


  println("Normal filter:")
  val fiboList = firstTenFiboNumbers.filter {x =>  println(x); true }.head
  println("\nStream fiter execution:")
  val fiboStream = firstTenFiboNumbers.toStream.filter { x =>  println(x); true }
  println(fiboStream)
  println("\nView filter execution:")
  val fiboView = firstTenFiboNumbers.view.filter { x =>  println(x); true }
  print(fiboView)



end StreamsPlayground

