module com.example.intellijprojectleenmanbankjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.intellijprojectleenmanbankjavafx to javafx.fxml;
    exports com.example.intellijprojectleenmanbankjavafx;
}