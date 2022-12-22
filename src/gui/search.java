package gui;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.util.HashMap;

public class search implements EventHandler {

    Stage stage;
    Button back = new Button("Back");
    TextField se = new TextField();
    Button sch = new Button("Search");
    Scene scene,scene1,scene2;
    int x=190;
    int y=180;
    String a;
    String b;
    String c;

    public search(Stage stage,Scene scene) {
        this.scene = scene;
        this.stage = stage;
    }

    @Override
    public void handle(Event event) {
        AnchorPane gd = new AnchorPane();
        HBox hb = new HBox(se);
        HBox hb1 = new HBox();
        VBox vb = new VBox();
        se.setPromptText("Search by Task Name");
        hb.setAlignment(Pos.CENTER);
        sch.setStyle("-fx-background-color: #7522d7;-fx-background-radius:20px; -fx-border-color: purple; -fx-border-radius:18px;");
        hb.setFocusTraversable(false);
        hb1.setLayoutX(0.5);
        hb1.setLayoutY(0.5);
        hb.setLayoutX(x);
        hb.setLayoutY(y);
        se.setStyle("-fx-border-color:#7522d7;-fx-background-radius: 20px;-fx-border-radius: 18px;");



        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(scene);

            }
        });


        sch.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                for(HashMap<String,Object> k: AddingTask.tasks) {
                        int count=35;
                    if (k.get("task").equals(se.getText()) && login.a.equals(k.get("username"))) {
                        count+=35;
                        System.out.println(k.get("task"));
                        a = (String)k.get("task");
                        b = (String)k.get("description");
                        c = (String)k.get("date");

                        Text name = new Text(a);
                        Text des = new Text(b);
                        Text date = new Text("Due Date: "+c);
                        Button main = new Button("Return to the home page");
                        main.setStyle("-fx-background-color: #3677BB;-fx-background-radius: 20px;");
                        main.setTextFill(Color.WHITE);
                        main.setMinHeight(10);
                        main.setMinWidth(250);
                        name.setFont(Font.font("Gill Sans", FontWeight.BOLD,20));
                        des.setFont(Font.font("Gill Sans", FontWeight.SEMI_BOLD,13));
                        date.setFont(Font.font("Gill Sans", FontWeight.SEMI_BOLD,13));
                        name.setFill(Color.rgb(20,110,235));
                        GridPane grid = new GridPane();
                        VBox vbox =new VBox();
                        vbox.getChildren().add(name);
                        vbox.getChildren().add(des);
                        vbox.getChildren().add(date);
                        vbox.getChildren().add(main);
                        grid.add(vbox,0,1);
                        grid.setVgap(2);
                        grid.setAlignment(Pos.CENTER);
                        Scene searched = new Scene(grid,Paa.width,Paa.height);
                        stage.setScene(searched);

                        main.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                stage.setScene(scene);
                            }
                        });



                    }
                    if((!k.get("task").equals(se.getText()) && login.a.equals(k.get("username"))) || (k.get("task").equals(se.getText()) && !login.a.equals(k.get("username"))))
                    {
                        Text msg = new Text("No results found!");
                        msg.setFont(Font.font("Gill Sans", FontWeight.BOLD,30));
                        msg.setFill(Color.BLACK);
                        Button conf = new Button("Ok");
                        conf.setStyle("-fx-background-color: #3677BB;-fx-background-radius: 20px;");
                        conf.setTextFill(Color.WHITE);
                        conf.setMinHeight(10);
                        conf.setMinWidth(250);

                        GridPane gd = new GridPane();
                        gd.add(msg,0,0);
                        gd.add(conf,0,1);
                        gd.setAlignment(Pos.CENTER);
                       scene1 = new Scene(gd,Paa.width,Paa.height);
                        stage.setScene(scene1);


                        conf.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                stage.setScene(scene2);
                            }
                        });
                    }
                }
            }
        });

        hb.getChildren().add(sch);
        gd.getChildren().add(vb);
        hb1.getChildren().add(back);
        hb1.setAlignment(Pos.TOP_LEFT);
        gd.getChildren().add(hb1);
        gd.getChildren().add(hb);

        scene2 = new Scene(gd,Paa.width,Paa.height);
        stage.setScene(scene2);
        a=null;
        b=null;
        c=null;
    }
}
