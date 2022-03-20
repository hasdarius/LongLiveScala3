package errorHandling

import scala.util.{Success, Try}

object ErrorHandlingPlayground extends App :
  try {
    DbConnection.connect("user", "pasword", "urlConnection")
    DbConnection.performDbOperation
  }
  catch {
    case exception: IllegalAccessException => exception.printStackTrace
  }
  finally {
    DbConnection.disconnect
  }

  // new way of handling errors
  println("\n----------Handling errors scala style (or FP style)--------------")
  // Enter Try
  val protectedDivision = (x: Int, y: Int) => Try(x / y)
  val simpleDivision = protectedDivision( 17, 0)
  // val simpleDivision = Try(3 -> 0).flatMap(tuple => protectedDivision(tuple._1, tuple._2))
  println("Performing a simple division:")
  println("Result is: " + simpleDivision)
  val recoveredDivision = simpleDivision.recover{case _ => -1}
  println("Recovered result is: " + recoveredDivision)


  println("\n----------Let's gracefully query the database...----------")
  DbConnection.connect("user", "pasword", "urlConnection")
  val potentiallyFailedOperation: Try[String] = DbConnection.gracefullyPerformDbOperation
  println(potentiallyFailedOperation)
  if potentiallyFailedOperation.isFailure then
    val surelySuccessfulOperation = potentiallyFailedOperation.recoverWith({
      case error: IllegalAccessException => DbConnection.loginAndPerformOperationAsAdmin("adminSecretKey")
    })
    println(surelySuccessfulOperation)
  DbConnection.disconnect


  println("\n-----------Using either to avoid exceptions----------------- ")
  val performDbOperation = Either.cond(
    DbConnection.connect("user", "pasword", "urlConnection"),
    DbConnection.performDbOperation,
    DbConnection.loginAndPerformOperationAsAdmin("adminSecretkey").get)

  println(performDbOperation)

end ErrorHandlingPlayground
