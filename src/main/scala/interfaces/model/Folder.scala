package interfaces.model

case class Folder(path: String, var childrenFileSystemObjects: List[FileSystemEntity]) extends FileSystemEntity(path) :
  override def open(): Unit =
    println("Printing contents:")
    childrenFileSystemObjects.foreach {
      case folder: Folder => println(s"Folder: ${folder.path.diff(this.path)}")
      case file: File => println(s"File: ${file.getFileName()}")
    }
  end open

  override def close(): Unit = println(s"Closing the file {$path}")

  override def delete(): Unit =
    childrenFileSystemObjects.foreach(_.delete())
    println(s"Deleted folder: ${path}")
  end delete

  def deleteFile(fileName: String) = childrenFileSystemObjects =
    childrenFileSystemObjects.filter {
      case folder: Folder => true
      case file: File => file.getFileName() != fileName
    }
  end deleteFile

  def addNewFile(fileName: String, content: String) =
    childrenFileSystemObjects = File(s"${path}/${fileName}", content) :: childrenFileSystemObjects
  end addNewFile
end Folder
