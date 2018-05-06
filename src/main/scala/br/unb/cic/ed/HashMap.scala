package br.unb.cic.ed

trait HashMap[A] {
  def set(key: String, value: A)
  def get(key: String): Option[A]
  def delete(key: String): Option[A]
}