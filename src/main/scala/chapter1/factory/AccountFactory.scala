package chapter1.factory

// Factory
trait AccountFactory {

}

case class CheckingAccount(/* params */) extends AccountFactory
case class SavingAccount(/* params */) extends AccountFactory
case class MoneyAccount(/* params */) extends AccountFactory

object AccountFactory {
  def apply(/* params */) = {
  }
}


