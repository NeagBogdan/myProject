package MyFirstMavenProject;

import Controller.StoreController;
import Ui.StoreUI;

/**
 * Hello world!
 *
 */
public class App 
{
    public static StoreController ctrl = new StoreController();
    public static StoreUI ui = new StoreUI(ctrl);
    public static void main( String[] args )
    {
        ui.run();
    }
}
