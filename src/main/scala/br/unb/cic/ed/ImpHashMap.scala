package br.unb.cic.ed

class ImpHashMap[A](maxSize: Int) extends HashMap[A] {
  require(maxSize > 0)

  private var size = 0
  private var data = new Array[ImpHashMap.Node[A]](maxSize)

  // Creates empty nodes
  for (i <- 0 until maxSize) {
    data(i) = ImpHashMap.Node("", null.asInstanceOf[A], null)
  }

  // finds the node to be changed
  private def find(key: String, head: ImpHashMap.Node[A]): ImpHashMap.Node[A] = {
    var n = head
    while (n.next != null && n.next.key != key)
      n = n.next
    n
  }

  // set the value of the empty node to another value 
  def set(key: String, value: A) = {
    val bucket = key.hashCode % maxSize
    val n = find(key, data(bucket))
    if (n.next != null) {
      n.next.value = value
    }
    else {
      data(bucket).key = key
      data(bucket).value = value
      data(bucket) = ImpHashMap.Node("", null.asInstanceOf[A], data(bucket))
      size += 1
    }
  }

  // returns the value of the node or None
  def get(key: String): Option[A] = {
    val bucket = key.hashCode % maxSize
    val n = find(key, data(bucket))
    if (n.next != null)
      Some(n.next.value)
    else
      None
  }

  // deletes a node
  def delete(key: String): Option[A] = {
    val bucket = key.hashCode % maxSize
    val n = find(key, data(bucket))
    if (n.next != null) {
      val value = n.next.value
      n.next = n.next.next
      size -= 1
      Some(value)
    }
    else
      None
  }
}

object ImpHashMap {
    // Nodes to treat collisions
    private case class Node[A](var key: String, var value: A, var next: Node[A])
}