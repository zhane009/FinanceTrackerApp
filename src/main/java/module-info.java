module com.zhane.financetrackerapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.zhane.financetrackerapp to javafx.fxml;
    exports com.zhane.financetrackerapp;
}