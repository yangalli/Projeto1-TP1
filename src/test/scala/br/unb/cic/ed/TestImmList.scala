package br.unb.cic.ed

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestImmutableList extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {
  behavior of "An immutable list"

  it should "return a Nil list if MyNil is Empty" in {
    MyNil.length should be (0)
  }

  it should "return a list of size 1 when 1 element is inserted" in {
    val l1 = new Cons(1, MyNil) 
    l1.length should be (1)
  }

  it should "return a list of size 5 when 5 elements are inserted" in {
    val l1 = 5 :: MyNil
    val l2 = 6 :: 7 :: 8 :: 9 :: l1
    l2.length should be (5)
  }

  
}