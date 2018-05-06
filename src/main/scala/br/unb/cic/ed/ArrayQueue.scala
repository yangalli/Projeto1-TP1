package br.unb.cic.ed

class ArrayQueue[A: Manifest](private val elements: List[A]) extends Queue[A] {

    private var _size = 0

    def enqueue(value: A) {
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

    def size(): Int = _size
}