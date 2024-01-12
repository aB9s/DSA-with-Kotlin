package org.example.DSA.trees

import org.example.DSA.node.TreeNode

class BasicBinaryTree<T : Comparable<T>> {
    var root: TreeNode<T>? = null; private set

    fun insert(data: T, executionType: ExecutionType = ExecutionType.IterationExecution) {
        val cNode = TreeNode(data = data)

        if (null == root) {
            root = cNode
            return
        }

        when (executionType) {
            is ExecutionType.RecursionExecution -> insertByRecursion(data, root)
            is ExecutionType.IterationExecution -> insertByIteration(data, root!!)
        }

    }

    fun insert(dataList: List<T>, executionType: ExecutionType) {
        for (data in dataList) {
            insert(data, executionType)
        }
    }

    private tailrec fun insertByRecursion(data: T, cNode: TreeNode<T>?) {
        if (null == cNode) return

        if (data < cNode.data) {
            if (null != cNode.left) {
                insertByRecursion(data, cNode.left)
            } else {
                cNode.left = TreeNode(data)
            }
        } else if (data > cNode.data) {
            if (null != cNode.right) {
                insertByRecursion(data, cNode.right)
            } else {
                cNode.right = TreeNode(data)
            }
        }
    }

    fun insertByIteration(data: T, node: TreeNode<T>) {
        var cNode: TreeNode<T>? = node
        val nNode: TreeNode<T> = TreeNode(data)
        while (null != cNode) {
            if (data < cNode.data) {
                if (null != cNode.left) {
                    cNode = cNode.left
                } else {
                    cNode.left = nNode
                    break
                }
            } else if (data > cNode.data) {
                if (null != cNode.right) {
                    cNode = cNode.right
                } else {
                    cNode.right = nNode
                    break
                }
            } else {
                break
            }
        }
    }

    fun printTreeNode(traverseType: BinaryTraverseType = BinaryTraverseType.Preorder) {
        if (null == root) {
            println("Binary Tree is empty.")
            return
        }

        when (traverseType) {
            is BinaryTraverseType.Postorder -> postOrderTraverse(root)
            is BinaryTraverseType.Preorder -> preorderTraverse(root)
            is BinaryTraverseType.Inorder -> inOrderTraverse(root)
        }
    }

    private fun preorderTraverse(node: TreeNode<T>?) {
        if (null == node) return

        println("${node.data}")

        // traverse left side
        preorderTraverse(node.left)
        // traverse right side
        preorderTraverse(node.right)

    }

    private fun postOrderTraverse(node: TreeNode<T>?) {
        if (null == node) return

        // traverse left side
        postOrderTraverse(node.left)
        // traverse right side
        postOrderTraverse(node.right)

        println("${node.data}")
    }

    private fun inOrderTraverse(node: TreeNode<T>?) {
        if (null == node) return

        // traverse left side
        inOrderTraverse(node.left)

        println("${node.data}")

        // traverse right side
        inOrderTraverse(node.right)
    }

    sealed class BinaryTraverseType {
        data object Preorder : BinaryTraverseType()
        data object Postorder : BinaryTraverseType()
        data object Inorder : BinaryTraverseType()
    }

    sealed class ExecutionType {
        data object RecursionExecution : ExecutionType()
        data object IterationExecution : ExecutionType()
    }
}
