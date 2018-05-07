package Ui;

import Controller.StoreController;
import Model.MyException;
import Model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Vlad on 17-Mar-16.
 */
public class StoreUI {
    public StoreController ctrl;
    Scanner in;
    public StoreUI(StoreController ctrl){
        this.ctrl=ctrl;
        this.in=new Scanner(System.in);
    }
    public void printMenu() {
        String menu;
        menu = "These are the available commands:\n";
        menu += "\t 1 - Add a new Product \n";
        menu += "\t 2 - Displays all products from category\n";
        menu += "\t 3 - Stock situation for all products \n";
        menu += "\t 4 - Stock situation for a certain product \n";
        menu += "\t 0 - to exit; \n";
        System.out.println(menu);
    }

    public boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }

    public void AddNewProduct() throws MyException
    {
        int code = 0;
        String pCode = "";
        while(code != 1) {
            System.out.println("Give the Product code:");
            pCode = in.nextLine();
            if(!isNumeric(pCode)) {
                System.out.println("Code must be a positive number");
            }else {
                code = 1;
            }
        }

        int c = Integer.parseInt(pCode);

        System.out.println("Give the product name:");
        String pName = in.nextLine();

        System.out.println("Give the product category:");
        String pCategory = in.nextLine();

        System.out.println("Give the product supplier:");
        String pSupplier = in.nextLine();

        int x = 0;
        String q = "";
        while (x != 1) {
            System.out.println("Give the quantity:");
            q = in.nextLine();
            if (!isNumeric(q)) {
                System.out.println("Quantity must be a positive number");
            }else {
                x = 1;
            }
        }

        int pQunatity = Integer.parseInt(q);

        Product p = new Product(c,pName,pCategory,pSupplier,pQunatity);
        try {
            ctrl.addProduct(p);
            System.out.println("Product Added");
        } catch(MyException e) {
            System.out.println(e.getMessage());;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void DisplayCategory()
    {
        System.out.println("Give category");
        String cat=in.nextLine();
        ArrayList<Product> temp;
        try {
            temp = ctrl.getProductsCategory(cat);
            for (Product p : temp) {
                System.out.println(p.toString());
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    public void DisplayStock()
    {

        ArrayList<Product> temp = ctrl.stockSituation();

        for (Product p : temp) {
            System.out.println(p.toString());
        }
    }

    public void DisplayStockFor()
    {
        System.out.println("Give product name");
        String prod=in.nextLine();
        ArrayList<Product> temp;
        try {
            temp = ctrl.stockSituationProduct(prod);
            for (Product p : temp) {
                System.out.println(p.toString());
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());;
        }
    }

    public int readCommand() {
        System.out.println("Give a command: ");
        String c = "";
        int x = 0;
        int command = 0;
        while (x != 1) {
            c = in.nextLine();
            if (!isNumeric(c)) {
                System.out.println("Please provide a number");
            }else {
                command = Integer.parseInt(c);
                if(command >= 0 && command <= 4) {
                    x = 1;
                }else {
                    System.out.println("The number must be between 0 and 4.");
                }
            }
        }
        return command;
    }

    public void executeCommand(int c) {
        switch(c) {
            case 1:
                try {
                    AddNewProduct();
                } catch (MyException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                DisplayCategory();
                break;
            case 3:
                DisplayStock();
                break;
            case 4:
                DisplayStockFor();
                break;
            default:
                System.out.println("B'bye now!...\n");
                break;
        }
    }

    public void run() {
        int c;
        do {
            printMenu();
            c = readCommand();
            executeCommand(c);
        } while(c != 0);

    }



}
