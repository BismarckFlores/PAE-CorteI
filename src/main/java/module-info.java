module ni.edu.uam.paecortei {
    requires javafx.controls;
    requires javafx.fxml;

    opens ni.edu.uam.paecortei to javafx.fxml;
    opens ni.edu.uam.paecortei.controller to javafx.fxml;

    exports ni.edu.uam.paecortei;
    exports ni.edu.uam.paecortei.controller;
    exports ni.edu.uam.paecortei.models;
    exports ni.edu.uam.paecortei.dao;
}