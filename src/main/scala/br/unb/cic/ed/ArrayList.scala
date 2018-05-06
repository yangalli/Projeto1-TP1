package br.unb.cic.ed


class ArrayList[A: Manifest](private val max: Int = 10) extends List[A] {

  /********************** Estruturas Necessárias para a Array List ***************************/

  private var _size = 0;
  var elements = Array.ofDim[A](max)

  /******************************* Definições das Funções ************************************/

  def clear() {
    _size = 0
  }

  def find(value: A): Option[Int] = {
    for(idx <- 0 until _size) {
      if(value == elements(idx)) {
        return Some(idx)
      }
    }
    None
  }

  def update(pos: Int, value: A): Option[A] = {
    if(pos < 0 || pos > _size) // só aceita uma posicao igual ou maior que 0
      throw ArrayIndexOutOfBounds("the position of the argument must be between 0 and size")
    
    elements(pos) = value
    Some(elements(pos))
  }

  def elementAt(pos: Int): Option[A] = {
    if(pos >= 0 && pos < _size) {
      return Some(elements(pos))
    }
    None
  }

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

  def iterator() = new ArrayListIterator(this)

}

class ArrayListIterator[A: Manifest](val elements: ArrayList[A]) extends Iterator[A] {

  private var pos = 0

  override def hasNext(): Boolean = pos < elements.size

  override def next(): Unit = pos += 1

  override def current(): A = elements.elements(pos)

}

object ArrayList {

  /* BubbleSort */
  def BubbleSort[A <% Ordered[A]](list: ArrayList[A]) {

    var array = list.elements
    var swap = false

    for(i <- 0 until list.size - 1)
      if(array(i+1) < array(i)){
        val temp = array(i)
        array(i) = array(i+1)
        array(i+1) = temp
        swap = true
      }

    // Repeat until we don't have anymore swaps
    if(swap) BubbleSort(list)
    else array
  }

  def SelectionSort[A <% Ordered[A]](list: ArrayList[A]) {

    var array = list.elements

    for(i <- 0 until list.size){
      var min = i

      for(j <- i+1 until list.size)
        if(array(j) < array(min))
          min = j

      if(min != i){
        val temp = array(i)
        array(i) = array(min)
        array(min) = temp
      }
    }
  }

  def InsertionSort[A <% Ordered[A]](list: ArrayList[A]) {

    var array = list.elements

    for(i <- 0 until list.size){

      val hold = array(i)
      var holePos = i

      while(holePos > 0 && hold < array(holePos - 1)){
        array(holePos) = array(holePos - 1)
        holePos -= 1
      }

      array(holePos) = hold
    }
  }

  def QuickSort[A <% Ordered[A]](list: ArrayList[A], begin: Int, end: Int) {

    var array = list.elements

    if (begin < end) {
      
      var pivot = partition(array, begin, end);

      // Recursively sort elements before
      // partition and after partition
      QuickSort(list, begin, pivot-1);
      QuickSort(list, pivot+1, end);
    }
  }

  def partition[A <% Ordered[A]](array: Array[A], begin: Int, end: Int): Int = {

    var pivot = array(end)
    var i = begin-1

    for(j <- begin until end) {
      if(array(j) <= pivot) {
        i +=1
        var temp = array(i)
        array(i) = array(j)
        array(j) = temp
      }
    }
    if(array(end) < array(i+1)){
      var temp = array(i+1)
      array(i+1) = array(end)
      array(end) = temp
    }

    return i + 1
    
  }
}