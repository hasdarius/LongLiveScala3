package interfaces.model

trait Summable[A] :
  def sumElements(list: List[A]): A
end Summable


implicit object IntSummable extends Summable[Int]:
  def sumElements(list: List[Int]): Int = list.reduce(_ + _)

implicit object StringSummable extends Summable[String]:
  def sumElements(list: List[String]): String = list.mkString(" ")