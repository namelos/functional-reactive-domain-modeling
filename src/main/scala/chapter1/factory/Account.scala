package chapter1.factory

// Factory
trait Account {

}

case class CheckingAccount(/* params */) extends Account
case class SavingAccount(/* params */) extends Account
case class MoneyAccount(/* params */) extends Account

object Account {
  def apply(/* params */) = {
  }
}


