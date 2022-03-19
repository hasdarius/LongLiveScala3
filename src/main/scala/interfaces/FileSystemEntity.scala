package interfaces

trait FileSystemEntity(path: String) {
  def open(): Unit
  def close(): Unit
  def delete(): Unit
}



