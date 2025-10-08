 
package com;
 
public class Main {
    public static void main(String[] args) {
        BurgerCollection customerCollection = new BurgerCollection();
        List list = new List(100, 0.25);
        new ShopMainForm(customerCollection,list).setVisible(true);   
    }
 
}
