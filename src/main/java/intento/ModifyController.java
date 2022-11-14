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

    public Usuarios usuarioXmodificar ;

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
        if ( this.usuarioXmodificar != null ) {
            if ( nombreUsuario.getText() != ""
            || CedulaUsuario.getText() != ""
            || CorreoUsuario.getText() != ""
            || NuevaContraseniaUsuario.getText() != ""
            ) {
                if ( ContraseniaUsuario.getText().equalsIgnoreCase(this.usuarioXmodificar.getContrasenia()) ) {
                    cargarDatosFinales();
                    l.Actualizar(this.usuarioXmodificar);
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

    public void cargarDatosIniciales () {
        // Colocar algunos datos del usuario en la modificación de datos.
        CedulaUsuario.setText(this.usuarioXmodificar.getCedula());
        CorreoUsuario.setText(this.usuarioXmodificar.getCorreoElectronico());
        nombreUsuario.setText(this.usuarioXmodificar.getNombre());
    }

    public void cargarDatosFinales () {
        this.usuarioXmodificar.setCedula(CedulaUsuario.getText());
        this.usuarioXmodificar.setNombre(nombreUsuario.getText());
        this.usuarioXmodificar.setCorreoElectronico(CorreoUsuario.getText());
        this.usuarioXmodificar.setContrasenia(NuevaContraseniaUsuario.getText());
    }

}