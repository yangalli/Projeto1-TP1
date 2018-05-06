/**********************************************************************************************

Immutable Linked List: the nodes on the list doesn't change. Their values stay intact, and the
only way to insert a node is in it's beguinning, so that it doesn't change the other nodes and
their positions.
It's important to notice that to insert a node in a place that is not before the first node,
another list must be created.

**********************************************************************************************/
package br.unb.cic.ed.immutable
import collection.immutable.LinearSeq

// sealed -> you can only use this class inside this file
// +A -> Covariant -> treats subtype errors
sealed trait ImmLinkedList[+A] extends LinearSeq[A] {
  def ::[B >: A](data: B): ImmLinkedList[B] = new Cons(data, this)
  // The return is a type B, that must be a Supertype of A
  // B can be any type that has A as a subtype

  override def iterator = new Iterator[A] {
    var rover: LinearSeq[A] = ImmLinkedList.this // vai dar erro
    // there is always a next node as long as the node that iterates is not empty
    def hasNext = !rover.isEmpty
    def next: A = {
      val ret = rover.head
      rover = rover.tail
      return ret
    }
  }
}

final class Cons[A](override val head: A, override val tail: ImmLinkedList[A]) extends ImmLinkedList[A] {
  override def isEmpty = false

  def length: Int = 1 + tail.length
  // if the index searched in the sublists of the original list is 0, then the iteration found the 
  // head of the list. If not, it'll recursively go through all elements and find the correct one
  def apply(index:Int): A = if(index == 0) head else tail(index-1) 
}

object MyNil extends ImmLinkedList[Nothing] {
  override def isEmpty = true
  override def head = throw br.unb.cic.ed.ArrayIndexOutOfBounds("MyNil has no head.")
  override def tail = throw br.unb.cic.ed.ArrayIndexOutOfBounds("MyNil has no tail.")

  def length = 0
  def apply(index: Int) = throw br.unb.cic.ed.ArrayIndexOutOfBounds("Index argument must be between 0 and size.") 
}
