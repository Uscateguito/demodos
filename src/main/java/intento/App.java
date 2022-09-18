package intento;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));
            Scene scene = new Scene(root);
            //scene.getStylesheets().add(getClass().getResource("parchados.css").toExternalForm());
            String css = this.getClass().getResource("parchados.css").toExternalForm();
            scene.getStylesheets().add(css);
            // primaryStage.getIcons().add(new Image("logoParche.png"));
            primaryStage.setTitle("Parchados");
            primaryStage.setScene(scene);
            primaryStage.show(); 
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        // Animación del botón, comentable
        //scene.getStylesheets().add(getClass().getResource("alejotheme.css").toExternalForm());  
        
    }

    public static void main(String[] args) {
        /* l.leer();
        l.crearUsuario(new Usuarios("Juan", "5", "correoElectronico", "contrasenia"));
        l.crearUsuario(new Usuarios("Simon", "6", "correoElectronico", "contrasenia"));
        l.EliminarPorCedula("1");
        l.Actualizar(new Usuarios("Rigoberto", "5", "jiji", "456")); */
        launch(args);
    }

}