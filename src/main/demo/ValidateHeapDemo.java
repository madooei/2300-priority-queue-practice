package demo;

import practice.ValidateHeap;
import tree.Node;

/** A demo of ValidateHeap on the three example trees from the notes. */
public final class ValidateHeapDemo {

  private ValidateHeapDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    // Example 1: 1 at the root, 3 and 2 below it, then 5, 4, and 8.
    Node<Integer> first = new Node<>(1);
    first.left = new Node<>(3);
    first.right = new Node<>(2);
    first.left.left = new Node<>(5);
    first.left.right = new Node<>(4);
    first.right.left = new Node<>(8);

    // The tree is complete and no node is larger than its children. Expect true.
    System.out.println("example 1 is a min-heap: " + ValidateHeap.isMinHeap(first));

    // Example 2: the same shape, but 0 is below its parent 2.
    Node<Integer> second = new Node<>(1);
    second.left = new Node<>(3);
    second.right = new Node<>(2);
    second.left.left = new Node<>(5);
    second.left.right = new Node<>(4);
    second.right.left = new Node<>(0);

    // The order property fails at 2 and 0. Expect false.
    System.out.println("example 2 is a min-heap: " + ValidateHeap.isMinHeap(second));

    // Example 3: 3 has no right child, but 2 has a left child.
    Node<Integer> third = new Node<>(1);
    third.left = new Node<>(3);
    third.right = new Node<>(2);
    third.left.left = new Node<>(5);
    third.right.left = new Node<>(8);

    // The last level is not filled from the left. Expect false.
    System.out.println("example 3 is a min-heap: " + ValidateHeap.isMinHeap(third));
  }
}
