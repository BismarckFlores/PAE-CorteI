package ni.edu.uam.paecortei.controller;

import ni.edu.uam.paecortei.model.Datos;
import ni.edu.uam.paecortei.model.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class ListadoController {

    // Estos fx:id deben coincidir EXACTO con los del FXML
    @FXML private TableView<Empleado> tablaEmpleados;
    @FXML private TableColumn<Empleado, String> colNombres;
    @FXML private TableColumn<Empleado, String> colApellidos;
    @FXML private TableColumn<Empleado, String> colCargo;
    @FXML private TableColumn<Empleado, Double> colSalario;

    @FXML
    public void initialize() {
        // Conecta cada columna con el getter correspondiente en Empleado
        colNombres.setCellValueFactory(new PropertyValueFactory<>("nombres"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        colCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        colSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));

        // La tabla muestra siempre la lista compartida (se actualiza sola)
        tablaEmpleados.setItems(Datos.LISTA_EMPLEADOS);
    }

    // Boton "Nuevo Empleado" -> navegacion de regreso al Formulario 1
    @FXML
    private void irAFormulario(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/uam/empleados/formulario.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}