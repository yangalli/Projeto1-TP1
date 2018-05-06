package br.unb.cic.ed

case class Node[A](var value: A, var next: Node[A] = null)

class LinkedQueue[A](private val elements: LinkedList[A]) extends Queue[A] {

    private var _size = 0

    def size(): Int = _size

    def enqueue(value: A){

        elements.insert(0, value)
        _size += 1
    }

    def dequeue(): Option[A] = {

        val res = elements.elementAt(_size-1)
        res match {
            case Some(v) => {
                elements.remove(_size-1)
                _size -= 1
            }
            case None => {}
        }
        res
    }

}