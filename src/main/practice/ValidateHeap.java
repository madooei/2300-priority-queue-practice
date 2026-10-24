package practice;

import queue.LinkedQueue;
import queue.Queue;
import tree.Node;

/** A solution to the problem of validating a binary heap. */
public final class ValidateHeap {

  private ValidateHeap() {
    // This class should not be instantiated!
  }

  // Returns true if the tree rooted at root is a valid min-heap: it is a
  // complete binary tree, and no node holds a value larger than either of its
  // children. The empty tree is valid. Duplicate values are allowed.
  public static <T extends Comparable<T>> boolean isMinHeap(Node<T> root) {
    return isOrdered(root) && isComplete(root);
  }

  // Returns true if no node in the subtree rooted at node holds a value
  // larger than either of its children.
  private static <T extends Comparable<T>> boolean isOrdered(Node<T> node) {
    if (node == null) {
      return true;
    }
    if (node.left != null && node.left.value.compareTo(node.value) < 0) {
      return false;  // the left child outranks its parent
    }
    if (node.right != null && node.right.value.compareTo(node.value) < 0) {
      return false;  // the right child outranks its parent
    }
    return isOrdered(node.left) && isOrdered(node.right);
  }

  // Returns true if the tree rooted at root is complete: in level order, no
  // node comes after a missing child.
  private static <T> boolean isComplete(Node<T> root) {
    if (root == null) {
      return true;
    }
    Queue<Node<T>> queue = new LinkedQueue<>();
    queue.enqueue(root);
    boolean gap = false;  // have we passed a missing child yet?
    while (!queue.isEmpty()) {
      Node<T> node = queue.front();
      queue.dequeue();
      if (node.left == null) {
        gap = true;
      } else if (gap) {
        return false;  // a node after a missing child
      } else {
        queue.enqueue(node.left);
      }
      if (node.right == null) {
        gap = true;
      } else if (gap) {
        return false;  // a node after a missing child
      } else {
        queue.enqueue(node.right);
      }
    }
    return true;
  }
}
