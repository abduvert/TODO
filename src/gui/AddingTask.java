package gui;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import static gui.Paa.usernames;

public class AddingTask{

    Stage stage;
    Stage stage1;
    Scene addscn;
    Scene scn;
    TextField task = new TextField();
    DatePicker date;
    VBox vb1=new VBox();
    String datee[];

    static ArrayList<HashMap<String,Object>> tasks = new ArrayList<>();
    static HashMap<String, Object> taskName = new HashMap<>();
    static ArrayList<String> description = new ArrayList<>();
    static ArrayList<LocalDate> dat = new ArrayList<>();

    TextArea des = new TextArea();
    Button task3;
    static int count=0;
    static String a;
    static String b;
    static String c;



    public AddingTask(Stage stage1,Scene scn, TextArea des ,TextField task, DatePicker date, VBox vb1,Button task3){

        this.stage1 = stage1;
        this.scn = scn;
        this.task = task;
        this.date = date;
        this.des = des;
        this.vb1 = vb1;
        this.task3 = task3;

    }
    public AddingTask(VBox vb1,Stage stage1,TextField task,TextArea des)
    {
        this.vb1 = vb1;
        this.stage1 = stage1;
        this.task = task;
        this.des = des;
    }
//    public AddingTask(Text task, des)
//    {
//
//        this.task = task;
//        this.des = des;
//    }

    public AddingTask(){}



    public void handle() {
        try {
                FileWriter fw = new FileWriter("src/gui/TaskName.txt");

                String tas = "task";
                String de = "description";
                String user = "username";
                taskName.put("task", task.getText());
                taskName.put("description", des.getText());
                taskName.put("username", login.a);
                taskName.put("date", date.getValue());

                tasks.add(taskName);
                System.out.println(usernames);
                taskName = new HashMap<>();


                for(HashMap<String,Object> l : tasks) {

                        count++;
                        fw.write(l.get("username") + "@" + l.get("task") + "_" + l.get("description") +"]"+ l.get("date")+"\n");


                }

            for (HashMap<String, Object> k : AddingTask.tasks) {
                System.out.println("entered into the loop");

                     a = (String)k.get("task");
                     b = (String)k.get("description");



                }

                    Buttonadd ad = new Buttonadd(vb1,a,b,c);
                    ad.but();

            fw.close();
            System.out.println(tasks);
        }
        catch (IOException e)
        {

        }
        stage1.close();
    }


    public void forme()
    {
        System.out.println(tasks);
        System.out.println(description);
        System.out.println(dat);
    }

}
//            if (AddingTask.count% 2 == 0) {
//                task1.setStyle("-fx-background-color: linear-gradient(to bottom left, #3333ff 0%, #66ff99 100%);");
//            } else {
//                task1.setStyle("-fx-background-color: linear-gradient(to top left, #33cc33 0%, #ffff00 100%);");
//            }
//            task1.setShape(new Rectangle(7, 10));
//            vb1.getChildren().add(task1);
//            task1.setMinHeight(30);
//            task1.setMinWidth(150);
//            task1.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent actionEvent) {
//                    TaskReader read = new TaskReader();
//                    read.handle();
//                }
//            });
