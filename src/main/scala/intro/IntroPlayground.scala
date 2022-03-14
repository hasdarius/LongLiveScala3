package intro

object IntroPlayground extends App {

  // Scala is a pure OOP programming language
  val result = 2.+(3)
  val negativeNumber = -1 // 1.unary_-


  val isPalindrome: Int => Boolean = (number: Int) => number == number.toString.reverse.toInt
  /*val isPalindromeEquivalent = new Function1[Int, Boolean] {
    override def apply(number: Int): Boolean = number == number.toString.reverse.toInt
  }*/
  println(isPalindrome(2))

  // Scala takes full advantage of EOP (Expression oriented programming)
  val ifResult = if isPalindrome(1771) then "Palindrome" else "Not a palindrome"
  println(ifResult)

  val numberList = (for number <- 0 to 100 yield number)
  println(numberList)

  // statically typed language
  var anyRefValue = null
  //anyRefValue = "Scala rocks"

}
