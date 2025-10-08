package com;

public class List {

    private Burger[] burgerArray;
    private int intSize;
    private double loadFactor;
    private int nextIndex;
    private int initSize;

    List(int initSize, double loadFactor) {
        burgerArray = new Burger[initSize];
        this.loadFactor = loadFactor;
        this.initSize = initSize;
        nextIndex = 0;
    }

    public boolean isEmpty() {
        return nextIndex == 0 ? true : false;
    }

    public int sizeOfTheArray() {
        return nextIndex - 1;
    }

    public boolean isFull() {
        return nextIndex == initSize ? true : false;
    }

    public void addLast(Burger data) {
        add(nextIndex, data);
    }

    public boolean add(int index, Burger data) {
        if (isFull()) {
            extendsArray();
        }
        for (int i = nextIndex - 1; i < index; i++) {
            burgerArray[i + 1] = burgerArray[i];
        }
        burgerArray[index] = data;
        nextIndex++;
        return true;
    }

    public int capacity() {
        return burgerArray.length;
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(nextIndex - 1);
    }

    public void extendsArray() {
    }

    public void remove(int index) {
        for (int i = index; i < nextIndex - 1; i++) {
            burgerArray[i] = burgerArray[i + 1];
        }
        nextIndex--;

    }

    public boolean set(int index, Burger data) {
        if (index >= 0 && index < nextIndex) {
            burgerArray[index] = data;
            return true;
        }
        return false;
    }

    public Burger get(int index) {
        if (index >= 0 && index < nextIndex) {
            return burgerArray[index];
        }
        return null;
    }

    public void printList() {
    }

    public void clear() {
    }

    public void contains() {
    }

    public int indexOf(Burger burger) {
        for (int i = 0; i < 10; i++) {
            if (burgerArray[i].equals(burger)) {
                return i;
            }

        }
        return -1;
    }
}
