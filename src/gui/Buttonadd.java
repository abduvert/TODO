package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Buttonadd {
    int count = 0;
    VBox vb1;
    String a;
    String b;
    Button task1;

    public Buttonadd(VBox vb1,String a,String b) {
        this.vb1 = vb1;
        this.a= a;
        this.b= b;
    }

    public Buttonadd() {

    }

    public void but() {

            task1 = new Button("Number" + a);
        if (AddingTask.count % 2 == 0) {
            task1.setStyle("-fx-background-color: linear-gradient(to bottom left, #3333ff 0%, #66ff99 100%);");
        } else {
            task1.setStyle("-fx-background-color: linear-gradient(to top left, #33cc33 0%, #ffff00 100%);");
        }
        task1.setShape(new Rectangle(7, 10));

            vb1.getChildren().add(task1);
            task1.setMinHeight(30);
            task1.setMinWidth(150);

    }


    public void action()
    {

            task1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                        System.out.println("button chalu hai");
                        Text name = new Text(a);
                        Text dess = new Text(b);
                        name.setFill(Color.WHITE);
                        name.setFont(Font.font("Gill Sans", FontWeight.BOLD,25));
                        login.hb = new HBox(name);
                        login.vb2.getChildren().add(login.hb);
                        login.vb3.getChildren().add(dess);
                }
            });
    }
}
