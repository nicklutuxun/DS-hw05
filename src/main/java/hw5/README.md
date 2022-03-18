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



## Profiling

