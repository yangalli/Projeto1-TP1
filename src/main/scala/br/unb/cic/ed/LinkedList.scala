package br.unb.cic.ed

class LinkedList[A] extends List[A] {

  /********************** Estruturas Necessárias para Linked List ***************************/ 

  // o next é do tipo Node, se refereindo ao próximo nó
  private var head: Node[A] = null
  private var tail: Node[A] = null
  private var _size: Int = 0

  /******************************* Definições das Funções ************************************/

  def clear() {
    head = null
    tail = null
    _size = 0
  }

  def find(value: A): Option[Int] = {
    if(size == 0)
      None 
    var rover = head
    var index = 0
    while(rover != null) {
      if(rover.value == value) {
        return Some(index); 
      }
      rover = rover.next
      index += 1
    }
    None
  }

  def update(pos: Int, value: A): Option[A] = {
    if(pos < 0 || pos > _size) // só aceita uma posicao igual ou maior que 0
      throw ArrayIndexOutOfBounds("the position of the argument must be between 0 and size")
    var rover = head // para começar a buscar o elemento, é interessante começar pela cabeça

    for(i <- 0 until pos) // o rover vai se locomovendo até o final da lista
      rover = rover.next // rover caminha pela lista
    rover.value = value
    return Some(rover.value)
  }

  def elementAt(pos: Int): Option[A] = {
    if(pos >= 0 && pos < _size) { // só aceita uma posicao igual ou maior que 0
      var rover = head // para começar a buscar o elemento, é interessante começar pela cabeça
      
      for(i <- 0 until pos) // o rover vai se locomovendo até o final da lista
        rover = rover.next // rover caminha pela lista  
      return Some(rover.value)
    }
    None
  }

  def insert(pos: Int, value: A): Unit = {
    if(pos < 0 || pos > _size )
      throw ArrayIndexOutOfBounds("the position of the argument must be between 0 and size")
    else if(pos >= 0 || pos <= _size) {
      if(pos == 0){
        head = new Node(value, head)
      }
      else {
        var rover = head 

        for(i <- 0 until pos-1) // para um nó antes para 
          rover = rover.next
        rover.next = new Node(value, rover.next) // aponta para o nó após encontrar a posição do rover
        // aponta para o antigo rover.next
      }
      _size += 1
    }
  }

  def remove(pos: Int): Unit = {
    if(pos < 0 || pos > _size) // só aceita uma posicao igual ou maior que 0
      throw ArrayIndexOutOfBounds("the position of the argument must be between 0 and size")
    
    _size -= 1

    if(pos == 0){
      var ret = head.value
      head = head.next
      if(head == null)
        tail = null
      ret
    }
    else{
      var rover = head // para começar a buscar o elemento, é interessante começar pela cabeça

      for(i <- 0 until pos-1) // o rover vai se locomovendo até o final da lista
        rover = rover.next // rover caminha pela lista
      
      var ret = rover.next.value
      rover.next = rover.next.next

      if(rover.next == null)
        tail = rover 
      ret
    }
    
  }

  def size(): Int = _size

  def iterator() = new LinkedListIterator(head)
}

class LinkedListIterator[A](val elements: Node[A]) extends Iterator[A] {

  private var it = elements

  def hasNext(): Boolean = it != null
  def next(): Unit = it = it.next
  def current(): A = it.value
  
}