package chapter2.patternMatching

import java.util.Date

case class Amount(amount: BigDecimal, currency: Currency)

case class Account(no: String,
                   name: String,
                   dateOfOpening: Date,
                   balance: Balance)

sealed trait Instrument

case class Equity(isin: String,
                  name: String,
                  dateOfIssue: Date) extends Instrument

case class FixedIncome(isin: String,
                       name: String,
                       dateOfIssue: Date,
                       issueCurrency: Currency,
                       nominal: BigDecimal) extends Instrument

sealed trait Currency extends Instrument

case class Balance(amount: BigDecimal, ins: Instrument, asOf: Date)

object Account {
  def getMarketValue(e: Equity, a: BigDecimal): Amount = ???

  def getAccruedInterest(i: String): Amount = ???

  def getHolding(account: Account): Amount = account.balance match {
    case Balance(a, c: Currency, _) => Amount(a, c)
    case Balance(a, e: Equity, _) => getMarketValue(e, a)
    case Balance(a, FixedIncome(i, _, _, c, n), _) => ???
//      Amount(n * a, c) + getAccruedInterest(i)
  }
}
