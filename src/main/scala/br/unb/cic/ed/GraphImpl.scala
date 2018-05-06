package br.unb.cic.ed


class GraphImpl(val V: Int) extends Graph {

    case class Edge(val dest: Int, val weight: Int)
    class Vertex {
        val edges = new LinkedList[Edge]()
    }

    val graph = Array.fill(V)(new Vertex)

    def addEdge(src: Int, dest: Int, weight: Int = 1) {
        val edge = Edge(dest, weight)
        graph(src).edges.insert(0, edge)
    }
    
}