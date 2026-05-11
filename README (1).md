# Assignment 4 — Graph Traversal and Representation

**Student:** Plan Nurislam  
**Group:** BDA2502  
**GitHub:** https://github.com/nurislam270408-ctrl/ADSassignment4

---

## A. Project Overview

This project implements a Graph system with BFS and DFS traversal algorithms in Java.
The graph is represented using an **Adjacency List** (HashMap).
Experiments were run on graphs of sizes **10, 30, and 100 vertices**.

---

## B. Class Descriptions

| Class | Description |
|---|---|
| `Vertex.java` | Represents a node in the graph with a unique id |
| `Edge.java` | Represents a connection between two vertices |
| `Graph.java` | Adjacency list graph with BFS and DFS methods |
| `Experiment.java` | Measures and compares BFS vs DFS performance |
| `Main.java` | Runs the full program with small, medium, large graphs |

---

## C. Algorithms

### BFS — Breadth First Search
- Uses a **Queue (FIFO)**
- Visits all neighbors level by level before going deeper
- **Time Complexity: O(V + E)**
- Best for: finding shortest path

### DFS — Depth First Search
- Uses **recursion (Stack)**
- Goes as deep as possible before backtracking
- **Time Complexity: O(V + E)**
- Best for: exploring all paths, detecting cycles

---

## D. Experimental Results

| Graph Size | BFS Time | DFS Time | Faster |
|---|---|---|---|
| 10 vertices | 254,900 ns | 239,200 ns | DFS |
| 30 vertices | 456,700 ns | 654,600 ns | BFS |
| 100 vertices | 1,606,200 ns | 1,944,300 ns | BFS |

---

## E. Analysis

**Which was faster?**  
For small graphs DFS was slightly faster. For larger graphs BFS was faster. Both have O(V+E) complexity so differences depend on graph structure.

**Do results match Big-O?**  
Yes. Both algorithms grew proportionally with graph size, matching O(V+E) theory.

**BFS vs DFS — when to use?**  
BFS — shortest path. DFS — all paths, cycle detection.
