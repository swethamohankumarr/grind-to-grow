# HashSet & HashMap Notes (Java)

# 1. HashSet

## Definition

A `HashSet` is a collection that stores **only unique elements**. It does **not** allow duplicates and does **not** guarantee insertion order.

```java
HashSet<Integer> set = new HashSet<>();
```

---

## Characteristics

* Stores only unique elements.
* Duplicate values are ignored.
* No indexing (`get()` is not available).
* Fast insertion, deletion, and searching.
* Uses a **Hash Table** internally.

---

## Common Methods

### add()

```java
set.add(10);
set.add(20);
set.add(10);
```

Output:

```
[10, 20]
```

Duplicate `10` is ignored.

---

### contains()

Checks whether an element exists.

```java
set.contains(20);
```

Output:

```
true
```

---

### remove()

```java
set.remove(20);
```

---

### size()

```java
set.size();
```

Returns the number of elements.

---

### isEmpty()

```java
set.isEmpty();
```

Returns `true` if the set is empty.

---

### clear()

Removes all elements.

```java
set.clear();
```

---

## Traversing a HashSet

### Enhanced for loop

```java
for(Integer x : set){
    System.out.println(x);
}
```

### Iterator

```java
Iterator<Integer> it = set.iterator();

while(it.hasNext()){
    System.out.println(it.next());
}
```

---

## Convert HashSet to ArrayList

```java
ArrayList<Integer> list = new ArrayList<>(set);
```

---

## Convert HashSet to Integer[]

```java
Integer[] arr = set.toArray(new Integer[0]);
```

---

## Convert HashSet to int[]

```java
int[] arr = new int[set.size()];

int i = 0;

for(Integer x : set){
    arr[i++] = x;
}
```

---

## Internal Working

HashSet uses a **Hash Table**.

Example:

```
25
↓
Hash Function
↓
Bucket 5
```

Searching:

```
25
↓
Hash Function
↓
Bucket 5
↓
Found
```

Instead of searching every element, Java directly jumps to the correct bucket.

---

## Time Complexity

| Operation  | Complexity   |
| ---------- | ------------ |
| add()      | O(1) Average |
| contains() | O(1) Average |
| remove()   | O(1) Average |

Worst case can be O(n), but average case is O(1).

---

# 2. HashMap

## Definition

A `HashMap` stores **key-value pairs**.

```java
HashMap<Integer, Integer> map = new HashMap<>();
```

Example:

```
10 → 0
15 → 1
20 → 4
```

Key = 10, Value = 0

---

## Characteristics

* Stores key-value pairs.
* Keys must be unique.
* Values can be duplicated.
* No guaranteed order.
* Uses a Hash Table internally.

---

## Common Methods

### put()

```java
map.put(10, 100);
map.put(20, 200);
```

Map:

```
10 → 100
20 → 200
```

---

### get()

```java
map.get(10);
```

Output:

```
100
```

---

### containsKey()

```java
map.containsKey(20);
```

Output:

```
true
```

---

### containsValue()

```java
map.containsValue(100);
```

---

### remove()

```java
map.remove(10);
```

---

### size()

```java
map.size();
```

---

### clear()

```java
map.clear();
```

---

## Traversing HashMap

### Using keySet()

```java
for(Integer key : map.keySet()){
    System.out.println(key + " " + map.get(key));
}
```

### Using entrySet() (Most Efficient)

```java
for(Map.Entry<Integer, Integer> entry : map.entrySet()){
    System.out.println(entry.getKey() + " " + entry.getValue());
}
```

---

# Difference Between HashSet and HashMap

| Feature        | HashSet     | HashMap                           |
| -------------- | ----------- | --------------------------------- |
| Stores         | Only Values | Key-Value Pairs                   |
| Duplicate Keys | Not Allowed | Keys Not Allowed, Values Allowed  |
| Index          | No          | No                                |
| Uses Hashing   | Yes         | Yes                               |

Example:

HashSet:
```
10
20
30
```

HashMap:
```
10 → 5
20 → 8
30 → 12
```

---

# Why HashSet is Fast

ArrayList searching for `50`:

```
10 ❌
20 ❌
30 ❌
40 ❌
50 ✅

Time: O(n)
```

HashSet searching for `50`:

```
50
↓
Hash Function
↓
Bucket 2
↓
Found

Time: O(1)
```

---

# Longest Subarray with Sum K

## Prefix Sum

```
arr = [10, 5, 2, 7, 1, -10]

Prefix Sum: 10 → 15 → 17 → 24 → 25 → 15
```

Formula:

```
Subarray Sum = Current Prefix Sum - Previous Prefix Sum
```

Rearranging:

```
Previous Prefix Sum = Current Prefix Sum - k
```

Hence we search:

```java
map.containsKey(prefixSum - k)
```

---

## Why Store First Occurrence?

Suppose:

```
Prefix Sum 15 → Index 2
Prefix Sum 15 → Index 6
```

We keep `15 → Index 2` because `CurrentIndex - 2` is longer than `CurrentIndex - 6`.

---

## Why `map.put(0, -1)`?

Suppose:

```
arr = [10, 5]
k = 15
```

At index 1:

```
Prefix = 15
Need   = 0
```

We assume `Prefix Sum = 0` at `Index = -1`, so:

```
Length = 1 - (-1) = 2
```

This correctly represents the entire array.

---

# Time Complexities

## HashSet

| Operation  | Complexity |
| ---------- | ---------- |
| add()      | O(1)       |
| contains() | O(1)       |
| remove()   | O(1)       |

## HashMap

| Operation     | Complexity |
| ------------- | ---------- |
| put()         | O(1)       |
| get()         | O(1)       |
| containsKey() | O(1)       |
| remove()      | O(1)       |

---

# Interview Tips

## Use HashSet when:
* Removing duplicates.
* Finding union/intersection.
* Fast searching.
* Only uniqueness matters.

## Use HashMap when:
* Counting frequencies.
* Prefix sum problems.
* Storing element → index.
* Storing key-value relationships.

---

# Memory Tricks

> **HashSet** → Unique elements only

> **HashMap** → Key → Value

### Prefix Sum Formula

```
Subarray Sum = Current Prefix Sum - Previous Prefix Sum
```

### Search Formula

```
Need = Current Prefix Sum - k
```

```java
map.containsKey(prefixSum - k);
```
