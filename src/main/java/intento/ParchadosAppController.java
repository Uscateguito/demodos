package intento;

import java.io.IOException;

import controlador.FuncionesCuentaParchado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Usuarios;

public class ParchadosAppController {

    // Atributos necesarios para conectar los controladores
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public Text NombreUsuario;
    /**
     * Vuelve a la pantalla inicial
     * @param event
     * @throws IOException
     */

    FuncionesCuentaParchado l = new FuncionesCuentaParchado();

    public Usuarios usuarioGlobal ;

    @FXML
    void ModificarDatos(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modificar.fxml"));
        root = loader.load();
        ModifyController controladorModify = loader.getController();
        controladorModify.usuarioXmodificar = this.usuarioGlobal;
        controladorModify.cargarDatosIniciales();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void Volver(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
            root = loader.load();
            // Con este objeto puedo ejecutar los métodos del registroController
            //RegistroController controladorDelRegistro = loader.getController();  
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("parchados.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * Sirve para mostrar el nombre del usuario que entró a la app
     * @param nombre
     */
    public void mostrarNombre(String nombre){
        NombreUsuario.setText(nombre);
    }

}