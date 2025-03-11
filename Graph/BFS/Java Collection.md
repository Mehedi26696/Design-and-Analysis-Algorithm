# **Java Collections: List, ArrayList, LinkedList, Queue, and Vector**

## **1. List (Interface)**
### **Definition:**
- `List` is an **interface** in `java.util` that represents an **ordered collection**.
- Allows **duplicate elements**.
- Maintains **insertion order**.
- Supports **indexed access** (i.e., elements can be accessed by index).
- Implemented by classes like `ArrayList`, `LinkedList`, and `Vector`.

### **Common Methods:**
- `add(E e)`: Adds an element to the list.
- `get(int index)`: Returns the element at the specified position.
- `remove(int index)`: Removes the element at the specified position.
- `set(int index, E e)`: Replaces the element at the specified position.
- `size()`: Returns the number of elements.
- `contains(Object o)`: Checks if the list contains the specified element.

### **Example:**
```java
import java.util.*;

public class ListExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(); // List reference with ArrayList implementation
        list.add(10);
        list.add(20);
        list.add(30);
        
        System.out.println("List Elements: " + list); // Output: [10, 20, 30]
        System.out.println("Element at index 1: " + list.get(1)); // Output: 20
        list.remove(1);
        System.out.println("After Removal: " + list); // Output: [10, 30]
        list.set(1, 40);
        System.out.println("After Set: " + list); // Output: [10, 40]
        System.out.println("List Size: " + list.size()); // Output: 2
        System.out.println("Contains 10: " + list.contains(10)); // Output: true

        // Using LinkedList implementation
        List<String> list2 = new LinkedList<>();
        list2.add("Apple");
        list2.add("Banana");
        list2.add("Cherry");
        System.out.println("LinkedList: " + list2); // Output: [Apple, Banana, Cherry]

        // Using Vector implementation
        List<Double> list3 = new Vector<>();
        list3.add(10.5);
        list3.add(20.7);
        list3.add(30.2);
        System.out.println("Vector: " + list3); // Output: [10.5, 20.7, 30.2]
    }
}
```

---

## **2. ArrayList (Implements List)**
### **Definition:**
- `ArrayList` is a **resizable array implementation** of the `List` interface.
- Provides **fast random access** (O(1) for `get(index)`).
- **Slower insertions and deletions** (O(n) in the worst case).
- Uses **contiguous memory**, making it more memory-efficient than `LinkedList`.

### **Common Methods:**
- `add(E e)`: Adds an element at the end.
- `add(int index, E e)`: Inserts an element at a specific index.
- `get(int index)`: Retrieves an element.
- `remove(int index)`: Removes an element by index.
- `set(int index, E e)`: Replaces an element.
- `size()`: Returns the number of elements.
- `clear()`: Removes all elements.

### **Example:**
```java
import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        
        System.out.println("Fruits: " + fruits); // Output: [Apple, Banana, Cherry]
        System.out.println("Element at index 1: " + fruits.get(1)); // Output: Banana
        fruits.remove(1);
        System.out.println("After Removal: " + fruits); // Output: [Apple, Cherry]
        fruits.set(1, "Grapes");
        System.out.println("After Set: " + fruits); // Output: [Apple, Grapes]
        System.out.println("List Size: " + fruits.size()); // Output: 2
        fruits.clear();
        System.out.println("After Clear: " + fruits); // Output: []
    }
}
```

---

## **3. LinkedList (Implements List & Queue)**
### **Definition:**
- `LinkedList` is a **doubly linked list** implementation of the `List` and `Deque` interfaces.
- **Faster insertions and deletions** (O(1) at the start or end).
- **Slower random access** (O(n) for `get(index)`).
- Uses **extra memory** for storing node pointers.
- Can be used as both a **List and a Queue**.

### **Common Methods:**
- `add(E e)`: Adds an element at the end.
- `addFirst(E e)`: Adds an element at the beginning.
- `addLast(E e)`: Adds an element at the end.
- `get(int index)`: Retrieves an element.
- `remove(int index)`: Removes an element by index.
- `removeFirst()`: Removes the first element.
- `removeLast()`: Removes the last element.
- `size()`: Returns the number of elements.
- `peekFirst()`: Retrieves, but does not remove, the first element.
- `peekLast()`: Retrieves, but does not remove, the last element.

### **Example:**
```java
import java.util.*;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();
        
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        
        System.out.println("LinkedList: " + numbers); // Output: [1, 2, 3]
        System.out.println("Element at index 1: " + numbers.get(1)); // Output: 2
        numbers.addFirst(0); // Insert at the beginning
        numbers.addLast(4);  // Insert at the end
        System.out.println("After Insertion: " + numbers); // Output: [0, 1, 2, 3, 4]
        numbers.remove(2);
        System.out.println("After Removal: " + numbers); // Output: [0, 1, 3, 4]
        numbers.removeFirst();
        System.out.println("After Remove First: " + numbers); // Output: [1, 3, 4]
        numbers.removeLast();
        System.out.println("After Remove Last: " + numbers); // Output: [1, 3]
        System.out.println("List Size: " + numbers.size()); // Output: 2
        System.out.println("Peek First: " + numbers.peekFirst()); // Output: 1
        System.out.println("Peek Last: " + numbers.peekLast()); // Output: 3
    }
}
```

