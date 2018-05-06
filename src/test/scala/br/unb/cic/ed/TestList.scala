package br.unb.cic.ed

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestList extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "A List"

  var list: br.unb.cic.ed.List[Int] = _

  before {
    list = new br.unb.cic.ed.LinkedList[Int]()
    /* list = new br.unb.cic.ed.ArrayList[Int]() */
  }

  it should "have size == 0 before inserting any element" in {

    list.size() should be (0) 
  }

  it should "have size == 0 after clearing the list" in {

    list.insert(0, 5)
    list.insert(1, 6)
    list.clear()

    list.size() should be (0) 
  }

  it should "have size == 3 after inserting three elements" in {

    list.insert(0, 5)
    list.insert(1, 6)
    list.insert(2, 7)

    list.size() should be (3) 
  }

  it should "update the value of any element in the list" in {
    
    list.insert(0, 5)
    list.insert(1, 6)
    list.insert(2, 7)

    list.update(0, 8)
    list.update(1, 9)
    list.update(2, 10)

    list.elementAt(0) should be (Some(8))
    list.elementAt(1) should be (Some(9))
    list.elementAt(2) should be (Some(10))
  }

  it should "should keep the list of inserted values" in {

    list.insert(0, 1)
    list.insert(1, 2)
    list.insert(2, 3)

    list.size() should be (3)
    list.elementAt(0) should be (Some(1))
    list.elementAt(1) should be (Some(2))
    list.elementAt(2) should be (Some(3)) 
  }

  it should "return Some(1) when we call find(1000) in the list [100, 1000, 10000]" in {

    list.insert(0, 100)
    list.insert(1, 1000)
    list.insert(2, 10000)

    list.find(1000) should be (Some(1))
  }

  it should "throw InvalidArgument when we call insert(1, 1) on an empty list" in {

    intercept[ArrayIndexOutOfBounds] {
      list.insert(1, 1)
    }
  }
  it should "throw InvalidArgument when we call insert(4, 4) on a list with values [1,3,4]" in {

    list.insert(0, 1)
    list.insert(1, 2)
    list.insert(2, 3)

    intercept[ArrayIndexOutOfBounds] {
      list.insert(4,4) 
    }

  }

  it should "shift the elements of a list. that is [10,30,40].insert(1,20) = [10,20,30,40]" in {
    val list = new br.unb.cic.ed.ArrayList[Int]()

    list.insert(0, 10)
    list.insert(1, 30)
    list.insert(2, 40)

    list.size() should be (3)
    list.insert(1, 20)

    list.size() should be (4)
    list.elementAt(0) should be (Some(10))
    list.elementAt(1) should be (Some(20))
    list.elementAt(2) should be (Some(30))
    list.elementAt(3) should be (Some(40))
  }

  it should "have size == 2 after inserting three elements and removing the last one" in {

    list.insert(0, 5)
    list.insert(1, 6)
    list.insert(2, 7)
    list.remove(2)

    list.size() should be (2) 
  }

  it should "have size == 2 after inserting three elements and removing the the first one" in {

    list.insert(0, 5)
    list.insert(1, 6)
    list.insert(2, 7)
    list.remove(0)

    list.elementAt(0) should be (Some(6))

    list.size() should be (2) 
  }

  it should "have BubbleSort working" in {

    var list1 = new br.unb.cic.ed.ArrayList[Int]()

    list1.insert(0, 5)
    list1.insert(0, 7)
    list1.insert(0, 6)
    list1.insert(0, 8)
    list1.insert(0, 10)
    list1.insert(0, 15)
    list1.insert(0, 20)

    ArrayList.BubbleSort(list1)

    list1.elementAt(0) should be (Some(5))
  }

  it should "have InsertionSort working" in {

    var list1 = new br.unb.cic.ed.ArrayList[Int]()

    list1.insert(0, 5)
    list1.insert(0, 7)
    list1.insert(0, 6)
    list1.insert(0, 8)
    list1.insert(0, 10)
    list1.insert(0, 15)
    list1.insert(0, 20)

    ArrayList.InsertionSort(list1)

    list1.elementAt(0) should be (Some(5))
  }

  it should "have SelectionSort working" in {

    var list1 = new br.unb.cic.ed.ArrayList[Int]()

    list1.insert(0, 5)
    list1.insert(0, 7)
    list1.insert(0, 6)
    list1.insert(0, 8)
    list1.insert(0, 10)
    list1.insert(0, 15)
    list1.insert(0, 20)

    ArrayList.SelectionSort(list1)

    list1.elementAt(0) should be (Some(5))
  }

  it should "have QuickSort working" in {

    var list1 = new br.unb.cic.ed.ArrayList[Int]()

    list1.insert(0, 5)
    list1.insert(0, 7)
    list1.insert(0, 6)
    list1.insert(0, 8)
    list1.insert(0, 10)
    list1.insert(0, 15)
    list1.insert(0, 20)

    ArrayList.QuickSort(list1, 0, list1.size-1)

    list1.elementAt(0) should be (Some(5))
  }
  
}


