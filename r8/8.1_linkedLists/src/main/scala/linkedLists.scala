/*
  * This program text file is part of the CS-A1120 Programming 2 course
  * materials at Aalto University in Spring 2021. The programming exercises
  * at CS-A1120 are individual and confidential assignments---this means
  * that as a student taking the course you are allowed to individually
  * and confidentially work with the material, to discuss and review the
  * material with course staff, as well as to submit the material for grading
  * on course infrastructure. All other use, including in particular
  * distribution of the material or exercise solutions, is forbidden and
  * constitutes a violation of the code of conduct at this course.
  *
  */

/**
 * Exercises on linked lists and recursion.
 * Only for the use on the course CS-A1120, redistribution not allowed.
 * @author Tommi Junttila
 */
package linkedLists

import scala.annotation.tailrec

/**
 * A simple linked list data structure.
 * The elements in the list are of type A.
 */
abstract class LinkedList[A]() {
  /**
   * Returns true if the list is empty.
   */
  def isEmpty = this match {
    case Nil() => true
    case Cons(_, _) => false
  }

  /**
   * Returns the first element in the list
   * (throws an exception if the list is empty).
   */
  def head: A

  /**
   * Returns the list obtained by removing the first element from this list
   * (throws an exception if the list is empty).
   */
  def tail: LinkedList[A]

  /**
   * Equality comparison method.
   * For more on equality, see Chapter 30 of "Programming in Scala, 2nd edition".
   */
  override def equals(other: Any): Boolean = {
    def inner(l1: LinkedList[A], l2: LinkedList[A]): Boolean = {
      if (l1.isEmpty) l2.isEmpty
      else if (l2.isEmpty) false
      else (l1.head == l2.head) && inner(l1.tail, l2.tail)
    }
    other match {
      case that: LinkedList[A] => inner(this, that)
      case _ => false
    }
  }

  /**
   * String representation of the list.
   */
  override def toString: String = {
    val maxElementsPrinted = 20
    @tailrec def inner(remaining: LinkedList[A], prefix: String, postfix: String, i: Int): String =
      if (i >= maxElementsPrinted) prefix + "..." + postfix
      else {
        remaining match {
          case Nil() => prefix + "Nil()" + postfix
          case Cons(h, t) => inner(t, prefix + "Cons(" + h.toString + ", ", postfix + ")", i + 1)
        }
      }
    inner(this, "", "", 0)
  }

  /**
   * Returns the length of the list (the number of elements in it).
   */
  def length: Int = {
    @tailrec def inner(remaining: LinkedList[A], result: Int): Int =
      remaining match {
        case Nil() => result
        case Cons(_, t) => inner(t, result + 1)
      }
    inner(this, 0)
  }

  /**
   * Returns the reversed version of this list
   */
  def reverse: LinkedList[A] = {
    @tailrec def inner(remaining: LinkedList[A], result: LinkedList[A]): LinkedList[A] =
      remaining match {
        case Nil() => result
        case Cons(h, t) => inner(t, Cons(h, result))
      }
    inner(this, Nil())
  }

  /**
   * Returns true if the list contains the element e.
   * Recall that tail recursion optimization needs the method to be final.
   */
  @tailrec final def contains(e: A): Boolean = this match {
    case Nil() => false
    case Cons(h, t) => if (h == e) true else t.contains(e)
  }

  /**
   * Count how many elements of the list satisfy the predicate p.
   */
  final def count(p: A => Boolean): Int = {
    def loop(list: LinkedList[A], n: Int): Int = {
      list match {
        case Nil() => n
        case Cons(s,t) => {
          if (p(s)) loop(t,n+1) 
          else loop(t,n)
        }
      }
    }
    loop(this, 0)
  }

  /**
   * Returns the sub-list of this list consisting of the elements e for which p(e) is false.
   */
  final def filterNot(p: A => Boolean): LinkedList[A] = {
    def loop(list: LinkedList[A], list2: LinkedList[A]): LinkedList[A] = {
      list match {
        case Nil() => list2
        case Cons(s,t) => {
          if (!p(s)) loop(t,Cons(s, list2)) 
          else loop(t,list2) 
        }
      }
    }
    if (this.count(p) == this.length) new Nil[A]()
    else loop(this, new Nil()).reverse
  }

  /**
   * Returns the last element in the list
   * (throws java.util.NoSuchElementException if the list is empty).
   */
  final def last: A = this.reverse.head

  /**
   * Returns the list except the first n elements.
   * If the list contains less than n elements, an empty list is returned.
   */
  final def drop(n: Int): LinkedList[A] = {
    @tailrec def loop(list: LinkedList[A], list2: LinkedList[A], m: Int): LinkedList[A] = {
      list match {
        case Nil() => list2
        case Cons(s,t) => {
          if (m >= n) loop(t,Cons(s, list2), m+1) else loop(t,list2, m+1)
        }
      }
    }
    if (n > this.length) new Nil()
    else if (n == this.length) new Nil()
    else loop(this, new Nil(), 0).reverse
  }

