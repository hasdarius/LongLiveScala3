package interfaces.model.typeClasses

object ListProcessor {
  def addElements[A](list: List[A])(implicit summable: Summable[A]): A = summable.sumElements(list)
}
