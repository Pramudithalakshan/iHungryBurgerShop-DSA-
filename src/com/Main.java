 
package com;
 
public class Main {
    public static void main(String[] args) {
        BurgerCollection customerCollection = new BurgerCollection();
        
        new ShopMainForm(customerCollection,list).setVisible(true);   
    }
 
}
