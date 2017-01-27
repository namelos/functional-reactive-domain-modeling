package chapter2.purity

trait Account {
  def no: String
  def name: String
  def balance: Balance
}

case class SavingsAccount(no: String,
                          name: String,
                          balance: Balance,
                          rate: BigDecimal) extends Account

case class Balance(amount: BigDecimal)

object Account {
  def calculateInterest: SavingsAccount => BigDecimal = { a =>
    a.balance.amount * a.rate
  }

  def deductTax: BigDecimal => BigDecimal = { interest =>
    if (interest < 1000) interest
    else interest - 0.1 * interest
  }

  val a1 = SavingsAccount("a-0001", "ibm", Balance(100000), 0.12)
  val a2 = SavingsAccount("a-0002", "google", Balance(20000), 0.13)
  val a3 = SavingsAccount("a-0003", "chase", Balance(125000), 0.15)

  val accounts = List(a1, a2, a3)

  accounts.map(calculateInterest).map(deductTax)

  accounts.map(calculateInterest andThen deductTax)
}

