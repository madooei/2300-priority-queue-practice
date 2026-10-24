package practice;

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
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Returns true if no node in the subtree rooted at node holds a value
  // larger than either of its children.
  private static <T extends Comparable<T>> boolean isOrdered(Node<T> node) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Returns true if the tree rooted at root is complete: in level order, no
  // node comes after a missing child.
  private static <T> boolean isComplete(Node<T> root) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }
}
