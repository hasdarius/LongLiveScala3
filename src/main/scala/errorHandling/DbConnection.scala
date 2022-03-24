package errorHandling

import scala.util.{Failure, Random, Success, Try}

/**
 * Object created as a mock of database connection operations in order to showcase Error handling on Scala and in no way to present real-world behaviour.
 * The flow is: user wants to connect to database and (always) fails. Because of that, an error is thrown when he wants to perform operation.
 * The only way to perform the operation successfully is to connect as a DB admin and then perform the operation.
 * The bahaviour is showcase by means of logs.
 */
case object DbConnection:
  private var isConnected = false

  def connect(user: String, password: String, dbUrl: String) =
    println("Connecting to DB as User...")
    Thread.sleep(500)
    isConnected = false  
    println("Connection unsuccessful as User...")
    isConnected
  end connect

  def disconnect =
    println("Deconnecting...")
    Thread.sleep(500)
    isConnected = false
    println("You are no longer connected to the database.")
  end disconnect

  def performDbOperation =
    Thread.sleep(1000)
    if isConnected then println("Connected.Performing mock database operation...")
    else throw new IllegalAccessException("Not connected to the database")
  end performDbOperation

  def gracefullyPerformDbOperation: Try[String] =
    Thread.sleep(1000)
    if isConnected then Success("Connected.Performing mock database operation...")
    else Failure(new IllegalAccessException("Not connected to the database. Trying admin super key..."))
  end gracefullyPerformDbOperation

  private def loginAsAdmin(adminUser: String, adminPassword: String, dbUrl: String) =
    println("Connecting to DB as Admin...")
    Thread.sleep(500)
    isConnected = true
    println("Connection successful as Admin...")
  end loginAsAdmin

  def loginAndPerformOperationAsAdmin(adminKey: String) =
    loginAsAdmin("admin", "admin", "urlConnection")
    gracefullyPerformDbOperation
  end loginAndPerformOperationAsAdmin
end DbConnection  
