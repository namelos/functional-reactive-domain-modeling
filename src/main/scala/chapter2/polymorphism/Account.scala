package chapter2.polymorphism

import java.time.Period

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

object Account {
  def calculateInterest[A <: InterestBearingAccount](account: A, period: Period): Unit = {

  }
}
