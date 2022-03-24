package collections

import dtos.model.Person
import dtos.model.{Course, Person}

object CollectionsPlayground extends App :

  // Traversable trait has methods like : map, flatMap, collect
  // conversions : toArray, toList
  // head, tail
  // mkString
  // Traversable -> Iterable -> {Set, Seq, Map}
  // Seq -> {IndexedSeq, LinearSeq}
  // IndexSeq -> {Vector, String, Range} -> used when we want quick access (constant time)
  // LinearSeq -> {List, Stream, Stack, Queue} -> guarantees certain order of elements


  println("---------Sequences----------")
  val immutableSeq: Seq[Int] = Seq(5, 7, 2, 9)
  println(s"Initial Seq: ${immutableSeq}")
  println(s"Reversed : ${immutableSeq.reverse}")
  println(s"Head: ${immutableSeq.head}")
  println(s"Tail: ${immutableSeq.tail}")
  println(s"Sorted: ${(immutableSeq ++ Seq(4, 1, 10, 12)).sorted}")


  println("---------Ranges----------")
  (1 to 10 by 2).foreach(println)

  println("---------Lists----------")
  // map, flatMap, filter
  val emptyList = Nil
  val nonEmptyList = List(10, 7, 3, 10)
  val appendedList = 1 :: 2 :: nonEmptyList ::: emptyList
  println(appendedList)
  println(appendedList.sorted)
  println(appendedList mkString "-")
  println(s"Sum of elements of list is: ${appendedList.reduce(_ + _)}")
  println(s"Sum of elements of list is: ${appendedList.foldLeft(0)(_ + _)}")
  println(s"Sum of elements of list is: ${appendedList.sum}")
  println(appendedList takeWhile (_ < 6))
  val redundatList = List.fill(10)("Scala Rocks")
  println(redundatList)
  val zippedList = appendedList zip redundatList  // can write infix style, looks like natural language
  println(zippedList)

  val person1 = Person(1, "Darius", "Has", 21, List(Course(1, "Scala Basics", 30, "")))
  val person2 = Person(2, "Marius", "Has",21, List(Course(1, "Scala Basics", 30, "")))
  val personList = List(person2, person1)
  println(personList)
  println(personList.sortBy(_.id))


  println("---------Maps----------")
  val readPermissionTuple = (4, "Read Permission")
  val writePermissionTuple = (2, "Write Permission")
  val executePermissionTuple = (1, "Execute Permission")
  println(readPermissionTuple)
  println(readPermissionTuple._1)
  println(readPermissionTuple.swap)
  val linuxPermissionsMap = Map(readPermissionTuple, writePermissionTuple, executePermissionTuple) + (3 -> "Read Write Permissions")
  val guardedPermissionsMap = linuxPermissionsMap.withDefaultValue(0)
  println(linuxPermissionsMap)
  println(linuxPermissionsMap(3))
  //println(linuxPermissionsMap(100)) // this will throw exeption
  println(linuxPermissionsMap.view.mapValues(_.toLowerCase).toMap)
  println(linuxPermissionsMap.view.filterKeys(_ > 2).toMap)
  println(linuxPermissionsMap.groupBy(_._2.contains("Read")))

  // list to map and vice-versa
  println(linuxPermissionsMap.toList)
  println(List("C++", "java", "Scala", "Kotlin").zipWithIndex.toMap)

  println("---------Sets----------")
  // same as lists, but: unordered, does not accept duplicates
  val fruits = Set("apple", "pear", "orange", "apple")
  println(fruits)
  println(fruits.zipWithIndex.toMap)
  println(fruits.reduce(_ + ", " + _))

end CollectionsPlayground
