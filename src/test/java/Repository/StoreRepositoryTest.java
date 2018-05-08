package Repository;

import Model.MyException;
import Model.Product;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class StoreRepositoryTest {

    @org.junit.Test
    public void addNewProduct() {
        Product p = new Product(-1,"apple","fruit","supplier",5);
        Product p2 = new Product(1,"apple","fruit","supplier",-5);
        Product p3 = new Product(1,"apple","fruit","supplier",5);
        Product p4 = new Product(1,"apple","fruit","supplier",5);
        StoreRepository rep = new StoreRepository();
        try {
            rep.addNewProduct(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(rep.getAllProducts().size(),0);
        try {
            rep.addNewProduct(p2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(rep.getAllProducts().size(),0);
        try {
            rep.addNewProduct(p3);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(rep.getAllProducts().size(),1);
        try {
            rep.addNewProduct(p4);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(rep.getAllProducts().size(),1);
    }

    @org.junit.Test
    public void getProductsCategory(){
        Product p = new Product(1,"apple","fruit","supplier",5);
        Product p2 = new Product(2,"bananna","fruit","supplier",15);
        Product p3 = new Product(3,"apple","fruit","supplier2",5);
        Product p4 = new Product(4,"strawberry","fruit2","metro",5);
        StoreRepository rep = new StoreRepository();

        String s1 = "fruit";
        String s2 = "friut3";
        String s3 = "juice";

        try{
            rep.addNewProduct(p);
            rep.addNewProduct(p2);
            rep.addNewProduct(p3);
            rep.addNewProduct(p4);
            ArrayList<Product> products1 = rep.getProductsCategory(s1);
            assertEquals(products1.size(), 3);
            ArrayList<Product> products2 = rep.getProductsCategory(s2);
            assertEquals(products2.size(), 1);
            ArrayList<Product> products3 = rep.stockSituationProduct(s3);
            assertEquals(products3.size(), 0);
        } catch (IOException e) {
            //e.printStackTrace();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    @org.junit.Test
    public void stockSituationProduct(){
        Product p = new Product(1,"apple","fruit","supplier",5);
        Product p2 = new Product(2,"bananna","fruit","supplier",15);
        Product p3 = new Product(3,"apple","fruit","supplier2",5);
        Product p4 = new Product(4,"strawberry","fruit","metro",5);
        StoreRepository rep = new StoreRepository();

        String s1 = "apple";
        String s2 = "car";
        String s3 = "bananna";

        try{
            rep.addNewProduct(p);
            rep.addNewProduct(p2);
            rep.addNewProduct(p3);
            rep.addNewProduct(p4);
            ArrayList<Product> products1 = rep.stockSituationProduct(s1);
            assertEquals(products1.size(), 2);
            ArrayList<Product> product2 = rep.stockSituationProduct(s2);
            assertEquals(product2.size(),0);
            ArrayList<Product> products3 = rep.stockSituationProduct(s3);
            assertEquals(products3.size(),1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    @org.junit.Test
    public void StockSituation(){
        Product p = new Product(1,"apple","fruit","supplier",5);
        Product p2 = new Product(2,"bananna","fruit","supplier",15);
        Product p3 = new Product(3,"apple","fruit","supplier2",5);
        Product p4 = new Product(4,"strawberry","fruit","metro",5);
        StoreRepository rep = new StoreRepository();

        try{
            ArrayList<Product> products = rep.stockSituation();
            assertEquals(products.size(), 0);
            rep.addNewProduct(p);
            rep.addNewProduct(p2);
            ArrayList<Product> products1 = rep.stockSituation();
            assertEquals(products1.size(), 2);
            rep.addNewProduct(p3);
            rep.addNewProduct(p4);
            ArrayList<Product> product2 = rep.stockSituation();
            assertEquals(product2.size(),4);
        } catch (IOException e) {
            //e.printStackTrace();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    @org.junit.Test
    public void Integration(){
        addNewProduct();
    }

    @org.junit.Test
    public void IntegrationAB(){
        addNewProduct();
        getProductsCategory();
    }

    @org.junit.Test
    public  void IntegrationABC(){
        addNewProduct();
        getProductsCategory();
        stockSituationProduct();
    }
}