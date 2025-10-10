package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("burger.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;
            List list = new List(100, 0.25);

            while ((line = br.readLine()) != null) {
                String[] rowData = line.split(",");
                Burger burger = new Burger(
                        rowData[0],
                        rowData[1],
                        rowData[2],
                        Integer.parseInt(rowData[3]),
                        Integer.parseInt(rowData[4])
                );
                list.addLast(burger);
            }

            br.close();
            list.testArray();
            new ShopMainForm(list).setVisible(true);

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }

    }

}
