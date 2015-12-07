package Controllers;


import Models.Class;
import Models.Student;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ClassController implements Initializable {
    @FXML
    public Label classNameLabel;
    @FXML
    public ListView<Student> studentsListView;

    private Stage stage = null;
    private Class c = null;

    public ClassController(Stage stage, Class c) {
        this.stage = stage;
        this.c = c;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.setClassNameLabel();
        this.setStudentsListView();
    }

    public void setClass(Class c) {
        this.c = c;
    }

    private void setClassNameLabel() {
        this.classNameLabel.setText("Nom de la promotion : " + this.c.toString());
    }

    private void setStudentsListView() {
        this.studentsListView.setItems(FXCollections.observableArrayList(this.c.getStudents()));
    }
}
