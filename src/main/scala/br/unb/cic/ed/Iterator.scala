package br.unb.cic.ed

trait Iterator[A] {
    def hasNext(): Boolean
    def next(): Unit
    def current(): A
}