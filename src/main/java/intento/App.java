package intento;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import controlador.FuncionesCuentaParchado;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        System.out.println( "Hello World!" );
        FuncionesCuentaParchado l = new FuncionesCuentaParchado();
        l.cargarUsuarios();
        l.leer();
        //l.crearUsuario(new Usuarios("Juan", "5", "correoElectronico", "contrasenia"));
        //l.crearUsuario(new Usuarios("Simon", "6", "correoElectronico", "contrasenia"));
        //l.EliminarPorCedula("1");
        //l.Actualizar(new Usuarios("Rigoberto", "5", "jiji", "456"));
        launch();
    }

}