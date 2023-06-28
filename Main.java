package main;

import Model.InHousePart;
import Model.Inventory;
import Model.OutsourcedPart;
import Model.Product;
import View_Controller.mainMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** This is the Main class of the GUI Application. */
public class Main extends Application {

    /** This pulls up the starting GUI main menu screen.
     * @param window The window of the GUI.
     */
    @Override
    public void start(Stage window) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View_Controller/mainForm.fxml"));
        mainMenuController controller = new mainMenuController();
        loader.setController(controller);

        // Loads the FXML file.
        Parent root = loader.load();

        // Builds the scene graph with window length/width arguments
        Scene scene = new Scene(root, 1100, 450);

        // Display the window using scene graph
        window.setTitle("Inventory System");
        window.setScene(scene);
        window.show();
    }

    /***
     * This includes the dummy data when the GUI pops, and this also launches the program.
     * @param args - the Main method
     */
    public static void main(String[] args) {
        // Creates dummy data to the Parts table view
        InHousePart part1 = new InHousePart(1, "Brakes", 14.99, 5, 5,10, 100);
        InHousePart part2 = new InHousePart(2, "Wheel", 10.99, 16, 5,20, 101);
        OutsourcedPart part3 = new OutsourcedPart(3, "Seat", 14.99, 10, 5,15, "Buckle");

        // Adds the dummy data of Part objects to the ObservableList
        Inventory.addPart(part1);
        Inventory.addPart(part2);
        Inventory.addPart(part3);

        // Creates dummy data to the Products table view
        Product product1 = new Product(1000, "Giant Bike", 299.99, 5, 2, 10);
        Product product2 = new Product(1001, "Tricycle", 99.99, 3, 2, 10);

        // Adds the dummy data of Product objects to the ObservableList
        Inventory.addProduct(product1);
        Inventory.addProduct(product2);

        // Adds associated parts to the Product objects
        product1.addAssociatedPart(part1);
        product2.addAssociatedPart(part1);
        product2.addAssociatedPart(part2);

        // Launches GUI program
        launch(args);
    }
}
