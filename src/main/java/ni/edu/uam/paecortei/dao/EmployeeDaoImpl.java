package ni.edu.uam.paecortei.dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ni.edu.uam.paecortei.models.Employee;

import java.util.Optional;

public class EmployeeDaoImpl implements Dao<Employee, String> {

    private static final EmployeeDaoImpl INSTANCE = new EmployeeDaoImpl();

    // Lista observable para almacenar los empleados en memoria.
    // Al ser ObservableList, el TableView (UI) se actualizará automáticamente cuando agreguemos datos.
    private final ObservableList<Employee> employeeList;

    private EmployeeDaoImpl() {
        this.employeeList = FXCollections.observableArrayList();
    }

    public static EmployeeDaoImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public ObservableList<Employee> listing() {
        return employeeList;
    }

    @Override
    public Optional<Employee> searchByID(String id) {
        return employeeList.stream()
                .filter(employee -> employee.getId() != null && employee.getId().equalsIgnoreCase(id))
                .findFirst();
    }

    @Override
    public void save(Employee entity) {
        employeeList.add(entity);
    }

    @Override
    public boolean refresh(String id, Employee entity) {
        Optional<Employee> existingEmployee = searchByID(id);
        if (existingEmployee.isPresent()) {
            int index = employeeList.indexOf(existingEmployee.get());
            employeeList.set(index, entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        Optional<Employee> existingEmployee = searchByID(id);
        if (existingEmployee.isPresent()) {
            employeeList.remove(existingEmployee.get());
            return true;
        }
        return false;
    }
}
