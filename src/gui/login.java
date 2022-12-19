package gui;


import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import jdk.jfr.TransitionFrom;

import java.awt.*;
import java.util.HashMap;

public class login implements EventHandler {
    TextField t = new TextField();
    PasswordField t1 = new PasswordField();
    Stage stage;
    Scene scn;
    static SplitPane sp = new SplitPane();
    static SplitPane sp2 = new SplitPane();
    int count=0;
    static String a = "";
    Button view = new Button("View tasks");
    Image plus = new Image(getClass().getResourceAsStream("plus.png"));
    Image bcd = new Image(getClass().getResourceAsStream("bck.jpg"));
    ImageView plusview = new ImageView(plus);
    ImageView bcdview = new ImageView(bcd);
    static StackPane vb2 = new StackPane();
    static StackPane vb3 = new StackPane();
    //MenuBar bar = new MenuBar();
    static HBox hb;

    public login(Stage stage, Scene scn, TextField t, PasswordField t1) {
        this.t = t;
        this.t1 = t1;
        this.stage = stage;
        this.scn = scn;
    }


    @Override
    public void handle(Event event) {

        for (HashMap<String, String> l : Paa.usernames) {


                if (!l.get("username").equals(t.getText())) {

                    if (l.get("password").equals(t1.getText())) {
                        stage.setTitle("Incorrect username or password");


                    }
                    if (!l.get("password").equals(t1.getText())) {
                        stage.setTitle("Incorrect password or username");
                    }

                }
                if (l.get("username").equals(t.getText())) {

                    a = l.get("username");
                    if (l.get("password").equals(t1.getText())) {

                            count++;

                        stage.setTitle(l.get("username"));


                        //text for spacing nothing more
                        Text text = new Text();
                        Text text1 = new Text();
                        Text text2 = new Text();
                        text.setFill(Color.WHITE);
                        text.setFont(Font.font("Gill Sans", FontWeight.BOLD, 20));

                        //panes
                        BorderPane bd = new BorderPane();
                        ScrollBar scroll = new ScrollBar();
                        scroll.setVisible(true);
                        scroll.setOrientation(Orientation.VERTICAL);

                        //buttons
                        Button back = new Button("Back");
                        Button task = new Button("+ Create New Task");
                        Button task1 = new Button("My Day");
                        Button task2 = new Button("Important");
                        SplitMenuButton task3 = new SplitMenuButton();
                        task3.setText("Tasks");
                        task1.setMinHeight(30);
                        task1.setMinWidth(150);
                        task1.setShape(new Rectangle(7, 10));
                        task2.setMinHeight(30);
                        task2.setMinWidth(150);
                        task2.setShape(new Rectangle(7, 10));
                        task3.setMinHeight(30);
                        task3.setMinWidth(150);
                        task3.setShape(new Rectangle(7, 10));
                        Button logout = new Button();
                        logout.setText("Logout");
                        logout.setStyle("-fx-background-color: White; -fx-background-radius:10px; -fx-border-color: purple; -fx-border-radius:10px;");


                        //vboxes
                        VBox vb1 = new VBox(back);

                        DropShadow shadow = new DropShadow();

                        //additon into the boxes

                        vb1.setMaxWidth(200);
                        vb1.setMinWidth(150);
                        vb2.setMaxHeight(120);
                        bcdview.setFitHeight(120);
                        vb1.getChildren().add(text);
                        vb1.getChildren().add(task);
                        vb1.getChildren().add(text1);
                        vb1.getChildren().add(text2);

                        vb1.getChildren().add(task1);
                        vb1.setFillWidth(true);
                        vb1.getChildren().add(task2);
                        vb1.getChildren().add(task3);
                        vb2.getChildren().add(bcdview);
                        AnchorPane log = new AnchorPane();
                        log.getChildren().add(logout);
                        log.setLayoutX(200);
                        log.setLayoutY(0.5);
                        vb2.getChildren().add(log);
                        Text et = new Text(" CREATE TO SHOW");
                        et.setFont(Font.font("Gill Sans", FontWeight.BOLD, 25));
                        hb = new HBox(et);
                        hb.setAlignment(Pos.BOTTOM_LEFT);
                        et.setFill(Color.WHITE);
                        vb2.getChildren().add(hb);


                        shadow.setColor(Color.PALEGREEN);

                        task.setStyle("-fx-background-color: White; -fx-background-radius:20px; -fx-border-color: purple; -fx-border-radius:18px;");
                        task1.setStyle("-fx-background-color: White;  -fx-border-color: purple; ");
                        task2.setStyle("-fx-background-color: White;  -fx-border-color: purple; ");
                        task3.setStyle("-fx-background-color: White;  -fx-border-color: purple; ");
                        task.setEffect(shadow);
                        task.setMinHeight(30);
                        task.setMinWidth(150);

                        //split adding
                        sp2.getItems().addAll(vb2, vb3);
                        sp2.setOrientation(Orientation.VERTICAL);
                        sp.getItems().addAll(vb1, sp2);
                        bd.setCenter(sp);


                        back.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                stage.setScene(scn);

                            }
                        });


                        Scene scn1 = new Scene(bd, Paa.width + 50, Paa.height + 50);


                        task.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                Task t = new Task(scn1, vb1, task3);
                                t.handle();
                            }
                        });
                        for (HashMap<String, Object> k : AddingTask.tasks) {
                            System.out.println("entered into the loop");
                            if (k.get("username").equals(l.get("username"))) {

                                String a = (String) k.get("task");
                                String b = (String)k.get("description");

                                Buttonadd ad = new Buttonadd(vb1, a,b);
                                ad.but();
                                hb.getChildren().remove(et);
                                ad.action();

                            }
                        }
                        stage.setScene(scn1);
                        stage.show();
                        break;


                    }
                    if (!l.get("password").equals(t1.getText())) {

                        stage.setTitle("Incorrect Pass");

                    }





            }


        }
    }
}
