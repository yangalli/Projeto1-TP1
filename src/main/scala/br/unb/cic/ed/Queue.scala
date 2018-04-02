package br.unb.cic.ed

trait Queue[A]{
    def enqueue(value: A): Unit
    def dequeue(): Option[A]
    def size(): Int
    def isEmpty(): Boolean
    def getFront(): A
    def getBack(): A
}