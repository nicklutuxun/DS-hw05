package hw5;

import exceptions.EmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class DequeTest {
  
  private Deque<String> deque;
  
  @BeforeEach
  public void setUp() {
    this.deque = createDeque();
  }
  
  protected abstract Deque<String> createDeque();
  
  @Test
  @DisplayName("Deque is empty after construction.")
  public void testConstructor() {
    assertTrue(deque.empty());
    assertEquals(0, deque.length());
  }
  
  // TODO Add more tests
  @Test
  @DisplayName("front() throws EmptyException if empty.")
  public void testFrontThrowsExceptionIfEmpty() {
    try {
      deque.front();
      fail("Test failed!");
    } catch (EmptyException ex) {
      System.out.println("Test passed!");
    }
  }
  
  @Test
  @DisplayName("back() throws EmptyException if empty.")
  public void testBackThrowsExceptionIfEmpty() {
    try {
      deque.back();
      fail("Test failed!");
    } catch (EmptyException ex) {
      System.out.println("Test passed!");
    }
  }
  
  @Test
  @DisplayName("insertFront() correctly insert at front.")
  public void testInsertFrontCorrectlyInsertAtFront() {
    for (int i = 0; i < 200; i++) {
      deque.insertFront(Integer.toString(i));
      assertEquals(Integer.toString(i), deque.front());
    }
  }
  
  @Test
  @DisplayName("insertBack() correctly insert at back.")
  public void testInsertBackCorrectlyInsertAtBack() {
    for (int i = 0; i < 200; i++) {
      deque.insertBack(Integer.toString(i));
      assertEquals(Integer.toString(i), deque.back());
    }
  }
  
  @Test
  @DisplayName("removeFront() throws EmptyException if empty")
  public void testRemoveFrontThrowsEmptyExceptionIfEmpty() {
    try {
      deque.removeFront();
      fail("Test failed!");
    } catch (EmptyException ex) {
      System.out.println("Test passed!");
    }
  }
  
  @Test
  @DisplayName("removeBack() throws EmptyException if empty")
  public void testRemoveBackThrowsEmptyExceptionIfEmpty() {
    try {
      deque.removeBack();
      fail("Test failed!");
    } catch (EmptyException ex) {
      System.out.println("Test passed!");
    }
  }
  
  @Test
  @DisplayName("length correctly returns number of elements in the deque with insertFront()")
  public void testCorrectLengthInsertFront() {
    for (int i = 0; i < 200; i++) {
      deque.insertFront(Integer.toString(i));
    }
    assertEquals(200, deque.length());
  }
  
  @Test
  @DisplayName("length correctly returns number of elements in the deque with insertBack()")
  public void testCorrectLengthInsertBack() {
    for (int i = 0; i < 200; i++) {
      deque.insertBack(Integer.toString(i));
    }
    assertEquals(200, deque.length());
  }
  
  @Test
  @DisplayName("Deque can behave like a front stack correctly")
  public void testDequeBehaveLikeAFrontStack() {
    for (int i = 0; i < 200; i++) {
      deque.insertFront(Integer.toString(i));
      assertEquals(Integer.toString(i), deque.front());
    }
    assertEquals(200, deque.length());
    for (int i = 199; i >= 0; i--) {
      assertEquals(Integer.toString(i), deque.front());
      deque.removeFront();
    }
    assertEquals(0, deque.length());
  }
  
  @Test
  @DisplayName("Deque can behave like a back stack correctly")
  public void testDequeBehaveLikeABackStack() {
    
    for (int i = 0; i < 200; i++) {
      deque.insertBack(Integer.toString(i));
      assertEquals(Integer.toString(i), deque.back());
    }
    assertEquals(200, deque.length());
    for (int i = 199; i >= 0; i--) {
      assertEquals(Integer.toString(i), deque.back());
      deque.removeBack();
    }
    assertEquals(0, deque.length());
  }
}
