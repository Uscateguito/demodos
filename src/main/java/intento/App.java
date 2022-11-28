package intento;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    /**
     * Arranca la aplicación de JavaFX
     * @param primaryStage Esenario principal de la aplicación 
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));
            Scene scene = new Scene(root);
            //scene.getStylesheets().add(getClass().getResource("parchados.css").toExternalForm());

            // Le indicamos uno de los estilos que vamos a utilizar en el front-end
            // String css = this.getClass().getResource("parchados.css").toExternalForm();
            primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("logoParche.png")));
            primaryStage.setTitle("Parchados");
            primaryStage.setScene(scene);
            primaryStage.show(); 
        } catch (Exception e) {
            // TODO: handle exception
        }        
    }

    /**
     * Metodo principal de la aplicacion
     * @param args Recibe los argumentos con los que se llama la aplicacion
     */
    public static void main(String[] args) {
        launch(args);
    }

}
