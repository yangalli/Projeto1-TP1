package br.unb.cic.ed

/**
  * Uma implementacao do tipo lista usando
  * alocacao sequencial (um array de elementos).
  *
  * @author: rbonifacio
  */
class ArrayList[A: Manifest](private val max: Int = 10) extends List[A] {

  private var _size = 0;
  private var elements = Array.ofDim[A](max)

  def insert(pos: Int, value: A): Unit = {
    if(pos >= 0 && pos <= _size && pos < max) {
      if(pos == _size) {
        elements(pos) = value
      }
      else {
        for(index <- (_size-1) to pos by -1){
          elements(index + 1) = elements(index)
        }
        elements(pos) = value
      }
      _size += 1
    }
    else throw ArrayIndexOutOfBounds("the first argument must be between 0 and size")
  }

  // def update(pos: Int, value: A): Unit = {
  //   require(pos >= 0)
    
  //   var rover = head 

  //   for(i <- 0 until pos) // o rover vai se locomovendo até o final da lista
  //     rover = rover.next // rover caminha pela lista
  //   rover.value = value
  // }

  def elementAt(pos: Int): Option[A] = {
    if(pos >= 0 && pos < _size) {
      return Some(elements(pos))
    }
    return None
  }

  def find(value: A): Option[Int] = {
    for(idx <- 0 until _size) {
      if(value == elements(idx)) {
        return Some(idx)
      }
    }
    return None
  }

  def remove(pos: Int): Unit = {
    if(pos >= 0 && pos < _size) {
      if(pos != _size-1){
        for(index <- pos until (_size-1)){
          elements(index) = elements(index+1)
        }
      }
      _size -= 1
    }
    else throw ArrayIndexOutOfBounds("the first argument must be between 0 and size")
  }

  def size(): Int = _size
}

