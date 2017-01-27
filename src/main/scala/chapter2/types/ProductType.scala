package chapter2.types

import java.util.Date

sealed trait Account {
  def number: String
  def name: String
}

case class CheckingAccount(number: String,
                           name: String,
                           dateOfOpening: Date
                          ) extends Account

case class SavingAccount(number: String,
                         name: String,
                         dateOfOpening: Date,
                         rateOfInterest: BigDecimal
                        ) extends Account

