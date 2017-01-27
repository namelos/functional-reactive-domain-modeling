package factory

import org.scalatest.{FlatSpec, Matchers}

class FactorySpec extends FlatSpec with Matchers {
  "Account factory" should "create specific account type" in {
    Account("0001", "checking") shouldBe CheckingAccount("0001")
    Account("0002", "saving") shouldBe SavingAccount("0002")
    Account("0003", "money") shouldBe MoneyMarketAccount("0003")
  }
}

