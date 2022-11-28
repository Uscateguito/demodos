package intento;

import controlador.FuncionesCuentaParchado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Usuarios;

public class RegistroController {

    // Atributos necesarios para conectar los controladores
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField CedulaUsuario;

    @FXML
    private TextField ContraseniaUsuario;

    @FXML
    private TextField CorreoUsuario;

    @FXML
    private TextField nombreUsuario;

    @FXML
    private Text Notificacion;

    FuncionesCuentaParchado l = new FuncionesCuentaParchado();

    @FXML
    void Volver(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
            root = loader.load();
            // Con este objeto puedo ejecutar los métodos del registroController
            // RegistroController controladorDelRegistro = loader.getController();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("parchados.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @FXML
    void registroBoton(ActionEvent event) {
        Usuarios x = l.ObtenerPorCedula(CedulaUsuario.getText());
        if (x == null && nombreUsuario.getText() != "" && CedulaUsuario.getText() != "" &&
                CorreoUsuario.getText() != "" && ContraseniaUsuario.getText() != "") {
            l.crearUsuario(new Usuarios(nombreUsuario.getText(), CedulaUsuario.getText(), CorreoUsuario.getText(),
                    ContraseniaUsuario.getText()));
        } else if (x != null) {
            Notificacion.setText("Ya un usuario está registrado con esta cédula");
        } else {
            Notificacion.setText("Por favor llene todos los espacios");
        }
    }

}