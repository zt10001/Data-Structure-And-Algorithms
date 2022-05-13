/* *****************************************************************************
 *  Name: Tao Zheng
 *  Date: 04/23/2022
 *  Description:
 **************************************************************************** */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private final Node head;
    private final Node tail;
    private int  size;

    private class Node {

        Item item;
        Node prev;
        Node next;

        Node(Item item) {
            this.item = item;
        }
    }

    // construct an empty deque
    public Deque() {
        head = new Node(null); // dummy head
        tail = new Node(null); // dummy tail
        head.next = tail;
        tail.prev = head;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }
        Node node = new Node(item);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }
        Node node = new Node(item);
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException("Deque is empty.");
        }
        Node node = head.next;
        head.next = node.next;
        head.next.prev = head;
        size--;
        return node.item;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("Deque is empty.");
        }
        Node node = tail.prev;
        tail.prev = node.prev;
        tail.prev.next = tail;
        size--;
        return node.item;
    }

    // return an iterator over items in order from front to back
    @Override
    public Iterator<Item> iterator() {
        return new HeadFirstIterator();
    }

    private class HeadFirstIterator implements Iterator<Item> {

        private Node curr = head;

        @Override
        public boolean hasNext() {
            return curr.next != tail;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more items.");
            }
            curr = curr.next;
            return curr.item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove is not supported.");
        }
    }

    public static void main(String[] args) {
        // tests will be made on Coursera

    }
}
