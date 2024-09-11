module org.example.java_practice {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.java_practice to javafx.fxml;
    exports org.example.java_practice;
}