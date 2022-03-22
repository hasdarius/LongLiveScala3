package interfaces

import interfaces.model._

import scala.collection.mutable

object InterfacesPlayground extends App :

  var folder: FileSystemEntity = Folder("~", List(
    Folder("home", List(File("file1.txt", "This is a text file"))),
    Folder("bin", List(File("file2.exe", "This is an executable file"))),
  ))
  var file: FileSystemEntity = File("~/home/java/text.txt", "This is a simple text")
  FileSystemEntity.performBasicOperations(folder)
  FileSystemEntity.performBasicOperations(file)
  file = folder
  FileSystemEntity.performBasicOperations(file)

  file match {
    case folder: Folder => folder.addNewFile("new File", "This is a new file")
    case _ =>
  }
  file.open()


  // type classes - ad-hoc polymorphism - the method behaves differently when presented with different types
  // Type class - pattern that allows us to define specific implementation depending on the type
  println("-------Type classes------")
  val listOfInts = (1 to 10 by 2).toList
  val listOfStrings = List("I", "love", "Scala")
  println(ListProcessor.addElements(listOfInts))
  println(ListProcessor.addElements(listOfStrings))

end InterfacesPlayground

