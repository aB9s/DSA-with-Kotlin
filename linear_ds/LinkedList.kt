package org.example.DSA.linear_ds

import org.example.DSA.node.Node

class LinkedList<T> {

    private var head: Node<T>? = null   // starting node in the linked list
    private var tail: Node<T>? = null   // last node in the linked list
    var size: Int = 0; private set     // size of the linked list

    /**
     * Inserts a new node at the end (tail) of the list.
     */
    fun insert(value: T) {
        val newNode = Node(value)

        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            newNode.previous = tail
            tail = newNode
        }

        size++
    }

    /**
     * Searches for a node with the given value.
     */
    fun search(value: T): Node<T>? {
        var currentNode: Node<T>? = head

        while (currentNode != null) {
            if (currentNode.value == value) {
                return currentNode
            } else {
                currentNode = currentNode.next
            }
        }

        return null // Node with the given value is not present in the list
    }

    /**
     * Deletes a node with the given value.
     * If the node with the given value is not present, return false. Otherwise, delete the node and return true.
     *
     * Use cases to consider:
     * 1. List is empty
     * 2. Node to remove is the only node in the list (head and tail node at the same time)
     * 3. We are removing a head node
     * 4. We are removing a tail node
     * 5. Node to remove is somewhere between the two nodes
     * 6. Node to remove is not present in the list
     */
    fun delete(value: T): Boolean {
        if (head == null) return false // Use case #1

        if (value == head?.value) {
            if (head == tail) { // Use case #2
                head = null
                tail = null
            } else if (head?.next != null) { // Use case #3
                head = head?.next
                head?.previous = null
            }
            size--
            return true
        }

        var currentNode = head
        while (currentNode?.next != null && value != currentNode.next?.value) {
            currentNode = currentNode.next
        }

        if (currentNode?.next != null) {
            if (currentNode.next == tail) {
                tail = currentNode // Use case #4
            } else {
                currentNode.next = currentNode.next?.next // Use case #5
                currentNode.next?.previous = currentNode
            }
            size--
            return true
        }

        return false // Use case #6
    }

    fun isEmpty(): Boolean = head == null

    fun forwardTraverse() {
        if (isEmpty()) {
            println("List is Empty")
            return
        }
        var cNode = head
        while (null != cNode) {
            println(cNode.value)
            cNode = cNode.next
        }
    }

    fun reverseTraverse() {
        if (isEmpty()) {
            println("List is Empty")
            return
        }
        var cNode = tail
        while (null != cNode) {
            println(cNode.value)
            cNode = cNode.previous
        }
    }
}
