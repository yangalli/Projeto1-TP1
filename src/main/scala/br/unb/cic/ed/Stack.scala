package br.unb.cic.ed

trait Stack[A] {
  def push(value: A): Unit
  def pop(): Option[A]
  def top(): Option[A] 
  def size(): Int
}