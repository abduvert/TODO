package gui;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

public class Edit implements EventHandler {

    String name,description, store;
    String date;
    int count=0;

    public Edit(String name, String description, String date) {
        this.name = name;
        this.description = description;
        this.date = date;

    }

    @Override
    public void handle(Event event) {
        Taskextend.task.setText(name);
        Taskextend.des.setText(description);
//
        for (HashMap<String, Object> l : AddingTask.tasks) {

            System.out.println("loop me aya");
            if (l.get("description").equals(description)) {
                try {
                    System.out.println("if statement me aya");
                    AddingTask.tasks.remove(l);
                    Task edit = new Task();
                    edit.handle();


                        count++;
                    FileWriter fw = new FileWriter("TaskName.txt",true);
                    fw.write(l.get("username") + "@" + l.get("task") + "_" + description + "]" + l.get("date") + "\n");


                }
                catch(IOException e)
                {
                    System.out.println("Bad");
                }
            }
        }

    }


//    public void confirm(){
//        Text msg = new Text("Restart to get the changes in your task");
//        msg.setFont(Font.font("Gill Sans", FontWeight.BOLD,30));
//        msg.setFill(Color.BLACK);
//        Button conf = new Button("Ok");
//        conf.setStyle("-fx-background-color: #3677BB;-fx-background-radius: 20px;");
//        conf.setTextFill(Color.WHITE);
//        conf.setMinHeight(10);
//        conf.setMinWidth(250);
//
//        GridPane gd = new GridPane();
//        gd.add(msg,0,0);
//        gd.add(conf,0,1);
//        gd.setAlignment(Pos.CENTER);
//        Scene s = new Scene(gd,Paa.width,Paa.height);
//        login.stage.setScene(s);
//
//
//        conf.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                login.stage.close();
//            }
//        });
//    }
}
