package br.unb.cic.ed
/* import collection.mutable */

//Grafo sem peso

class GraphImpl(val V: Int) extends Graph {

    /* val edges = Array.fill(V)(new LinkedList[Int])

    def addEdge(src: Int, dest: Int) {
        edges(src).insert(0, dest)
        edges(dest).insert(0, src)
    } */

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