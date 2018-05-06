package br.unb.cic.ed

abstract class BinTree[A <% Ordered[A]] {
    def insert(value: A): Unit
    def exists(value: A): Boolean
    def remove(value: A): Unit
}