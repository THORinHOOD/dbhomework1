package com.homework1;

public class Main {

    public static void main(String[] args) {
        SuperIntegerList list = new LinkedSuperIntegerList();
        list.add(3);
        list.add(7);
        list.add(10);
        list.add(1);
        list.add(3);
        list.printAll();
        list.removeByValue(3);
        list.printAll();
        list.removeByIndex(2);
        list.printAll();
        list.add(4);
        list.printAll();
        list.removeByValue(10);
        list.printAll();
    }
}
