package br.unb.cic.ed

trait LinkList[A] {
  def find(value: A): Option[Int]
  def update(pos: Int, value: A ): Unit
  def insert(pos: Int, value: A): Unit
  //def remove(pos: Int): Unit
}
