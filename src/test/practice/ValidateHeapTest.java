package practice;

import org.junit.jupiter.api.Test;
import tree.Node;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Tests for the validate-a-heap problem. Each test is one scenario. */
public class ValidateHeapTest {

  @Test
  public void emptyTreeIsValid() {
    assertTrue(ValidateHeap.isMinHeap(null));
  }

  @Test
  public void singleNodeIsValid() {
    assertTrue(ValidateHeap.isMinHeap(new Node<>(42)));
  }

  @Test
  public void rightChildWithoutLeftChildIsInvalid() {
    Node<Integer> root = new Node<>(1);
    root.right = new Node<>(2);
    assertFalse(ValidateHeap.isMinHeap(root));
  }

  @Test
  public void duplicateValuesAreValid() {
    Node<Integer> root = new Node<>(1);
    root.left = new Node<>(1);
    root.right = new Node<>(1);
    assertTrue(ValidateHeap.isMinHeap(root));
  }

  @Test
  public void maxHeapIsInvalid() {
    Node<Integer> root = new Node<>(9);
    root.left = new Node<>(5);
    root.right = new Node<>(3);
    assertFalse(ValidateHeap.isMinHeap(root));
  }

  @Test
  public void rightChildSmallerThanParentIsInvalid() {
    Node<Integer> root = new Node<>(2);
    root.left = new Node<>(3);
    root.right = new Node<>(1);
    assertFalse(ValidateHeap.isMinHeap(root));
  }

  @Test
  public void brokenOrderAndGapIsInvalid() {
    Node<Integer> root = new Node<>(4);
    root.left = new Node<>(2);
    root.left.right = new Node<>(6);
    assertFalse(ValidateHeap.isMinHeap(root));
  }

  @Test
  public void newLevelBeforeTheLastIsFullIsInvalid() {
    // Level 2 is missing 3 of its 4 nodes, yet level 3 has started.
    Node<Integer> root = new Node<>(1);
    root.left = new Node<>(2);
    root.right = new Node<>(3);
    root.left.left = new Node<>(4);
    root.left.left.left = new Node<>(5);
    assertFalse(ValidateHeap.isMinHeap(root));
  }

  @Test
  public void gapBeforeTheLastNodeIsInvalid() {
    // Example 3 on the problem page: 3 has no right child, but 2 has a left child.
    Node<Integer> root = new Node<>(1);
    root.left = new Node<>(3);
    root.right = new Node<>(2);
    root.left.left = new Node<>(5);
    root.right.left = new Node<>(8);
    assertFalse(ValidateHeap.isMinHeap(root));
  }

  @Test
  public void sixNodeHeapIsValid() {
    // Example 1 on the problem page: 1; 3, 2; 5, 4, 8.
    Node<Integer> root = new Node<>(1);
    root.left = new Node<>(3);
    root.right = new Node<>(2);
    root.left.left = new Node<>(5);
    root.left.right = new Node<>(4);
    root.right.left = new Node<>(8);
    assertTrue(ValidateHeap.isMinHeap(root));
  }

  @Test
  public void childSmallerThanParentIsInvalid() {
    // Example 2 on the problem page: the last value is 0, below its parent 2.
    Node<Integer> root = new Node<>(1);
    root.left = new Node<>(3);
    root.right = new Node<>(2);
    root.left.left = new Node<>(5);
    root.left.right = new Node<>(4);
    root.right.left = new Node<>(0);
    assertFalse(ValidateHeap.isMinHeap(root));
  }

  @Test
  public void valuesAcrossSubtreesNeedNoOrder() {
    // 10 sits in the left subtree and 3 in the right one. A heap does not
    // order values across subtrees, so 10 > 3 is fine.
    Node<Integer> root = new Node<>(1);
    root.left = new Node<>(10);
    root.right = new Node<>(2);
    root.left.left = new Node<>(11);
    root.left.right = new Node<>(12);
    root.right.left = new Node<>(3);
    assertTrue(ValidateHeap.isMinHeap(root));
  }

  @Test
  public void perfectHeapIsValid() {
    Node<Integer> root = new Node<>(1);
    root.left = new Node<>(2);
    root.right = new Node<>(3);
    root.left.left = new Node<>(4);
    root.left.right = new Node<>(5);
    root.right.left = new Node<>(6);
    root.right.right = new Node<>(7);
    assertTrue(ValidateHeap.isMinHeap(root));
  }
}
