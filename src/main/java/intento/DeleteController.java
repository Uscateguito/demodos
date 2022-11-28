package intento;

import controlador.FuncionesCuentaParchado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DeleteController {

    // Atributos necesarios para conectar los controladores
    private Stage stage;
    private Scene scene;
    private Parent root;

    FuncionesCuentaParchado l = new FuncionesCuentaParchado();

    @FXML
    private Text NombreUsuario;

    @FXML
    void Afirmativo(ActionEvent event) {
        System.out.println("SÍ.");
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
            l.EliminarPorCedula(PrimaryController.usuario.getCedula());
            // Eliminar usuario
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @FXML
    void Cancelar(ActionEvent event) {
        System.out.println("NO.");
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

    /**
     * Sirve para mostrar el nombre del usuario que entró a la app
     * @param nombre Nombre del usuario
     */
    public void mostrarNombre(String nombre){
        NombreUsuario.setText(nombre);
    }

}