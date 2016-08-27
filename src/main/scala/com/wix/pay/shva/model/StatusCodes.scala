package com.wix.pay.shva.model

/** @see <a href="http://www.shva.co.il/files/files/STATUSCODES.pdf">נספח 1 קודי סטטוס</a> */
object StatusCodes {
  /** Permitted transaction. */
  val success = "000"
  /** The card is blocked, confiscate it. */
  val blocked = "001"
  /** The card is stolen, confiscate it. */
  val stolen = "002"
  /** Contact the credit company. */
  val call = "003"
  /** Refusal by credit company. */
  val rejected = "004"
  /** The card is forged, confiscate it. */
  val counterfeit = "005"
  /** Incorrect CVV/ID. */
  val wrongCvvOrHolderId = "006"
  /** Incorrect CAVV/ECI/UCAF. */
  val mustCall = "007"
  /** The program was stopped by user's command (ESC) or COM PORT can't be open (Windows). */
  val canceled = "010"
  /** This card is not permitted for foreign currency transactions. */
  val currencyRejected = "012"
  /** This card is not Supported. */
  val unsupportedCard = "014"
  /** Defective card. */
  val invalidCard = "033"
  /** This card is not permitted for this terminal or is not authorized for this type of transaction. */
  val unauthorizedCard1 = "034"
  /** This card is not permitted for this transaction or type of credit. */
  val unauthorizedCard2 = "035"
  /** Expired card. */
  val expired = "036"
  /** Unable to execute a debit transaction that is higher than the credit card's ceiling. */
  val exceeded = "038"
  /** Card has zero ceiling for regular payments. */
  val zeroCeilingRegular = "157"
  /** Card has zero ceiling for debit payments. */
  val zeroCeilingDebit = "158"
  /** Card has zero ceiling for dollars payments. */
  val zeroCeilingDollars = "159"
  /** Card has zero ceiling for phone payments. */
  val zeroCeilingPhone = "160"
  /** Card has zero ceiling for refund payments. */
  val zeroCeilingRefund = "161"
  /** Card has zero ceiling for split payments. */
  val zeroCeilingSplit = "162"
  /** Double transaction. */
  val doubleTransaction = "173"
}

object IsShvaRejectedStatusCode {
  private val rejectedStatusCodes = Set(
    StatusCodes.blocked,
    StatusCodes.stolen,
    StatusCodes.call,
    StatusCodes.rejected,
    StatusCodes.counterfeit,
    StatusCodes.wrongCvvOrHolderId,
    StatusCodes.mustCall,
    StatusCodes.currencyRejected,
    StatusCodes.unsupportedCard,
    StatusCodes.invalidCard,
    StatusCodes.unauthorizedCard1,
    StatusCodes.unauthorizedCard2,
    StatusCodes.expired,
    StatusCodes.exceeded,
    StatusCodes.zeroCeilingRegular,
    StatusCodes.zeroCeilingDebit,
    StatusCodes.zeroCeilingDollars,
    StatusCodes.zeroCeilingPhone,
    StatusCodes.zeroCeilingRefund,
    StatusCodes.zeroCeilingSplit,
    StatusCodes.doubleTransaction
  )

  def unapply(statusCode: String): Option[String] = {
    if (rejectedStatusCodes.contains(statusCode)) Some(statusCode) else None
  }
}
