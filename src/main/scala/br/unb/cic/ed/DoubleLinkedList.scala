package br.unb.cic.ed

trait Adicional[A] {
    def iterator(): DllIterator[A]
    def head(): DllNode[A]
}

case class DllNode[A](var value: A, var prev: DllNode[A] = null,  var next: DllNode[A] = null)

class DoubleLinkedList[A: Manifest] extends List[A] with Adicional[A] {

    private var _head: DllNode[A] = null
    private var tail: DllNode[A] = null
    private var _size: Int = 0

    def clear = ???

    def insert(pos: Int, value: A) {

        if(pos < 0 || pos > _size )
            throw ArrayIndexOutOfBounds("the position of the argument must be between 0 and size")

        //inserção lista vazia
        if(_size == 0){
            _head = DllNode(value)
            tail = _head
        }
        else {
            if(pos == 0) {
                val newNode = DllNode(value, null, _head)
                _head.prev = newNode
                _head = newNode
            }
            else if(pos == _size-1) {
                val newNode = DllNode(value, tail)
                tail.prev.next = newNode
                tail = newNode
            }
            else {
                var it = _head
                for(v <- 0 until pos)
                    it.next
                val newNode = new DllNode(value, it.prev, it)
                it.prev.next = newNode
                it.prev = newNode
                _size += 1
                if(it.next == null)
                    tail = it
            }
        }
    }

    def remove(pos: Int) {

        if(pos < 0 || pos > _size)
        throw ArrayIndexOutOfBounds("the position of the argument must be between 0 and size")
        
        if(pos == 0) {
            _head = _head.next
            _head.prev = null
        }
        else if(pos == _size-1) {
            tail = tail.prev
            tail.next = null
        }
        else {
            // Na lista duplamente encadeada, ao encontrar o nó já é possível removê-lo, sem a necessidade de parar
            // um elemento antes para removê-lo
            var it = _head
            for(i <- 0 until pos) 
                it.next
            // o ponteiro que aponta para o elemento prev do nó next ao rover, após a remoção, deve apontar  
            // para o elemento prev do rover
            it.next.prev = it.prev 
            // o ponteiro que aponta para o elemento next do nó prev ao rover, após a remoção, deve apontar  
            // para o elemento next do rover
            it.prev.next = it.next
        }

        _size -= 1
    }

    def elementAt(pos: Int): Option[A] = {

        if(pos >= 0 && pos < _size) {

            var rover = _head
            for(i <- 0 until pos) // o rover vai se locomovendo até o final da lista
                rover = rover.next // rover caminha pela lista  
            Some(rover.value)
        }
        None
    }
    def update(pos: Int, value: A): Option[A] = ???
    def find(value: A): Option[Int] = {

        var it = iterator
        var index = 0

        while(it.hasNext) {
            if(it.current == value) Some(index)
            it.next
            index +=1
        }
        None
    }

    def size(): Int = _size
    def head(): DllNode[A] = _head

    def iterator() = new DllIterator(this)
}

//o iterator nao é usado pra nada
class DllIterator[A: Manifest](val elements: DoubleLinkedList[A]) extends Iterator[A] {

    var pos: Int = 0
    var it: DllNode[A] = elements.head

    def hasNext() = pos < elements.size
    
    def next() {
        it = it.next
        pos += 1
    }
    
    def current(): A = {
        it.value
    }

}
