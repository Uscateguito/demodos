package intento;

import java.io.IOException;

import controlador.FuncionesCuentaParchado;
import excepciones.InfoIncompleta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Usuarios;

public class PrimaryController {

    // Atributos necesarios para conectar los controladores
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField CedulaUsuario;

    @FXML
    private Text Notificacion;

    @FXML
    private PasswordField ContraseniaUser;

    FuncionesCuentaParchado l = new FuncionesCuentaParchado();

    public static Usuarios usuario ;

    @FXML
    void LogIn(ActionEvent event) throws InfoIncompleta{
        try {
            if(l.iniciarSesion(CedulaUsuario.getText(), ContraseniaUser.getText()) == true){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ParchadosApp.fxml"));
                root = loader.load();
                // Con este objeto puedo ejecutar los métodos del registroController
                ParchadosAppController controladorDelRegistro = loader.getController();
                this.usuario = l.ObtenerPorCedula(CedulaUsuario.getText());
                controladorDelRegistro.mostrarNombre(usuario.getNombre());
                
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }else{
                Notificacion.setText("Los datos ingresados no son correctos");
            }
        } catch (InfoIncompleta e){
            Notificacion.setText(e.getMessage());
        } 
        catch (Exception e) {
            Notificacion.setText("Ingresa valores válidos");
        }
    }

    @FXML
    void OlvidoContrasenia(ActionEvent event) {
        // Por trabajar
    }

    @FXML
    void SignUp(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("registro.fxml"));
        root = loader.load();
        // Con este objeto puedo ejecutar los métodos del registroController
        //RegistroController controladorDelRegistro = loader.getController();
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}