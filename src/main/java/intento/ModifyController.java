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

public class ModifyController {

    // Atributos necesarios para conectar los controladores
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private TextField CedulaUsuario;

    @FXML
    private TextField ContraseniaUsuario;

    @FXML
    private TextField NuevaContraseniaUsuario;

    @FXML
    private TextField CorreoUsuario;

    @FXML
    private TextField nombreUsuario;

    @FXML
    private Text Notificacion;

    FuncionesCuentaParchado l = new FuncionesCuentaParchado();

    @FXML
    void regresar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ParchadosApp.fxml"));
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

    @FXML
    void modificarBoton(ActionEvent event) {
        // Acciones de modificación.
        if ( PrimaryController.usuario != null ) {
            if ( !nombreUsuario.getText().isEmpty()
            && !CedulaUsuario.getText().isEmpty()
            && !CorreoUsuario.getText().isEmpty()
            && !ContraseniaUsuario.getText().isEmpty()
            ) {
                if ( ContraseniaUsuario.getText().equalsIgnoreCase(PrimaryController.usuario.getContrasenia()) ) {
                    cargarDatosFinales();
                    l.Actualizar(PrimaryController.usuario);
                    System.out.println("modificación exitosa!");
                    Notificacion.setText("Modificación de datos exitosa");
                }else{
                    Notificacion.setText("Credenciales incorrectas");
                }
            } else {
                Notificacion.setText("Por favor llene todos los espacios");
            }
        } else {
            System.out.println("ERROR!");
            this.Notificacion.setText("¡USUARIO NULO!");
        }
    }

    /**
     * Carga los datos iniciales del usuario
     */
    public void cargarDatosIniciales () {
        // Colocar algunos datos del usuario en la modificación de datos.
        CedulaUsuario.setText(PrimaryController.usuario.getCedula());
        CorreoUsuario.setText(PrimaryController.usuario.getCorreoElectronico());
        nombreUsuario.setText(PrimaryController.usuario.getNombre());
    }

    /**
     * Carga los datos finales del usuario
     */
    public void cargarDatosFinales () {
        PrimaryController.usuario.setCedula(CedulaUsuario.getText());        
        PrimaryController.usuario.setNombre(nombreUsuario.getText());
        PrimaryController.usuario.setCorreoElectronico(CorreoUsuario.getText());
        if (!NuevaContraseniaUsuario.getText().isEmpty()||!NuevaContraseniaUsuario.getText().isBlank())
            PrimaryController.usuario.setContrasenia(NuevaContraseniaUsuario.getText());
    }

}