package interfaces.model

trait FileSystemEntity(path: String) :
  def open(): Unit
  def close(): Unit
  def delete(): Unit
end FileSystemEntity

object FileSystemEntity:
  def performBasicOperations(fileSystemEntity: FileSystemEntity) =
    println("-------------------------")
    println("This is a: " + fileSystemEntity.getClass.getSimpleName)
    println("Opening...")
    fileSystemEntity.open()
    println("Deleting...")
    fileSystemEntity.delete()
    println("-------------------------")
  end performBasicOperations
end FileSystemEntity




