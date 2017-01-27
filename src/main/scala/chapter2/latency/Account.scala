package chapter2.latency

import scala.concurrent.Future

trait SavingsAccount

class Account {
  def calculateInterest[A <: SavingsAccount](account: A, balance: BigDecimal): Future[BigDecimal] =
    Future {
      if (false) throw new Exception("Interest Rate not found")
      else BigDecimal(10000)
    }


}
