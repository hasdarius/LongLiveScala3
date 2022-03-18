package errorHandling

import scala.util.Try

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
  println("----------HANDLING ERRORS SCALA STYLE--------------")
  DbConnection.connect("user", "pasword", "urlConnection")
  val potentiallyFailedOperation: Try[String] = DbConnection.gracefullyPerformDbOperation
  println(potentiallyFailedOperation)
  if potentiallyFailedOperation.isFailure then
    val surelySuccessfulOperation = potentiallyFailedOperation.recoverWith({
      case error: IllegalAccessException => DbConnection.loginAndPerformOperationAsAdmin("adminSecretKey")
    })
    println(surelySuccessfulOperation)
  DbConnection.disconnect

end ErrorHandlingPlayground
