package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Taskextend {
    static Text taskname = new Text("Task Name:");
    static TextField task = new TextField();
    static TextArea des = new TextArea();
    static Text dateText = new Text("Due Date:");

    static Button backk =  new Button("Back");

    Stage stage;
    VBox vb;

    public Taskextend(Stage stage, VBox vb) {
//        this.stage = stage;
//        this.vb = vb;
//        TaskReader read = new TaskReader();
//        read.handle();
    }
}