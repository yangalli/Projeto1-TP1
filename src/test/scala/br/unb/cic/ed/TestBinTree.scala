package br.unb.cic.ed

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


class TestBinTree extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "A tree"

  it should "return true if we call exist(3) in a tree with values 7, 5, 3, 6, 8" in {
    val bt = new br.unb.cic.ed.BinTreeImpl[Int]

    bt.insert(7)
    bt.insert(5)
    bt.insert(3)
    bt.insert(6)
    bt.insert(8)

    bt.exists(3) should be (true)
  }

  it should "return false if you try to remove from an empty tree" in {
    val bt = new br.unb.cic.ed.BinTreeImpl[Int]
    
    intercept[ArrayIndexOutOfBounds] {
      bt.remove(3)
    }
  }

  it should "return false if we call exist(3) in a tree with values 7, 5, 3, 6, 8 and remove 3" in {
    val bt = new br.unb.cic.ed.BinTreeImpl[Int]

    bt.insert(7)
    bt.insert(5)
    bt.insert(3)
    bt.insert(6)
    bt.insert(8)

    bt.exists(3) should be (true)

    bt.remove(3) /* leaf */

    bt.exists(3) should be (false)
  }

  it should "return false if we call exist(8) in a tree with values 7, 5, 3, 6, 8, 10 and remove 8, 1 children right" in {
    val bt = new br.unb.cic.ed.BinTreeImpl[Int]

    bt.insert(7)
    bt.insert(5)
    bt.insert(3)
    bt.insert(6)
    bt.insert(8)
    bt.insert(10)

    bt.exists(8) should be (true)

    bt.remove(8)  /* 1 children */

    bt.exists(8) should be (false)
    bt.exists(10) should be (true)
  }

  it should "return false if we call exist(5) in a tree with values 7, 5, 3, 8 and remove 5, 1 childrem left" in {
    val bt = new br.unb.cic.ed.BinTreeImpl[Int]

    bt.insert(7)
    bt.insert(5)
    bt.insert(3)
    bt.insert(8)

    bt.exists(5) should be (true)

    bt.remove(5)  /* 1 children */

    bt.exists(5) should be (false)
    bt.exists(3) should be (true)
  }

  it should "return false if we call exist(7) in a tree with values 7, 5, 3, 6, 8 and remove 7, 2 children node" in {
    val bt = new br.unb.cic.ed.BinTreeImpl[Int]

    bt.insert(7)
    bt.insert(5)
    bt.insert(3)
    bt.insert(6)
    bt.insert(8)

    bt.exists(7) should be (true)

    bt.remove(7)  /* 2 children */

    bt.exists(7) should be (false)
    bt.exists(8) should be (true)
  }

  it should "return false if we call exist(5) in a tree with values 7, 5, 6, 8 and remove 5, 1 children node" in {
    val bt = new br.unb.cic.ed.BinTreeImpl[Int]

    bt.insert(7)
    bt.insert(5)
    bt.insert(6)
    bt.insert(8)

    bt.exists(5) should be (true)

    bt.remove(5) /* 1 children */

    bt.exists(5) should be (false)
    bt.exists(6) should be (true)
  }

}