package br.unb.cic.ed

class ArrayStack[A](private val elements: br.unb.cic.ed.List[A]) extends Stack[A] {

  private var _size = 0

  def push(value: A): Unit = {
    elements.insert(_size, value)
    _size += 1
  }

  def pop(): Option[A] = {
    val res = elements.elementAt(_size-1)
    res match {
      case Some(v) => {
        elements.remove(_size-1)
        _size -= 1
      }
      case None => {}
    }
    return res
  }

  def top(): Option[A] = elements.elementAt(_size-1)

  def size() : Int = _size
}