  /**
   * Applies the function f: A => B to each element in the list,
   * returning a new linked list over elements of type B.
   * For instance, if l is Cons(1, Cons(2, Cons(3, Nil()))) of type LinkedList[Int], then
   * l.map(e => math.sqrt(e)) should be Cons(1.0, Cons(1.4142135623730951, Cons(1.7320508075688772, Nil())))
   * of type LinkedList[Double] (math.sqrt returns elements of type Double).
   */
  final def map[B](f: A => B): LinkedList[B] = {
    @tailrec def loop(list: LinkedList[A], list2: LinkedList[B]): LinkedList[B] = {
      list match {
        case Nil() => list2
        case Cons(s,t) => loop(t,Cons(f(s), list2)) 
      }
    }
    loop(this, new Nil()).reverse
  }

  /**
   * For a linked list l = Cons(e_1, Cons(e_2, ... ,Cons(e_n, Nil())...)) and a binary function f,
   * computes the value f(...f(f(start,e_1),e_2),...),e_n).
   * For example, if l is Cons(1, Cons(2, Cons(3, Nil()))), then l.foldLeft(0)((s, e) => s + (e*e))
   * should equal to the sum of squares of the elements in l, i.e. 14.
   * If l is empty, the value "start" must be returned.
   */
  final def foldLeft[B](start: B)(f: (B, A) => B): B = {
    @tailrec def loop(list: LinkedList[A], p: B): B = {
      list match {
        case Nil() => p
        case Cons(s,t) => loop(t,f(p,s)) 
      }
    }
    loop(this, start)
  }

  /**
   * For a linked list Cons(e_1, Cons(e_2, ... ,Cons(e_n, Nil())...)) and a binary function f,
   * computes the value f(e_1,f(e_2,...f(e_n, start)...)).
   * For example, if l is Cons(1, Cons(2, Cons(3, Nil()))), then l.foldLeft(0)((s, e) => s + (e*e))
   * should equal to the sum of squares of the elements in l, i.e. 14.
   * If l is empty, the value "start" must be returned.
   */
  def foldRight[B](start: B)(f: (A, B) => B): B = reverse.foldLeft(start)((r, e) => f(e, r))

  /**
   * Splits the list in two parts: the first part contains the first n elements
   * while the second part contains the rest.
   * If the list contains less than n elements, the first part contains the whole list and the second part is empty.
   * If n is 0, the first part is empty and the second part contains the whole list.
   */
  final def splitAt(n: Int): (LinkedList[A], LinkedList[A]) = {
    @tailrec def loop(list: LinkedList[A], list2: LinkedList[A], list3: LinkedList[A], m: Int): (LinkedList[A],LinkedList[A]) = {
      list match {
        case Nil() => (list2.reverse, list3.reverse)
        case Cons(s,t) => {
          if (m < n) loop(t,Cons(s, list2), list3, m+1) else loop(t, list2, Cons(s, list3), m+1)
        }
      }
    }
    if (n > this.length) (this,new Nil())
    else if (n == 0) (new Nil(),this)
    else loop(this, new Nil(), new Nil(), 0)
  }

  /**
   * Apply the function f to each element in the list.
   * The return values of calls to f are ignored.
   */
  @tailrec final def foreach[B](f: A => B): Unit =
    this match {
      case Nil() => Unit
      case Cons(h, t) => f(h); t.foreach(f)
    }

  /**
   * Returns a list formed from this list and another list by combining corresponding elements in pairs.
   * If one of the two collections is longer than the other, its remaining elements are ignored.
   * As an example,e if l1 = Cons(1, Cons(2, Cons(3, Cons(4, Nil())))) and
   * l2 = Cons(1.0, Cons(1.4142135623730951, Cons(1.7320508075688772, Nil()))),
   * then l1.zip(l2) = Cons((1,1.0), Cons((2,1.4142135623730951), Cons((3,1.7320508075688772), Nil())))
   */
  def zip[B](that: LinkedList[B]): LinkedList[(A, B)] = {
    @tailrec def inner(l1: LinkedList[A], l2: LinkedList[B], result: LinkedList[(A, B)]): LinkedList[(A, B)] = {
      if (l1.isEmpty || l2.isEmpty) result
      else inner(l1.tail, l2.tail, Cons((l1.head, l2.head), result))
    }
    inner(this, that, Nil[(A, B)]()).reverse
  }

}

/**
 * An empty linked list
 */
case class Nil[A]() extends LinkedList[A] {
  def head = throw new java.util.NoSuchElementException("head of empty list")
  def tail = throw new java.util.NoSuchElementException("tail of empty list")
}

/**
 * A non-empty linked list.
 * @param _head the first element in the list
 * @param _tail the rest of the list
 */
case class Cons[A](val head: A, val tail: LinkedList[A]) extends LinkedList[A]


