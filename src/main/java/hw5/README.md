# Discussion

## Flawed Deque
- **Flaw 1: ** `insertBack()` This behaviour also leads to incorrect return value of `length()`.
    - Failing tests: `testInsertBackCorrectlyInsertAtBack`/`testDequeBehaveLikeABackStack`/`testCorrectLengthInsertBack`
    - Elaboration: 
       In `testInsertBackCorrectlyInsertAtBack`, some elements are not inserted correctly so that assertEqual fails.
       In `testDequeBehaveLikeABackStack`, I test whether deque behaves like a stack at which elements are inserted at back. But assertEqual fails
       because some elements are not inserted. 
       In `testCorrectLengthInsertBack`, I insert 200 elements at back without checking their value, but at the end the length is 192. Therefore, some values
       are ignored.
    - Educated guess: 
      In the insertion of String representation of 0-199, I find `1, 3, 6, 11, 20, 37, 70, 135` are missing from deque. This sequence can be computed by the formula:
      `n_i = n + 2^(n-1) - 1`where `n` starts from `1`. There may be an if statement that checks if the inserted element is in the sequence, and ignores it if so.
- **Flaw 2**: `removeFront`, `removeBack` and `back` do not throw EmptyException when the deque is empty.
  - Failing tests:`testRemoveFrontThrowsEmptyExceptionIfEmpty`/`testRemoveBackThrowsEmptyExceptionIfEmpty`/`testBackThrowsExceptionIfEmpty` 
  - Elaboration:
    In `testRemoveFrontThrowsEmptyExceptionIfEmpty` and `testRemoveBackThrowsEmptyExceptionIfEmpty` do not throw `EmptyException` when the deque is empty that can be 
    caught by try-catch block.
    In `testBackThrowsExceptionIfEmpty`, instead of `EmptyException`, `LengthException` is thrown.
  - Educated guess: `removeFront`, `removeBack` do not check if deque is empty and perform the remove anyway. For `back`, according to javadoc, Data structures that have a fixed (integer) length throw LengthException if a given length is out of range.
    

## Hacking Linear Search
In both main methods, I try to insert `0~9`, then call `has()` to check every even number, and call
`remove()` to remove all of them.

- **MoveToFrontLinkedSet**
    - `has()` puts all even numbers at the start of linked list, which is what we want. In every `remove()` call
       `find()` is executed to move the element ready to be removed at the head of linked list and perform O(n) removal. 
- **TransposeArraySet**
    - `has()` moves all even numbers one slot forward, which is what we want to speed up the linear search. But the calls to `find()` in every
      `remove()` does another swap between the removal target and its predecessor. This is generally inefficient since it is not necessary to 
      move the target forward if we are going to remove it, so that no future search will be called on that element.
    
## Profiling

| Benchmark                        | Mode |  Cnt |      Score | Error | Units |
|:---------------------------------|------|-----:|-----------:|-------|-------|
| JmhRuntimeTest.arraySet          | avgt |    2 |   3665.644 |       | ms/op |
| JmhRuntimeTest.linkedSet         | avgt |    2 |  11175.967 |       | ms/op |
| JmhRuntimeTest.moveToFront       | avgt |    2 |    262.301 |       | ms/op |
| JmhRuntimeTest.transposeSequence | avgt |    2 |   1179.690 |       | ms/op |

- In `setUP()`, I add `0~9999` into the data array and shuffle it; In the `experiment()` function, I insert the elements in data array
into each 4 different kinds of sets. Therefore, we now have an array `set` that contains `0~9999` at random positions. 

- Next I define an array called `listToSearch` of size 1000, and insert a random number from range `0~99`. This array contains the
number we will search in `set`.

- Lastly, I perform a search of all numbers in `listToSearch` 1000 times and get the benchmark result above.

We observe that `moveToFront` and `transposeSequence` is much faster than `linkedSet` and `arraySet` respectively.
This is because during first few searches, `moveToFront` heuristic moves all target values directly to the front of linked list, which
speeds up the searching process immediately; While `transposeSequence` heuristic moves target values one position forward at a time, so 
it takes some searches to move all frequently searched elements to the front of array. Therefore, `transposeSequence` speeds up the searching
gradually.
