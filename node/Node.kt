package org.example.DSA.node

/**
 * Represents a node in a linked list.
 * Each node contains a value and references to the next and previous nodes.
 *
 * @param T The type of the value held by the node.
 *
 * @property value The value held by the node.
 * @property next Reference to the next node in the linked list.
 * @property previous Reference to the previous node in the linked list.
 */

data class Node<T>(val value: T, var next: Node<T>? = null, var previous : Node<T>?= null)