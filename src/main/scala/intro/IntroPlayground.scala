package intro

object IntroPlayground extends App {

  // Scala Syntax
  val aString = "String"
  class SimpleClass(val stringParameter: String, val intParamter: Int)
  object SimpleObject
  trait SimpleTrait(val stringParameter: String, val intParamter: Int)
  def reverseString(word: String): String = word.reverse
  val incrementFunction: (Int => Int) = number => number + 1 // function syntax


  // Concepts that helped me understand Scala in depth
  // 1. Scala is a pure OOP programming language
  val result = 2.+(3)
  val negativeNumber = -1 // 1.unary_-


  val isPalindrome: (Int => Boolean) = number => number == number.toString.reverse.toInt
  val isPalindromeEquivalent = new Function1[Int, Boolean] {
    override def apply(number: Int): Boolean = number == number.toString.reverse.toInt
  }
  println(isPalindrome(2))
  println(isPalindromeEquivalent(2))

  // 2. Scala takes full advantage of EOP (Expression oriented programming)
  val ifResult = if isPalindrome(1771) then "Palindrome" else "Not a palindrome"
  println(ifResult)

  val numberSeq = for number <- 0 to 10 yield number
  println(numberSeq)

  // 3. statically typed language
  var anyRefValue : String = null
  anyRefValue = "Scala is the best"
}
