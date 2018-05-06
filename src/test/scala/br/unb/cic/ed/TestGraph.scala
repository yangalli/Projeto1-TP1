package br.unb.cic.ed

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


class TestGraph extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

    behavior of "A Graph"

    var graph: br.unb.cic.ed.Graph = _

    before {
        graph = new br.unb.cic.ed.GraphImpl(4)
    }

    it should "be able to add edges" in {

        graph.addEdge(0,1)
        graph.addEdge(0,2)
        graph.addEdge(0,3)
        graph.addEdge(1,3)
        graph.addEdge(1,2)
        graph.addEdge(2,3)
        
    }

}  