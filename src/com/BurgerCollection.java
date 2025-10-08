package com;

import javax.swing.table.DefaultTableModel;

public class BurgerCollection {

    private  Burger[] customerArray = new Burger[0];

    private static final int UNITE_PRICE = 500;

    private void extendArray() {
        Burger[] tempArray = new Burger[customerArray.length + 1];
        for (int i = 0; i < customerArray.length; i++) {
            tempArray[i] = customerArray[i];
        }
        customerArray = tempArray;
    }

    public boolean addCustomer(Burger customer) {
        boolean isAdded;
        extendArray();
        customerArray[customerArray.length - 1] = customer;
        if (!customerArray[customerArray.length - 1].equals("null")) {
            return isAdded = true;
        }
        return isAdded = false;

    }

    public String generateOrderId() {
        if (customerArray.length == 0) {
            return "B0001";
        }
        String ls = customerArray[customerArray.length - 1].getOrderID();
        int lsNo = Integer.parseInt(ls.substring(1));
        return String.format("B%04d", lsNo + 1);
    }

    public void sortCustomerArray() {
        for (int i = 0; i < customerArray.length - 1; i++) {
            for (int j = 0; j < customerArray.length - 1; j++) {
                if (customerArray[j].getQty() < customerArray[j + 1].getQty()) {
                    Burger tempOrId = customerArray[j];
                    customerArray[j] = customerArray[j + 1];
                    customerArray[j + 1] = tempOrId;
                }
            }
        }
    }

    public DefaultTableModel loadTable() {
        String[] columns = {"Order ID", "Customer Id", "Total"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (Burger c : customerArray) {
            Object[] row = {c.getOrderID(), c.getCustomerID(), c.getQty() * UNITE_PRICE};
            model.addRow(row);
        }

        return model;
    }

    public DefaultTableModel loadCustomerTable(Burger[] customer) {
        for (int i = 0; i < customer.length; i++) {
            String[] columns = {"Order ID", "order Qty", "Total"};
            DefaultTableModel model = new DefaultTableModel(columns, 0);

            for (Burger c : customerArray) {
                Object[] row = {c.getOrderID(), c.getQty(), c.getQty() * UNITE_PRICE};
                model.addRow(row);
            }

            return model;

        }
        return null;
    }

    public Burger[] searchCustomer(String id) {
        Burger[] tempArray = new Burger[customerArray.length];
        for (int i = 0; i < customerArray.length; i++) {
            if (customerArray[i].getCustomerID().equalsIgnoreCase(id)) {
                tempArray[i] = customerArray[i];
            }
        }

        return tempArray;
    }

    public Burger searchOrder(String orId) {
        for (Burger customer : customerArray) {
            if (customer.getOrderID().equalsIgnoreCase(orId)) {
                return customer;
            }
        }
        return null;

    }

    public DefaultTableModel loadOrders(int status) {
        String[] columns = {"Order ID", "Customer ID", "Order Qty", "Total"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (Burger c : customerArray) {
            if (c.getStatus() == status) {
                Object[] row = {c.getOrderID(), c.getCustomerID(), c.getQty(), c.getQty() * UNITE_PRICE};
                model.addRow(row);
            }
        }

        return model;
    }
    
    public boolean updateCustomer(Burger customer){
        int index=indexOf(customer);
        customerArray[index]=customer;
        return true;
    }
    public int indexOf(Burger customer){
        for (int i = 0; i < customerArray.length; i++) {
            if(customerArray[i].getOrderID().equalsIgnoreCase(customer.getOrderID())){
                return i;
            }
        }
        return -1;
    }  
    
    public int checkOrderStatus(String orId){
        for (int i = 0; i < customerArray.length; i++) {
            if(customerArray[i].getOrderID().equals(orId)){
              return customerArray[i].getStatus();
            }
        }
        return -1;
    }
    
    public String getOrId(String orId){
        for (int i = 0; i < customerArray.length; i++) {
            if(customerArray[i].getOrderID().equals(orId)){
              return customerArray[i].getCustomerID();
            }
        }
        return "null";
    }
}