---

## **4. Queue (Interface)**
### **Definition:**
- `Queue` is an interface that represents a **FIFO (First In, First Out) data structure**.
- Implemented by `LinkedList`, `PriorityQueue`, and `ArrayDeque`.
- Common methods:
  - `offer(E e)`: Adds an element to the queue.
  - `poll()`: Retrieves and removes the **head** (first element).
  - `peek()`: Retrieves but does **not remove** the head.
  - `remove()`: Removes the head element.
  - `size()`: Returns the number of elements.

### **Example: Using LinkedList as a Queue**
```java
import java.util.*;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        
        System.out.println("Queue: " + queue); // Output: [A, B, C]
        System.out.println("Polled Element: " + queue.poll()); // Removes A
        System.out.println("Queue after poll: " + queue); // Output: [B, C]
        System.out.println("Peek Element: " + queue.peek()); // Output: B
        queue.remove();
        System.out.println("Queue after remove: " + queue); // Output: [C]
        System.out.println("Queue Size: " + queue.size()); // Output: 1
    }
}
```

---

## **5. Vector (Implements List)**
### **Definition:**
- `Vector` is a **dynamic array implementation** of the `List` interface.
- **Synchronized** for thread safety.
- **Slower** than `ArrayList` in single-threaded environments.
- Allows **duplicate elements**.
- Supports **indexed access**.

### **Common Methods:**
- `add(E e)`: Adds an element at the end.
- `get(int index)`: Retrieves the element at the specified index.
- `remove(int index)`: Removes the element at the specified index.
- `size()`: Returns the number of elements.
- `capacity()`: Returns the current capacity.
- `ensureCapacity(int minCapacity)`: Ensures the vector can accommodate at least the specified number of elements.
- `clone()`: Creates and returns a shallow copy of the vector.
- `elementAt(int index)`: Similar to `get()`, it retrieves the element at the specified index.

### **Example:**
```java
import java.util.*;

public class VectorExample {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();

        vector.add("Apple");
        vector.add("Banana");
        vector.add("Cherry");
        
        System.out.println("Vector: " + vector); // Output: [Apple, Banana, Cherry]
        System.out.println("Element at index 1: " + vector.get(1)); // Output: Banana
        vector.remove(1);
        System.out.println("After Removal: " + vector); // Output: [Apple, Cherry]
        vector.set(1, "Grapes");
        System.out.println("After Set: " + vector); // Output: [Apple, Grapes]
        System.out.println("List Size: " + vector.size()); // Output: 2
        System.out.println("Current Capacity: " + vector.capacity()); // Output: 10 (default capacity)
        vector.ensureCapacity(20);
        System.out.println("New Capacity: " + vector.capacity()); // Output: 20
        Vector<String> clonedVector = (Vector<String>) vector.clone();
        System.out.println("Cloned Vector: " + clonedVector); // Output: [Apple, Grapes]
    }
}
```

---

## **Comparison Table: List vs. ArrayList vs. LinkedList vs. Queue vs. Vector**
| Feature         | List (Interface) | ArrayList (Class)       | LinkedList (Class)     | Queue (Interface) | Vector (Class) |
|-----------------|------------------|-------------------------|------------------------|-------------------|----------------|
| Type            | Interface        | Implements `List`       | Implements `List`, `Deque` | Interface        | Implements `List` |
| Data Structure  | Abstract         | **Dynamic Array**       | **Doubly Linked List** | Abstract (FIFO)   | **Dynamic Array** |
| Access Time     | N/A              | **Fast O(1)**           | **Slow O(n)**          | **FIFO-based**    | **Fast O(1)** |
| Insert/Delete Speed | N/A          | **Slow O(n)**           | **Fast O(1)**          | **Fast O(1) at ends** | **Slow O(n)** |
| Memory Usage    | N/A              | Less (Compact)          | More (Extra pointers)  | N/A               | More (Synchronized) |
| Best Use Case   | N/A              | **Fast access & search**| **Frequent insertions & deletions** | **Queue operations** | **Thread-safe operations** |
| Implements      | -                | `List`, `Collection`, `Iterable` | `List`, `Queue`, `Deque`, `Collection`, `Iterable` | - | `List`, `Collection`, `Iterable` |

---

## **Conclusion:**
- **Use `ArrayList`** when **fast random access** is needed and insertions/deletions are rare.
- **Use `LinkedList`** when **frequent insertions/deletions** are required, and access speed is not a priority.
- **Use `Queue`** when **FIFO behavior** is required.
- **Use `Vector`** when **thread-safe operations** are needed.
- **Use `List` (interface)** when you need flexibility to switch between different implementations.
