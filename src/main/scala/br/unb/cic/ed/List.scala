package br.unb.cic.ed

trait List[A] {
  //def clear(): Unit
  def find(value: A): Option[Int]
  //def update(pos: Int, value: A ): Unit
  def elementAt(pos: Int): Option[A]
  def insert(pos: Int, value: A): Unit
  def remove(pos: Int): Unit
  def size(): Int
}
