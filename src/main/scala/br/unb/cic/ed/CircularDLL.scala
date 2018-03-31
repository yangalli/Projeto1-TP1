package br.unb.cic.ed

class CircularDLL[A : Manifest] extends List[A] {

  /*************** Estruturas Necessárias para a Circular Double Linked List ********************/

  private class Node(var value: A, var prev: Node,  var next: Node)
  // o next é do tipo Node, se refereindo ao próximo nó
  private var head: Node = null
  private var tail: Node = null
  private var _size: Int = 0


  // Cria um array de tamanho um e exclui o primeiro elemento.
  // Como é uma lista circular, o elemento que é apontado e aponta pro primeiro e pro último ele-
  // mentos possui value vazio.
  private val end = new Node(new Array[A](1)(0), null, null)
  end.prev = end
  end.next = end

  /******************************* Definições das Funções ************************************/  

  def clear() {
    end.prev = end
    end.next = end
    _size = 0
  }

  def find(value: A): Option[Int] = {
    if(size == 0)
      return None 
    var rover = end.next
    var index = 0
    while(rover != null) {
      if(rover.value == value) {
        return Some(index); 
      }
      rover = rover.next
      index += 1
    }
    return None
  }

  def update(pos: Int, value: A): Option[A] = {
    if(pos < 0 || pos > _size) // só aceita uma posicao igual ou maior que 0
      throw ArrayIndexOutOfBounds("the position of the argument must be between 0 and size")
    var rover = end.next // para começar a buscar o elemento, é interessante começar pela cabeça

    for(i <- 0 until pos) // o rover vai se locomovendo até o final da lista
      rover = rover.next // rover caminha pela lista
    rover.value = value
    return Some(rover.value)
  }

  def elementAt(pos: Int): Option[A] = {
    if(pos < 0 || pos > _size) // só aceita uma posicao igual ou maior que 0
      throw ArrayIndexOutOfBounds("the position of the argument must be between 0 and size")
    var rover = end.next // A construção da lista circular começa pelo elemento após o end

    for(i <- 0 until pos) // o rover vai se locomovendo até o final da lista
      rover = rover.next // rover caminha pela lista
    return Some(rover.value)
  }

  def insert(pos: Int, value: A): Unit = {
    if(pos < 0 || pos > _size )
      throw ArrayIndexOutOfBounds("the position of the argument must be between 0 and size")
    else if(pos >= 0 || pos <= _size) {
      var rover = end.next 
      // Na lista circular, ao encontrar o nó já é possível inseri-lo, sem a necessidade de parar
      // um elemento antes para tal ação
      for(i <- 0 until pos)
        rover = rover.next
      val newNode = new Node(value, rover.prev, rover)
      rover.prev.next = newNode
      rover.prev = newNode
      _size += 1
      if(rover.next == null)
        tail = rover;
    }
  }

  def remove(pos: Int): Unit = {
    if(pos < 0 || pos > _size) // só aceita uma posicao igual ou maior que 0
      throw ArrayIndexOutOfBounds("the position of the argument must be between 0 and size")
    
    _size -= 1

    var rover = end.next // para começar a buscar o elemento, é interessante começar pela cabeça

    // Na lista circular, ao encontrar o nó já é possível removê-lo, sem a necessidade de parar
    // um elemento antes para removê-lo
    for(i <- 0 until pos) 
      rover = rover.next // rover caminha pela lista
    
    var ret = rover.value
    // o ponteiro que aponta para o elemento prev do nó next ao rover, após a remoção, deve apontar  
    // para o elemento prev do rover
    rover.next.prev = rover.prev 
    // o ponteiro que aponta para o elemento next do nó prev ao rover, após a remoção, deve apontar  
    // para o elemento next do rover
    rover.prev.next = rover.next

    if(rover.next == null)
      tail = rover 
    ret
    
  }

  def size(): Int = _size
}