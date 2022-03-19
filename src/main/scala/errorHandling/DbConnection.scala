package errorHandling

import scala.util.{Failure, Random, Success}

case object DbConnection:
  private var isConnected = false

  def connect(user: String, password: String, dbUrl: String) =
    println("Connecting to DB...")
    Thread.sleep(500)
    isConnected = Random.nextBoolean
    if isConnected then println("Connection successful") else println("Connection unsuccessful")
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

  def gracefullyPerformDbOperation =
    Thread.sleep(1000)
    if isConnected then Success("Connected.Performing mock database operation...")
    else Failure(new IllegalAccessException("Not connected to the database. Trying admin super key..."))
  end gracefullyPerformDbOperation

  private def loginAsAdmin(adminUser: String, adminPassword: String, dbUrl: String) =
    Thread.sleep(500)
    isConnected = true
  end loginAsAdmin

  def loginAndPerformOperationAsAdmin(adminKey: String) =
    loginAsAdmin("admin", "admin", "urlConnection")
    gracefullyPerformDbOperation
  end loginAndPerformOperationAsAdmin
end DbConnection  
