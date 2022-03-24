package favouriteFeatures.typeClasses.comparable

object MyComparator {
  def compareElements[A](firstElement: A, secondElement: A)(implicit myComparable: MyComparable[A]): Int = myComparable.compareElements(firstElement, secondElement)
}
