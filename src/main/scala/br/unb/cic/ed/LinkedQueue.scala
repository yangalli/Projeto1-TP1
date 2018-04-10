package br.unb.cic.ed

//pode tirar a declaração da classe do privado e reaproveitar?
case class Node[A](var value: A, var next: Node[A] = null)

class LinkedQueue[A] extends Queue[A] {


    private var _size = 0
    private var front: Node[A] = null
    private var back: Node[A] = null

    def size(): Int = _size
    def isEmpty(): Boolean = return front == null
    def getFront(): A = {
        require(front != null)
        front.value
    }
    def getBack(): A = {
        require(back != null)
        back.value
    }

    def enqueue(value: A){

        if(isEmpty){
            front = Node(value)
            back = front
        }
        else{
            back.next = Node(value)
            back = back.next
        }
        _size += 1
    }

    def dequeue(): Option[A] = {

        if(!isEmpty){
            var node = front
            front = front.next
            _size -= 1
            if(isEmpty)
                back = null 
            Some(node.value)
        }
        else{
            None
        }

    }

}