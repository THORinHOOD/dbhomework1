package com.homework1;

public class LinkedSuperIntegerList implements SuperIntegerList {

    private Node root;
    private Node last;

    public LinkedSuperIntegerList() {
        this.root = null;
        this.last = null;
    }

    @Override
    public void add(int number) {
        if (root == null) {
            root = new Node(number, null);
            last = root;
        } else {
            last.next = new Node(number, null);
            last = last.next;
        }
    }

    @Override
    public void removeByIndex(int index) {
        if (index < 0 || root == null) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        if (index == 0) {
            root = root.next;
        } else {
            Node prev = null;
            Node current = root;
            for (int i = 1; i <= index; i++) {
                prev = current;
                current = current.next;
                if (current == null) {
                    throw new IndexOutOfBoundsException("Index out of range");
                }
            }
            remove(prev, current);
        }
    }

    @Override
    public void removeByValue(int value) {
        Node prev = null;
        Node current = root;
        while (current != null && current.getValue() != value) {
            prev = current;
            current = current.next;
        }
        remove(prev, current);
    }

    @Override
    public int get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        Node current = root;
        for (int i = 1; i <= index; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Index out of range");
            }
            current = current.next;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return current.getValue();
    }

    @Override
    public void printAll() {
        Node current = root;
        System.out.println();
        System.out.print("[");
        while (current != null) {
            System.out.print(current.getValue());
            current = current.next;
            if (current != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private void remove(Node prev, Node toDelete) {
        if (toDelete != null) {
            if (prev != null) {
                prev.next = toDelete.next;
            } else {
                root = toDelete.next;
            }
            if (toDelete.next == null) {
                last = prev;
            }
        }
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public Node setValue(int value) {
            this.value = value;
            return this;
        }

        public Node getNext() {
            return next;
        }

        public Node setNext(Node next) {
            this.next = next;
            return this;
        }
    }

}
