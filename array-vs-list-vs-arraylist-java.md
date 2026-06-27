# Array vs List vs ArrayList in Java

## Comparison Table

| Feature          | Array                            | List (Interface)                    | ArrayList (Class)                                               |
| ---------------- | --------------------------------- | ------------------------------------ | ---------------------------------------------------------------- |
| Type             | Built-in data structure          | Interface in Java Collections       | Class implementing `List`                                       |
| Package          | Built-in (`java.lang`)           | `java.util.List`                    | `java.util.ArrayList`                                           |
| Size             | Fixed                             | Dynamic (depends on implementation) | Dynamic (grows automatically)                                   |
| Stores           | Primitive data types and Objects | Objects only                        | Objects only                                                    |
| Access Speed     | Very fast (`O(1)`)               | Depends on implementation           | Very fast (`O(1)`)                                              |
| Insert/Delete    | Difficult (fixed size)           | Supported                            | Easy using methods                                              |
| Index Based      | Yes                               | Yes                                  | Yes                                                              |
| Built-in Methods | Very few                          | Method declarations only             | Many methods (`add()`, `remove()`, `get()`, `contains()`, etc.) |
| Can Instantiate? | Yes                               | No (it's an interface)               | Yes                                                              |

---

## 1. Array

### Definition

An **Array** is a built-in data structure with a **fixed size**. Once created, its size cannot be changed.

### Example

```java
public class Demo {
    public static void main(String[] args) {

        int[] marks = {90, 85, 70};

        System.out.println(marks[0]); // 90

        marks[1] = 95;

        for(int i = 0; i < marks.length; i++) {
            System.out.println(marks[i]);
        }
    }
}
```

**Output**

```
90
90
95
70
```

---

## 2. List (Interface)

### Definition

`List` is an **interface** in the Java Collections Framework.

It **cannot be instantiated directly**.

❌ Incorrect

```java
List<String> names = new List<>();
```

✅ Correct

```java
import java.util.*;

public class Demo {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        System.out.println(names);
    }
}
```

**Output**

```
[Alice, Bob, Charlie]
```

Here,

* `List` → Interface
* `ArrayList` → Implementation (object)

---

## 3. ArrayList

### Definition

`ArrayList` is a **class** that implements the `List` interface.

It behaves like an array but automatically resizes when more elements are added.

### Example

```java
import java.util.*;

public class Demo {
    public static void main(String[] args) {

        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Mango");

        fruits.remove("Orange");

        System.out.println(fruits);

        System.out.println(fruits.get(1));
    }
}
```

**Output**

```
[Apple, Mango]
Mango
```

---

# Syntax Comparison

| Array                     | List                                      | ArrayList                                      |
| -------------------------- | ------------------------------------------ | ------------------------------------------------ |
| `int[] arr = new int[5];` | `List<Integer> list = new ArrayList<>();` | `ArrayList<Integer> list = new ArrayList<>();` |

---

# Adding Elements

### Array

```java
int[] arr = {10, 20, 30};
```

### List

```java
List<Integer> list = new ArrayList<>();
list.add(10);
list.add(20);
```

### ArrayList

```java
ArrayList<Integer> list = new ArrayList<>();
list.add(10);
list.add(20);
```

---

# Accessing Elements

### Array

```java
System.out.println(arr[1]);
```

### List / ArrayList

```java
System.out.println(list.get(1));
```

---

# Updating Elements

### Array

```java
arr[1] = 50;
```

### List / ArrayList

```java
list.set(1, 50);
```

---

# Removing Elements

### Array

```java
// Not directly possible.
// A new array must be created manually.
```

### List / ArrayList

```java
list.remove(1);
```

---

# Finding Size

### Array

```java
arr.length
```

### List / ArrayList

```java
list.size()
```

---

# When to Use?

| Situation                                         | Best Choice                               |
| --------------------------------------------------- | -------------------------------------------- |
| Fixed number of elements                          | Array                                     |
| Need flexibility and programming to an interface  | `List<Integer> list = new ArrayList<>();` |
| Need a resizable array implementation             | `ArrayList`                                |

---

# Understanding the Last Two Points

## 1. Need Flexibility and Programming to an Interface

Instead of writing:

```java
ArrayList<String> names = new ArrayList<>();
```

prefer:

```java
List<String> names = new ArrayList<>();
```

### Why?

Suppose later you decide to use `LinkedList` instead of `ArrayList`.

Only one line needs to change:

```java
List<String> names = new LinkedList<>();
```

The rest of your code remains unchanged:

```java
names.add("Alice");
names.add("Bob");
names.remove(0);
```

This is called **Programming to an Interface**.

### Easy Definition

> Use the interface (`List`) as the reference type instead of a specific implementation (`ArrayList`) so that the implementation can be changed later without affecting the rest of the program.

---

## 2. Need a Resizable Array Implementation

### Array (Fixed Size)

```java
int[] arr = new int[3];

arr[0] = 10;
arr[1] = 20;
arr[2] = 30;
```

The array is full.

Trying to store another element is **not possible** because the size is fixed.

---

### ArrayList (Resizable)

```java
ArrayList<Integer> list = new ArrayList<>();

list.add(10);
list.add(20);
list.add(30);
list.add(40);
list.add(50);
list.add(60);
```

You don't need to specify the size.

`ArrayList` automatically increases its storage when needed.

### What Happens Internally?

Initially:

```
Capacity = 10

[ _ _ _ _ _ _ _ _ _ _ ]
```

After adding 10 elements:

```
[1 2 3 4 5 6 7 8 9 10]
```

When the 11th element is added:

* A larger internal array is created.
* Existing elements are copied into it.
* The new element is inserted.
* The old array is discarded.

This resizing happens automatically.

### Easy Definition

> **ArrayList is a resizable array implementation because it automatically grows or shrinks its internal array as elements are added or removed.**

---

# Quick Revision

| Array                        | List                            | ArrayList                  |
| ----------------------------- | --------------------------------- | ---------------------------- |
| Fixed size                   | Interface                        | Resizable implementation   |
| Stores primitives & objects  | Stores objects                   | Stores objects             |
| Built into Java              | Cannot create objects directly   | Implements `List`          |
| Uses `length`                | Uses `size()`                    | Uses `size()`              |
| Access using `arr[index]`    | Access using `get(index)`        | Access using `get(index)`  |

---

# Interview Point

The preferred declaration is:

```java
List<Integer> list = new ArrayList<>();
```

### Why?

* `List` → Provides flexibility.
* `ArrayList` → Provides the implementation.

If needed later, you can simply change:

```java
List<Integer> list = new LinkedList<>();
```

without changing the rest of the program.
