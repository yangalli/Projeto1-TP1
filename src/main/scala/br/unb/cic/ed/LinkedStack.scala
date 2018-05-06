package br.unb.cic.ed

class LinkedStack[A](private val elements: LinkedList[A]) extends Stack[A] {

    private var _size = 0
    
    def push(value: A){

        elements.insert(0, value)
        _size += 1
    }

    def pop(): Option[A] = {

        val res = elements.elementAt(0)
        res match {
            case Some(v) => {
                elements.remove(0)
                _size -= 1
            }
            case None => {}
        }
        res
    }

    def top(): Option[A] = {
       
        elements.elementAt(0)
    }
    
    def size(): Int = _size
}