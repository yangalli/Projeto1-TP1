package br.unb.cic.ed

//Grafo sem peso

class GraphImpl[A](val V: Int) extends Graph[A] {

    val edges = Array.fill(V)(new LinkedList[Int])

    def addEdge(src: Int, dest: Int) {
        edges(src).insert(0, dest)
        edges(dest).insert(0, src)
    }

}