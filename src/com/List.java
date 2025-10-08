package com;

public class List{
   private Burger[] burgerArray;
   private int intSize;
   private double loadFactor;
   private int nextIndex;
   private int initSize;
   List(int initSize,double loadFactor){
       burgerArray = new Burger[initSize];
       this.loadFactor=loadFactor;
       this.initSize = initSize;
       nextIndex = 0;
   }
   public void isEmpty(){
   }
   
   public void sizeOfTheArray(){
   }
   
   public void isFull(){
       
   }
   
   public void addLast(Burger data){
       add(nextIndex,data);
   }
   
   public void add(int index,Burger data){
   }
   
   public int capacity(){
       return initSize;
   }
   
   public void removeFirst(){
   }
   
   public void removeLast(){
   }
   
   public void extendsArray(){
   }
   
   public void remove(){
   }
   
   public void set(){
   }
   
   public void get(){
   }
   
   public void printList(){
   }
   
   public void clear(){
   }
   
   public void contains(){
   }
   
   public void indexOf(){
   }
}
