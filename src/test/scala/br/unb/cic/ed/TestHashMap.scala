package br.unb.cic.ed

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestHashMap extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "A Hash Map"

  var map: br.unb.cic.ed.HashMap[Int] = _

  before {
    map = new br.unb.cic.ed.ImpHashMap[Int](10)
  }
  
  it should "have the correct elements inserted" in {

    map.set("a", 1)
    map.set("b", 2) 

    map.get("a") should be (Some(1))
    map.get("b") should be (Some(2))
  }
}