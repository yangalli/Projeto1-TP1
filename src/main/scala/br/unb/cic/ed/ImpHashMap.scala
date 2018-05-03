package br.unb.cic.ed

class ImpHashMap[A](maxSize: Int) extends HashMap[A] {
  require(maxSize > 0)

  private var size = 0
  private var data = new Array[ImpHashMap.Node[A]](maxSize)

  // Create dummy nodes.
  for (i <- 0 until maxSize) {
    data(i) = ImpHashMap.Node("", null.asInstanceOf[A], null)
  }

  /** Needs to be called on the dummy node. Returns the node *before* the
      actual node we want to find. Never returns `null`. */
  private def find(key: String, head: ImpHashMap.Node[A]): ImpHashMap.Node[A] = {
    var n = head
    while (n.next != null && n.next.key != key)
      n = n.next
    n
  }

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

  def get(key: String): Option[A] = {
    val bucket = key.hashCode % maxSize
    val n = find(key, data(bucket))
    if (n.next != null)
      Some(n.next.value)
    else
      None
  }

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

  def load(): Float = size * 1.0f / maxSize
}

// Companion object.
object ImpHashMap {
    /** Nodes for the linked lists used for hash collisions. */
    private case class Node[A](var key: String, var value: A, var next: Node[A])
}