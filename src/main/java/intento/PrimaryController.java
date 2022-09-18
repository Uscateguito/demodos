package intento;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PrimaryController {

    // Atributos necesarios para conectar los controladores
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField CedulaUsuario;

    @FXML
    private TextField ContraseniaUsuario;

    @FXML
    private Text Notificacion;

    @FXML
    void LogIn(ActionEvent event) {

    }

    @FXML
    void OlvidoContrasenia(ActionEvent event) {

    }

    @FXML
    void SignUp(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("registro.fxml"));
        root = loader.load();
        // Con este objeto puedo ejecutar los métodos del registroController
        RegistroController controladorDelRegistro = loader.getController();
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
