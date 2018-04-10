package br.unb.cic.ed

class LinkedStack[A](private val elements: LinkedList[A]) extends Stack[A] {

    private var _size = 0
    //private var head: Node[A] = null
    
    def push(value: A){

        elements.insert(0, value)
        _size += 1
        /*
        val newNode = Node(value)
        newNode.next = head
        head = newNode
        _size += 1
        */
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
        /*
        if(!isEmpty){
            val node = head
            head = head.next
            _size -= 1
            Some(node.value)
        }
        else{
            None
        } 
        */
    }
    def top(): Option[A] = {
       
        elements.elementAt(0)
        /*
        if(!isEmpty){
            Some(head.value)
        }
        else{
            None
        }
        */
    }
    def size(): Int = _size
}