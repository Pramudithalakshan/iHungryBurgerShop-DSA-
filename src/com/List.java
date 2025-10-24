package com;

import javax.swing.table.DefaultTableModel;

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
        add(0, data);
    }

    public boolean add(int index, Burger burger) {
        if (index >= 0 && index <= nextIndex) {
            if (isFull()) {
                extendsArray();
            }
            for (int i = nextIndex - 1; i >= index; i--) {
                burgerArray[i + 1] = burgerArray[i];
            }
            burgerArray[index] = burger;
            nextIndex++;
            return true;
        }
        return false;
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
     Burger[] tempBurgerArray=new Burger[(int)(burgerArray.length*(1+loadFactor))];
        for (int i = 0; i < burgerArray.length; i++) {
            tempBurgerArray[i]=burgerArray[i];
        }
        burgerArray=tempBurgerArray;
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
 

    public int indexOf(Burger burger) {
        for (int i = 0; i < 10; i++) {
            if (burgerArray[i].equals(burger)) {
                return i;
            }

        }
        return -1;
    }

    public String generateOrderId() {
        if (nextIndex == 0) {
            return "B0001";
        }
        String ls = burgerArray[nextIndex - 1].getOrderID();
        int lsNo = Integer.parseInt(ls.substring(1));
        return String.format("B%04d", lsNo + 1);
    }

    public void sortArray() {
        for (int i = 0; i < nextIndex - 1; i++) {
            for (int j = 0; j < nextIndex - 1 - i; j++) {
                if (burgerArray[j].getQty() < burgerArray[j + 1].getQty()) {
                    Burger tempOrId = burgerArray[j];
                    burgerArray[j] = burgerArray[j + 1];
                    burgerArray[j + 1] = tempOrId;
                }
            }
        }
    }

    public DefaultTableModel loadBestustomerTable() {
        String[] columns = {"Order ID", "Customer Name", "Customer Id", "Total"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (int i = 0; i < nextIndex; i++) {
            Object[] row = {burgerArray[i].getOrderID(), burgerArray[i].getCustomerName(), burgerArray[i].getCustomerID(), burgerArray[i].getQty() * 500};
            model.addRow(row);
        }

        return model;
    }

    public Burger[] searchCustomer(String id) {
        Burger[] tempArray = new Burger[1];
        for (int i = 0; i < nextIndex; i++) {
            if (burgerArray[i].getCustomerID().equalsIgnoreCase(id)) {
                tempArray[i] = burgerArray[i];
            }
        }

        return tempArray;
    }

    public DefaultTableModel loadCustomerTable(Burger[] customer) {
        for (int i = 0; i < nextIndex; i++) {
            String[] columns = {"Order ID", "order Qty", "Total"};
            DefaultTableModel model = new DefaultTableModel(columns, 0);

            for (int j = 0; j < nextIndex; j++) {
                Object[] row = {burgerArray[j].getOrderID(), burgerArray[j].getQty(), burgerArray[i].getQty() * 500};
                model.addRow(row);
            }

            return model;

        }
        return null;

    }

    public Burger searchOrder(String orId) {
        for (int i = 0; i < nextIndex; i++) {
            if (burgerArray[i].getOrderID().equalsIgnoreCase(orId)) {
                return burgerArray[i];
            }
        }

        return null;

    }

    public int checkOrderStatus(String orId) {
        for (int i = 0; i < burgerArray.length; i++) {
            if (burgerArray[i].getOrderID().equals(orId)) {
                return burgerArray[i].getStatus();
            }
        }
        return -1;
    }

    public DefaultTableModel loadOrders(int status) {
        String[] columns = {"Order ID", "Customer ID", "Order Qty", "Total"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        for (int i = 0; i < nextIndex; i++) {
            if (burgerArray[i].getStatus() == status) {
                Object[] row = {burgerArray[i].getOrderID(), burgerArray[i].getCustomerID(), burgerArray[i].getQty(), burgerArray[i].getQty() * 500};
                model.addRow(row);
            }
        }

        return model;
    }
    
    public boolean updateCustomer(Burger burger){
        int index=indexOfBurger(burger);
        burgerArray[index]=burger;
        return true;
    }
    
    public int indexOfBurger(Burger burger){
        for (int i = 0; i <nextIndex; i++) {
            if(burgerArray[i].getOrderID().equalsIgnoreCase(burger.getOrderID())){
                return i;
            }
        }
        return -1;
    }  
    
     public String getOrId(String orId){
        for (int i = 0; i < nextIndex; i++) {
            if(burgerArray[i].getOrderID().equals(orId)){
              return burgerArray[i].getCustomerID();
            }
        }
        return "null";
    }
}
