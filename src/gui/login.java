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
import javafx.scene.input.DragEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import jdk.jfr.TransitionFrom;

import java.awt.*;
import java.util.HashMap;

public class login implements EventHandler {
    TextField t = new TextField();
    PasswordField t1 = new PasswordField();
    static Stage stage;
    Scene scn;
    static SplitPane sp = new SplitPane();
    static SplitPane sp2 = new SplitPane();
    int count=0;
    static String a = "";

    Button view = new Button("View tasks");
    static Button task2;
    Image plus = new Image(getClass().getResourceAsStream("plus.png"));
    Image bcd = new Image(getClass().getResourceAsStream("bck.jpg"));
    static Text et = new Text(" CREATE TO SHOW");
    ImageView plusview = new ImageView(plus);
    ImageView bcdview = new ImageView(bcd);
    static AnchorPane vb2 = new AnchorPane();
    static AnchorPane vb3 = new AnchorPane();
    Rectangle bac = new Rectangle();
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
                        Text heading = new Text("Tasks:");
                        heading.setFont(Font.font("Gill Sans", FontWeight.BOLD,15));
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
                        task2 = new Button("Trash");
                        Button searchButt = new Button("Search");
                        //search.setPromptText("Search");

                        task1.setStyle("-fx-border-color: #8304D6;-fx-background-color: white;-fx-background-radius: 10px;-fx-border-radius: 8px;");
                        task2.setStyle("-fx-border-color: #8304D6;-fx-background-color: white;-fx-background-radius: 10px;-fx-border-radius: 8px;");
                        task1.setMinHeight(30);
                        task1.setMinWidth(150);
                        //task1.setShape(new Rectangle(7, 10));
                        task2.setMinHeight(30);
                        task2.setMinWidth(150);
                        //task2.setShape(new Rectangle(7, 10));
                        Button logout = new Button();
                        logout.setText("Logout");
                        logout.setStyle("-fx-background-color: White; -fx-background-radius:10px; -fx-border-color: purple; -fx-border-radius:10px;");


                        //vboxes
                        VBox vb1 = new VBox(back);
                        vb1.getChildren().add(text);

                        vb1.getChildren().add(searchButt);


                        DropShadow shadow = new DropShadow();

                        //additon into the boxes

                        vb1.setMaxWidth(200);
                        vb1.setMinWidth(150);
                        vb2.setMaxHeight(120);
                        bcdview.setFitHeight(120);
                        //vb1.getChildren().add(text);
                        vb1.getChildren().add(task);
                        vb1.getChildren().add(text1);
                        vb1.getChildren().add(text2);
                        vb1.getChildren().add(task1);
                        vb1.setFillWidth(true);
                        vb1.getChildren().add(task2);
                        vb1.getChildren().add(heading);
                        HBox log = new HBox();
                        log.getChildren().add(logout);
                        log.setLayoutX(420);
                        log.setLayoutY(0.5);
                        log.setAlignment(Pos.TOP_RIGHT);
                        vb2.getChildren().add(log);
                        et.setFont(Font.font("Gill Sans", FontWeight.BOLD, 25));
                        hb = new HBox(et);
                        hb.setAlignment(Pos.BOTTOM_LEFT);
                        vb2.getChildren().add(hb);
                        et.setFill(Color.WHITE);

                        vb2.setStyle("-fx-background-color:#8C2FE8;");
                        VBox rect = new VBox(bac);
                        rect.setLayoutX(0.5);
                        rect.setLayoutY(150);
                        vb3.getChildren().add(rect);


                        bac.setStroke(Color.rgb(117,34,215));
                        bac.setStrokeLineCap(StrokeLineCap.ROUND);
                        bac.setStrokeLineJoin(StrokeLineJoin.BEVEL);
                        bac.setStrokeType(StrokeType.OUTSIDE);
                        bac.setStrokeWidth(2);
                        bac.setWidth(370);


                        shadow.setColor(Color.PALEGREEN);

                        task.setStyle("-fx-background-color: White; -fx-background-radius:20px; -fx-border-color: purple; -fx-border-radius:18px;");
                        searchButt.setStyle("-fx-background-color: #7522d7;-fx-background-radius:20px; -fx-border-color: purple; -fx-border-radius:18px;");
                        //task1.setStyle("-fx-background-color: White;  -fx-border-color: purple; ");
                        //task2.setStyle("-fx-background-color: White;  -fx-border-color: purple; ");
                        //task3.setStyle("-fx-background-color: White;  -fx-border-color: purple; ");
                        task.setEffect(shadow);
                        searchButt.setEffect(shadow);
                        task.setMinHeight(30);
                        task.setMinWidth(150);
                        searchButt.setMinHeight(30);
                        searchButt.setMinWidth(150);


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
                                Task t = new Task(scn1, vb1, searchButt);
                                t.handle();
                            }
                        });


                        searchButt.setOnAction(new search(stage,scn1));
                        for (HashMap<String, Object> k : AddingTask.tasks) {
                            System.out.println("entered into the loop");
                            if (k.get("username").equals(l.get("username"))) {

                                String a = (String) k.get("task");
                                String b = (String)k.get("description");
                                String c = (String)k.get("date");

                                Buttonadd ad = new Buttonadd(vb1, a,b,c);
                                ad.but();
                                hb.getChildren().remove(et);

                            }
                        }


                        logout.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                stage.close();
//                                stage.setScene(scn);
//
//                                Paa.tf.setText("");
//                                Paa.tf1.setText("");
//                                Paa.tf2.setText("");
//                                stage.setTitle("Use an Account");

                            }
                        });



                        task1.setOnAction(new MyDay());
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
