package chapter1.aggregate

// Aggregate

trait Bank
trait Address
trait Date
trait Amount

trait Account {
  def no: String
  def name: String
  def bank: Bank
  def address: Address
  def dateOfOpening: Date
  def dateOfClose: Option[Date]
}

case class CheckingAccount(
                          no: String,
                          name: String,
                          bank: Bank,
                          address: Address,
                          dateOfOpening: Date,
                          dateOfClose: Option[Date]
                          ) extends Account

case class SavingAccount(
                          no: String,
                          name: String,
                          bank: Bank,
                          address: Address,
                          dateOfOpening: Date,
                          dateOfClose: Option[Date],
                          rateOfInterest: BigDecimal
                        ) extends Account

trait AccountService {
  def transfer(from: Account, to: Account, amount: Amount): Option[Amount]
}