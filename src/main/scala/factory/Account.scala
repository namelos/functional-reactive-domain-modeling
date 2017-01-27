package factory

trait Account {
  val id: String
}

case class CheckingAccount(id: String) extends Account
case class SavingAccount(id: String) extends Account
case class MoneyMarketAccount(id: String) extends Account

object Account {
  def apply(id: String, accountType: String): Account = accountType match {
    case "checking" => CheckingAccount(id)
    case "saving" => SavingAccount(id)
    case "money" => MoneyMarketAccount(id)
    case _ => throw new Exception("account type not exist")
  }
}
