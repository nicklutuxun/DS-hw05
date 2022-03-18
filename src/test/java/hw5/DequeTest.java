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
  public void insertFrontCorrectlyInsertAtFront() {
    deque.insertFront("a");
    deque.insertFront("b");
    deque.insertFront("c");
    deque.insertFront("d");
    assertEquals("d", deque.front());
  }
  
  @Test
  @DisplayName("insertBack() correctly insert at back.")
  public void insertBackCorrectlyInsertAtBack() {
    deque.insertBack("a");
    deque.insertBack("b");
    deque.insertBack("c");
    deque.insertBack("d");
    assertEquals("d", deque.back());
  }
  
  @Test
  @DisplayName("removeFront() throws EmptyException if empty")
  public void removeFrontThrowsEmptyExceptionIfEmpty() {
    try {
      deque.removeFront();
      fail("Test failed!");
    } catch (EmptyException ex) {
      System.out.println("Test passed!");
    }
  }
  
  @Test
  @DisplayName("removeBack() throws EmptyException if empty")
  public void removeBackThrowsEmptyExceptionIfEmpty() {
    try {
      deque.removeBack();
      fail("Test failed!");
    } catch (EmptyException ex) {
      System.out.println("Test passed!");
    }
  }
  
  @Test
  @DisplayName("length correctly returns number of elements in the deque")
  public void lengthCorrectlyReturnsNumberOfElement() {
    deque.insertBack("a");
    deque.insertBack("b");
    deque.insertBack("c");
    deque.insertBack("d");
    assertEquals(4, deque.length());
    deque.removeBack();
    deque.removeBack();
    deque.removeBack();
    deque.removeBack();
    assertEquals(0, deque.length());
    deque.insertFront("a");
    deque.insertFront("b");
    deque.insertFront("c");
    deque.insertFront("d");
    assertEquals(4, deque.length());
    deque.removeFront();
    deque.removeFront();
    deque.removeFront();
    deque.removeFront();
    assertEquals(0, deque.length());
  }
  
  @Test
  @DisplayName("Deque can behave like a stack correctly")
  public void DequeCanBehaveLikeAStack() {
    char ch = 'a';
    for (int i = 0; i < 10; i++) {
      deque.insertFront(Character.toString(ch));
      ch++;
    }
    assertEquals(10, deque.length());
    for (int i = 0; i < 10; i++) {
      assertEquals(Character.toString(ch), deque.front());
      deque.removeFront();
      ch--;
    }
    assertEquals(0, deque.length());
  }
}
