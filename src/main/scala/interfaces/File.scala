package interfaces

case class File(filePath: String, content: String) extends FileSystemEntity(filePath) :
  override def open(): Unit = println(s"File :${getFileName()}:\n${content}")

  override def close(): Unit = println(s"Closing the file {$filePath}")

  override def delete(): Unit =
    println(s"Deleted file: ${getFileName()}")
  end delete

  def getFileName() = filePath.substring(filePath.lastIndexOf("/") + 1)
end File
