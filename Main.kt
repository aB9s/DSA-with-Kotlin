package org.example

import org.example.DSA.linear_ds.SinglyLinkedList
import org.example.DSA.trees.BasicBinaryTree

fun main() {

    // Linked Lists
//    runLinkedList()

    // Binary Trees
    runBinaryTrees()
}

private fun runLinkedList() {
    println("\n")
    println("\t\t\t\tLinked Lists\t\t\t\t")
    println("************************************************\n\n")
    runSinglyLinkedList()
    println("************************************************\n\n")
}

private fun runSinglyLinkedList() {
    println("****\tSingly Linked Lists\t****\n")
    val singlyLinkedList: SinglyLinkedList<String> = SinglyLinkedList()

    println("Size of the list: ${singlyLinkedList.size}")
    println("Is Singly linked list empty?\t${singlyLinkedList.isEmpty()}\n")

    for (letter in 'A'..'Z' step 4) {
        singlyLinkedList.insert(letter.toString())
    }

    println("Size of the list: ${singlyLinkedList.size}\n")

    println("Print Singly LinkedList:")
    singlyLinkedList.forwardTraverse()
    println("\n")

    println("Reverse traverse Singly LinkedList:")
    singlyLinkedList.reverseTraverse()
    println("\n")

    println(
        "Is letter \'Q\' present in the list?\n" +
                "Ans: ${if (singlyLinkedList.search('Q'.toString()) != null) "yes" else "no"}"
    )

    println(
        "Is letter \'D\' present in the list?\n" +
                "Ans: ${if (singlyLinkedList.search('D'.toString()) != null) "yes" else "no"}"
    )

    println("Delete letter \'U\' from the list")
    singlyLinkedList.delete('U'.toString())
    println("Size of the list: ${singlyLinkedList.size}\n")

    println("Print Singly LinkedList:")
    singlyLinkedList.forwardTraverse()
    println("\n")

}


fun runBinaryTrees() {
    val bTree = BasicBinaryTree<Int>()

    bTree.insert(16)
    bTree.printTreeNode()

    bTree.insert(listOf(17, 19,3,21,15,3,12,34), BasicBinaryTree.ExecutionType.IterationExecution)

    println("\nPrint Tree Node: Post Order\n")
    bTree.printTreeNode(BasicBinaryTree.BinaryTraverseType.Postorder)

    println("\nPrint Tree Node: Pre Order\n")
    bTree.printTreeNode(BasicBinaryTree.BinaryTraverseType.Preorder)

    println("\nPrint Tree Node: In Order\n")
    bTree.printTreeNode(BasicBinaryTree.BinaryTraverseType.Inorder)
}