package interfaces

import interfaces.model.*

import scala.collection.mutable

object InterfacesPlayground extends App :

  var folder: FileSystemEntity = Folder("~",
    List(
      Folder("home", List(File("file1.txt", "This is a text file"))),
      Folder("bin", List(File("file2.exe", "This is an executable file"))))
  )
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


  // Type classes - ad-hoc polymorphism - a list of classes that behave similar according to a contract/interface (trait) specification
  // the method behaves differently when presented with parameters of different types
  // Type class - pattern that allows us to define specific implementation depending on the type

end InterfacesPlayground

