module com.example.calculatorusingcursorarraystack {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calculatorusingcursorarraystack to javafx.fxml;
    exports com.example.calculatorusingcursorarraystack;
}