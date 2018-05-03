package ru.itpark;

import java.util.Iterator;

public class LinkedList<T> implements List<T> {

    private Node top;
    private Node last;
    private int count;

    private class Node {
        T value;
        Node next;

        Node(T value) {
            this.value = value;
        }
    }

    @Override
    public T get(int index) {
        if (index < count) {
            int i = 0;
            Node current = top;

            while (i < index) {
                current = current.next;
                i++;
            }
            return current.value;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void delete(int index) {
        if (index < count) {
            int i = 0;
            Node tNode = top;
            Node iNode = top;
            while (i < index) {
                tNode = iNode;
                iNode = iNode.next;
                i++;
            }
            tNode.next = iNode.next;
            count--;
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void add(T element) {
        // создал узел для связного списка
        Node newNode = new Node(element);
//    Без last
//    if (top == null) {
//      top = newNode;
//    } else {
//      Node current = top;
//      while (current.next != null) {
//        current = current.next;
//      }
//      current.next = newNode;
//    }
        if (top == null) {
            top = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        count++;
    }

    @Override
    public boolean contains(T element) {
        Node current = top;
        int i = 0;
        while (i < count) {
            if (current.value.equals(element)) {
                return true;
            }
            current = current.next;
            i++;
        }
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean delete(T element) {
        Node current = top;
        int i = 0;
        while (i < count) {
            if (current.value.equals((element))) {
                delete(i);
                return true;
            }
            current = current.next;
            i++;
        }
        return false;
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node current = top;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T element = current.value;
            current = current.next;
            return element;
        }
    }

    public LinkedListIterator getIterator() {
        return new LinkedListIterator();
    }
}
