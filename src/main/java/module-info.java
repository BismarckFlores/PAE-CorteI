module ni.edu.uam.paecortei {
    requires javafx.controls;
    requires javafx.fxml;


    opens ni.edu.uam.paecortei to javafx.fxml;
    exports ni.edu.uam.paecortei;
}