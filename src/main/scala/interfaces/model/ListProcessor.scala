package interfaces.model

object ListProcessor {
  def addElements[A](list: List[A])(implicit summable: Summable[A]): A = summable.sumElements(list)
}
