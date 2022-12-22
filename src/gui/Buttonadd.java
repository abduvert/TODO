package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Buttonadd {
    int count = 0;
    VBox vb1 = new VBox();
    HBox hb1;
    HBox hb2;
    HBox c;
    String a;
    String b;
    String cc;
    static Button task1;
    Button edit;

    public Buttonadd(VBox vb1,String a,String b,String cc) {
        this.vb1 = vb1;
        this.a= a;
        this.b= b;
        this.cc= cc;
    }

    public Buttonadd() {

    }

    public void but() {

            task1 = new Button(a);
        if (AddingTask.count % 2 == 0) {
            task1.setStyle("-fx-border-color: #8304D6;-fx-background-color: white;-fx-background-radius: 10px;-fx-border-radius: 8px;");
        } else {
            task1.setStyle("-fx-border-color: #E398D3;-fx-background-color: white;-fx-background-radius: 10px;-fx-border-radius: 8px;");
        }


            vb1.getChildren().add(task1);
            task1.setMinHeight(30);
            task1.setMinWidth(150);
            login.vb2.getChildren().remove(login.hb);
            login.vb3.getChildren().remove(hb1);
            login.vb3.getChildren().remove(hb2);
            login.vb3.getChildren().remove(c);
            c=new HBox();
            action();

    }


    public void action()
    {
        String choices[] = {"Completed","In-progress","Important","Delete"};

            task1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    //edit button
                    edit = new Button("Edit");
                    edit.setStyle("-fx-background-color: #7522d7;-fx-background-radius:20px; -fx-border-color: purple; -fx-border-radius:18px;");

                    //hboxes
                    login.hb = new HBox();
                    login.hb.getChildren().remove(login.et);
                    hb1 = new HBox();
                    hb2 = new HBox();
                    c = new HBox();


                    //anchorpanes from the login class
                    login.vb2.setStyle("-fx-background-color:#93C684");


                    //text for displaying the strings
                    Text name = new Text(a);
                    Text dess = new Text(b);
                    Text date = new Text(cc);

                    //choice box and its hbox
                    Button delete = new Button("Delete");
                    delete.setStyle("-fx-background-color: #CD0E0E;-fx-background-radius:20px; -fx-border-color: purple; -fx-border-radius:18px;");
                    delete.setTextFill(Color.WHITE);


                    c.getChildren().add(delete);
                    c.setLayoutX(0.5);
                    c.setLayoutY(215);
                    c.setAlignment(Pos.BOTTOM_LEFT);
                    c.setStyle("-fx-border-color: #8304D6;-fx-background-color: white;");


                    //properties

                    //text
                    name.setFill(Color.BLACK);
                    name.setFont(Font.font("Gill Sans", FontWeight.BOLD, 30));
                    dess.setFont(Font.font("Gill Sans", FontWeight.MEDIUM, 14));

                    //login hbox
                    login.hb.setLayoutX(1);
                    login.hb.setLayoutY(97);
                    login.hb.getChildren().add(name);
                    login.hb.getChildren().add(edit);
                    hb1.getChildren().add(dess);
                    hb2.getChildren().add(date);
                    hb1.setLayoutX(1);
                    hb1.setLayoutY(25);
                    hb2.setLayoutX(1);
                    hb2.setLayoutY(50);

                    //button
                    edit.setLayoutX(620);
                    edit.setLayoutY(250);

                    //anchorpane add
                    login.vb2.getChildren().add(login.hb);
                    login.vb3.getChildren().add(c);
                    login.vb3.getChildren().add(hb1);
                    login.vb3.getChildren().add(hb2);


                            edit.setOnAction(new Edit(name.getText(), dess.getText(), date.getText()));
                    delete.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            Stage del = new Stage();
                            Text msg = new Text("Move to trash?");
                            msg.setFont(Font.font("Gill Sans", FontWeight.BOLD, 30));
                            msg.setFill(Color.BLACK);
                            Button yes = new Button("Yes");
                            Button no = new Button("No");
                            yes.setStyle("-fx-background-color: #3677BB;-fx-background-radius: 20px;");
                            yes.setTextFill(Color.WHITE);
                            yes.setMinHeight(10);
                            yes.setMinWidth(150);
                            no.setStyle("-fx-background-color: #3677BB;-fx-background-radius: 20px;");
                            no.setTextFill(Color.WHITE);
                            no.setMinHeight(10);
                            no.setMinWidth(150);

                            GridPane gd = new GridPane();
                            gd.add(msg, 0, 0);
                            gd.add(yes, 0, 1);
                            gd.add(no, 1, 1);
                            gd.setHgap(4);
                            gd.setAlignment(Pos.CENTER);

                            Scene delsc = new Scene(gd, 300, 300);
                            del.setScene(delsc);
                            del.show();


                            //yes.setOnAction(new Delete(a,b,cc));




                        }
                    });
                }
            });
            }
    }

