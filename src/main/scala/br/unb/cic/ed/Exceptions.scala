package br.unb.cic.ed


final case class ArrayIndexOutOfBounds(private val message: String = "",
  private val cause: Throwable = None.orNull) extends Exception(message, cause)

