# Priority Queue — Practice

One practice problem on the binary heap: check whether a binary tree is a valid min-heap. The problem has a JUnit suite.

## Prerequisites

- JDK 17+ (JUnit 6 requires it).
- The JUnit jar is already vendored in `lib/`; there is nothing to download.

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  lib/
    junit-platform-console-standalone-6.1.0.jar
  src/
    main/
      practice/
        ValidateHeap.java          # is a binary tree a valid min-heap?
      tree/
        Node.java                  # the binary-tree node from the tree chapter
      queue/
        Queue.java                 # the Queue ADT
        LinkedQueue.java           # a linked-list Queue
    test/
      practice/
        ValidateHeapTest.java
  scripts/
    test.sh                        # compile and run the JUnit tests
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh practice.ValidateHeapTest` — compiles everything and runs only that test class.

There is no demo program for this problem; the tests are how you check your work.

## What's here

- `practice.ValidateHeap` — `isMinHeap`, which returns whether a binary tree is complete and has no node larger than either of its children. It uses two private helpers, `isOrdered` and `isComplete`. The empty tree is valid, and duplicate values are allowed.
- `tree.Node<T>` — the binary-tree node from the tree chapter, with a value and a left and a right child. It is a copy, included so this code compiles and runs on its own.
- `queue.Queue<T>` and `queue.LinkedQueue<T>` — the Queue ADT and its linked-list implementation, copied so this code compiles and runs on its own. `isComplete` uses a queue for its level-order walk.
- `practice.ValidateHeapTest` — tests for the problem.
