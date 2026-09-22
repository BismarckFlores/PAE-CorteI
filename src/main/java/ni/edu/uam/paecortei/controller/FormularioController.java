package ni.edu.uam.paecortei.controller;

import ni.edu.uam.paecortei.dao.EmployeeDaoImpl;
import ni.edu.uam.paecortei.models.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class FormularioController {

    // Estos fx:id deben coincidir EXACTO con los del FXML
    @FXML private TextField txtNombres;
    @FXML private TextField txtApellidos;
    @FXML private ComboBox<String> cbCargo;
    @FXML private TextField txtSalario;

    // Se ejecuta automaticamente al cargar la pantalla
    @FXML
    public void initialize() {
        cbCargo.getItems().addAll("Gerente", "Supervisor", "Vendedor", "Cajero", "Bodeguero");
    }

    // Boton "Guardar"
    @FXML
    private void guardar(ActionEvent event) {
        String nombres = txtNombres.getText().trim();
        String apellidos = txtApellidos.getText().trim();
        String cargo = cbCargo.getValue();
        String salarioTexto = txtSalario.getText().trim();

        // Validacion 1: campos vacios
        if (nombres.isEmpty() || apellidos.isEmpty() || cargo == null || salarioTexto.isEmpty()) {
            mostrarAlerta("Debe llenar todos los campos.");
            return;
        }

        // Validacion 2: salario numerico y positivo
        double salario;
        try {
            salario = Double.parseDouble(salarioTexto);
            if (salario <= 0) {
                mostrarAlerta("El salario debe ser mayor que cero.");
                return;
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("El salario debe ser un numero valido (ej. 8500.00).");
            return;
        }

        // Todo valido: se guarda en la lista compartida a través del DAO
        EmployeeDaoImpl.getInstance().save(new Employee(nombres, apellidos, cargo, (float) salario));
        new Alert(Alert.AlertType.INFORMATION, "Empleado guardado correctamente.").showAndWait();
        limpiarCampos();
    }

    // Boton "Limpiar"
    @FXML
    private void limpiar(ActionEvent event) {
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtNombres.clear();
        txtApellidos.clear();
        cbCargo.setValue(null);
        txtSalario.clear();
    }

    // Boton "Ver Listado" -> navegacion al Formulario 2
    @FXML
    private void irAListado(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/uam/empleados/listado.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    private void mostrarAlerta(String mensaje) {
        new Alert(Alert.AlertType.WARNING, mensaje).showAndWait();
    }
}