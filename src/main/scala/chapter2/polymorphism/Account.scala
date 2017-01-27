package chapter2.polymorphism

import java.time.Period

import scala.util.Try

trait Account {
  def number: String
  def name: String
}

case class CheckingAccount(number: String, name: String) extends Account

trait InterestBearingAccount extends Account {
  def rateOfInterest: BigDecimal
}

case class SavingAccount(number: String, name: String, rateOfInterest: BigDecimal) extends InterestBearingAccount
case class MoneyMarketAccount(number: String, name: String, rateOfInterest: BigDecimal) extends InterestBearingAccount

trait Amount

object Account {
  def calculateInterest[A <: InterestBearingAccount]
    (account: A, period: Period): Try[BigDecimal] = ???

  val s1 = SavingAccount("dg", "sb001", 0.5)
  val s2 = SavingAccount("sr", "sb002", 0.75)
  val s3 = SavingAccount("ty", "sb003", 0.27)

  val dateRange = new Period()

  List(s1, s2, s3).map(calculateInterest(_, dateRange))

//  List(s1, s2, s3).map(calculateInterest(_, dateRange))
//      .foldLeft(BigDecimal(0)((a: BigDecimal, e: Try[BigDecimal]) => e.map(_ + a).getOrElse(a)))

  List(s1, s2, s3).map(calculateInterest(_, dateRange))
      .filter(_.isSuccess)

  def getCurrencyBalance(a: Account): Try[Amount] = ???

  def getAccountFrom(no: String): Try[Account] = ???

  def calculateNetAssetValue(a: Account, balance: Amount): Try[Amount] = ???

  val result: Try[(Account, Amount)] = for {
    s <- getAccountFrom("a1")
    b <- getCurrencyBalance(s)
    v <- calculateNetAssetValue(s, b)
//    if (v > 10000)
  } yield (s, v)
}
