package org.example.DSA.algorithms

// This is a generic extension function that sorts a mutable list of comparable elements using the simple bubble sort algorithm
fun <T : Comparable<T>> MutableList<T>.simpleBubbleSort() {
    // Loop through the list from the first to the second last element
    for (i in 0 until size - 1) {
        // Loop through the remaining elements from the first to the last element
        for (j in 0 until size - 1) {
            // Compare the current element with the next one
            if (this[j] > this[j + 1]) {
                // Swap the elements if they are in the wrong order
                val temp = this[j]
                this[j] = this[j + 1]
                this[j + 1] = temp
            }
        }
    }
}

// This is a generic extension function that sorts a mutable list of comparable elements using the optimized bubble sort algorithm
fun <T : Comparable<T>> MutableList<T>.optimizedBubbleSort() {
    // Declare a boolean variable to keep track of whether any swap occurred in the inner loop
    var isSwapped = false

    // Loop through the list from the first to the second last element
    for (i in 0 until size - 1) {
        // Set the boolean variable to false at the beginning of each iteration
        isSwapped = false
        // Loop through the remaining unsorted elements from the first to the last element
        for (j in 0 until size - i - 1) {
            // Compare the current element with the next one
            if (this[j] > this[j + 1]) {
                // Swap the elements if they are in the wrong order
                val temp = this[j]
                this[j] = this[j + 1]
                this[j + 1] = temp
                // Set the boolean variable to true to indicate that a swap occurred
                isSwapped = true
            }
        }
        // If no swap occurred in the inner loop, it means the list is already sorted and the function can break out of the outer loop
        if (!isSwapped) {
            break
        }
    }
}
