package br.unb.cic.ed

trait Graph {
    def addEdge(src: Int, dest: Int, weight: Int = 1): Unit
}