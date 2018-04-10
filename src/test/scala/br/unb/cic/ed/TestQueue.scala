package br.unb.cic.ed

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestQueue extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

    behavior of "A Queue"

    var queue: br.unb.cic.ed.Queue[Int] = _

    before{
        queue = new br.unb.cic.ed.LinkedQueue[Int](new LinkedList[Int]())
    }

    it should "have size == 0 before queueing elemensts" in {
        queue.size() should be (0)
    }

    it should "return None when we call the dequeue on em empty Queue" in {
        queue.dequeue() should be (None)
    }

    it should " have size 3 after adding [1,2,3]" in {
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)

        queue.size() should be (3)
    }

    it should "return 1 after enqueueing [1,2,3] and dequeueing once" in {
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)

        queue.dequeue() should be (Some(1))
    }

    /*
    it should "have front and back pointing to the same value when adding 1 " in {
        queue.enqueue(1)

        queue.getFront() should be (1)
        queue.getBack() should be (1)
    }
    it should "have the front pointing to 2 after dequeing [1,2,3]" in {
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)
        queue.dequeue()

        queue.getFront() should be (2)
        queue.getBack() should be (3)
    }

    it should "point to null after dequeueing all elements" in {
        queue.enqueue(1)
        queue.dequeue()

        intercept[IllegalArgumentException]{
            queue.getFront()
            queue.getBack()
        }
    }
    */
}    