package interfaces

import scala.collection.mutable

object InterfacesPlayground extends App :

  var folder : FileSystemEntity = Folder("~", List(
    Folder("home", List(File("file1.txt","This is a text file"))),
    Folder("bin", List(File("file2.exe","This is an executable file"))),
  ))
  println("FOLDER")
  println("Opening...")
  folder.open()
  println("Deleting...")
  folder.delete()

  var file : FileSystemEntity = File("~/home/java/text.txt","This is a simple text")
  println("\nFILE")
  println("Opening...")
  file.open()
  println("Deleting...")
  file.delete()

  println("\n\nOur \"file\" becomes the folder")
  file = folder
  println("Opening...")
  file.open()
  println("Adding a new file...")
  file match {
    case folder: Folder => folder.addNewFile("new File","This is a new file")
    case _ =>
  }
  println("Opening again...")
  file.open()

end InterfacesPlayground

