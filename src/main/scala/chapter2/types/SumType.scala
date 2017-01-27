package chapter2.types

sealed trait Currency
case object USD extends Currency
case object AUD extends Currency
case object EUR extends Currency
case object INR extends Currency

object Main {
}

sealed abstract class Either[+A, +B] {}

final case class Left[+A, +B](a: A) extends Either[A, B] {}

final case class Right[+A, +B](b: B) extends Either[A, B] {}