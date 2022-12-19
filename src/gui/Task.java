package gui;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Task{

        //Task managing
        Scene scn2;
        Stage stage;
        VBox vb1;
        SplitMenuButton task3;
    Image img = new Image(getClass().getResourceAsStream("bck.jpg"));
    ImageView imageView = new ImageView(img);

        //constructor
        public Task(Scene scn, VBox vb1, SplitMenuButton task3) {

        this.scn2 = scn;
        this.vb1 = vb1;
        this.task3= task3;
        }
        public Task(){}


        public void handle() {

            DatePicker date = new DatePicker();
            Stage stage1 = new Stage();
            Scene scn3;




        //objects
        GridPane gd3 = new GridPane();
        Button add = new Button("Add");
        Button cancel = new Button("Cancel");

        BorderPane b = new BorderPane();
        StackPane stack = new StackPane();
        Taskextend.taskname.setFill(Color.WHITE);
            Taskextend.dateText.setFill(Color.WHITE);
//            HBox hBox = new HBox(backk);
//            hBox.setAlignment(Pos.TOP_LEFT);
            Taskextend.des.setBackground(Background.EMPTY);
//            AddingTask addd = new AddingTask(stage1,scn2,Taskextend.des,Taskextend.task,date,vb1,task3);
//            addd.handle();
            Taskextend.task.setStyle("-fx-border: remove;");
            //adding to grid and border
            gd3.add(Taskextend.taskname,1,1);
            gd3.add(Taskextend.task,1,3);
            gd3.add(Taskextend.des,1,5);
            gd3.add(Taskextend.dateText,1,7);
            gd3.add(date,1,9);
            gd3.add(add,1,11);
            gd3.add(cancel,2,11);
            //b.setTop(hBox);
            gd3.setAlignment(Pos.CENTER);
            b.setCenter(gd3);
            stack.getChildren().add(imageView);
            stack.getChildren().add(b);

    //        backk.setStyle("-fx-background-color:green;");
    //        backk.setTextFill(Color.WHITE);
    //

            add.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    AddingTask add = new AddingTask(stage1,scn2,Taskextend.des,Taskextend.task,date,vb1,task3);
                    add.handle();
                }
            });

            //back button
            cancel.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    stage.close();
                }
            });

            scn3 = new Scene(stack,Paa.width,Paa.height);
            stage1.setScene(scn3);
            stage1.show();

        }
    }
