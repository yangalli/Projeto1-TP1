package br.unb.cic.ed

class NodeTree[A <% Ordered[A]](var value: A,var left: NodeTree[A] = null,var right: NodeTree[A] = null) {

    def insert(v: A) {
        if(v <= value) {
            if(left == null) left = new NodeTree(v)
            else left.insert(v)
        }
        else {
            if(right == null) right = new NodeTree[A](v)
            else right.insert(v)
        }
    }

    def exists(v: A): Boolean =
        if(v == value) true
        else if(v <= value && left != null) left.exists(v)
        else if(right != null) right.exists(v)
        else false
    
    def remove(v: A, parent: NodeTree[A] = null) {
        if(v < value && left != null) left.remove(v, this)
        else if (v > value && right != null) right.remove(v, this)
        else {
            if (left != null && right != null) {
                value = right.minValue()
                right.remove(value, this)
            } else if (parent.left == this) {
                if(left != null) parent.left = left
                else parent.left = right
            } else if (parent.right == this) {
                if(left != null) parent.right = left
                else parent.right = right
            }
        }
    }

    def minValue(): A = {
        if (left == null) value
        else left.minValue()
    }

}
                                                                      
class BinTreeImpl[A <% Ordered[A]] extends BinTree[A] {

    var root: NodeTree[A] = null

    def insert(value: A) {

        if(root == null) root = new NodeTree[A](value)
        else root.insert(value)
    }

    def exists(value: A): Boolean =
        if(root == null) false
        else root.exists(value)

    def remove(value: A) {

        if(root == null) throw ArrayIndexOutOfBounds("Arvore vazia") /* throw error */
        else root.remove(value)
    }
}