package Controller;

import java.io.IOException;
import java.util.ArrayList;

import Repository.StoreRepository;
import Model.MyException;
import Model.Product;

public class StoreController {
    StoreRepository rep =new StoreRepository();
    public void readProducts(String f){
        try {
            rep.readFile(f);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void addProduct(Product p) throws MyException, IOException{
        try {

            rep.addNewProduct(p);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch(MyException e){
            throw new MyException(e.getMessage());
        }
    }
    public ArrayList<Product> getProductsCategory(String cat) throws MyException{
        return rep.getProductsCategory(cat);
    }

    public ArrayList<Product> stockSituationProduct(String pname) throws MyException{
        return rep.stockSituationProduct(pname);
    }
    public ArrayList<Product> stockSituation(){
        return rep.stockSituation();
    }
}
