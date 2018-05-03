package br.unb.cic.ed

trait Graph[A] {
    def addEdge(src: Int, dest: Int): Unit
}