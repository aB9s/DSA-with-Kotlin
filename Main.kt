package org.example

import org.example.DSA.linear_ds.SinglyLinkedList

fun main() {

    // Linked Lists
    runLinkedList()
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