package br.unb.cic.ed

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestHashMap extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "A Hash Map"

  var hashmap: br.unb.cic.ed.HashMap[Int] = _

  before {
    hashmap = new br.unb.cic.ed.ImpHashMap[Int](10)
  }
  
  it should "have the correct elements inserted" in {

    hashmap.set("a", 1)
    hashmap.set("b", 2) 

    hashmap.get("a") should be (Some(1))
    hashmap.get("b") should be (Some(2))
  }

  it should "have the correct elements removed" in {

    hashmap.set("a", 1)
    hashmap.set("b", 2)
    hashmap.set("c", 3)
    hashmap.delete("a")

    hashmap.get("a") should be (None)
    hashmap.get("b") should be (Some(2))
  }

  it should "be able to treat colisions" in {

    hashmap.set("a", 1)
    hashmap.set("b", 2)
    hashmap.set("c", 3)
    hashmap.set("a", 4)
    
    hashmap.get("a") should be (Some(4))
    hashmap.get("b") should be (Some(2))
  }

}